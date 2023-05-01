package com.controller;

import com.model.dto.CustomerDTO;
import com.service.GenerateCustomerIdService;
import com.service.MakeDtoObjService;
import com.service.ValidateService;
import com.service.serviceinterface.CustomerMasterServiceInterface;
import com.service.serviceinterface.CustomerTempServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.security.Principal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MakerController {
    @Autowired
    private CustomerTempServiceInterface tempService;
    @Autowired
    private CustomerMasterServiceInterface masterService;
    @Autowired
    private ValidateService validateRecords;
    @Autowired
    private MakeDtoObjService makeDtoObjService;
    @Autowired
    private GenerateCustomerIdService generateCustomerIdService;
    private static final Logger logger = LogManager.getLogger(MakerController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        // true passed to CustomDateEditor constructor means convert empty String to null
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping(value = {"/maker","/registerCustomer"})
    public String form(Model model){
        model.addAttribute("customerDto",new CustomerDTO());
        return "form";
    }

    @PostMapping(value = "/registerCustomer")
    public String registerCustomer(@Valid @ModelAttribute("customerDto") CustomerDTO customerDTO, BindingResult bindingResult, Model model, Principal principal){
        if(bindingResult.hasErrors()){
            return "form";
        }
        else{
            if(validateRecords.codeExists(customerDTO.getCustomerCode())){
                return "codeExists";
            }

            // setting id
            customerDTO.setCustomerId(generateCustomerIdService.generatedId());

            // setting other properties
            customerDTO.setCreateDate(Date.valueOf(LocalDate.now()));
            customerDTO.setCreatedBy(principal.getName());
            customerDTO.setRecordStatus("N");

            //saving in temp table
            tempService.save(customerDTO);
            return "redirect:/displayCustomer";
        }
    }

    @RequestMapping("/displayCustomer")
    public ModelAndView displayCustomer(Model model){
        List<CustomerDTO> tempCustomers = tempService.getCustomers();
        List<CustomerDTO> masterCustomers = masterService.getCustomers();
        ModelAndView modelAndView = new ModelAndView("success");
        model.addAttribute("customers", tempCustomers);
        model.addAttribute("masterCustomers", masterCustomers);
        return modelAndView;
    }

    @RequestMapping("/updatePage")
    public ModelAndView update(Model model, @RequestParam("customerCode") String customerCode){
        CustomerDTO customerDTO1 = tempService.getById(customerCode);
        CustomerDTO customerDTO2 = masterService.getById(customerCode);

        if(customerDTO1!=null){
            model.addAttribute("customerDto", customerDTO1);
            model.addAttribute("code",customerDTO1.getCustomerCode());
        }
        else{
            model.addAttribute("customerDto", customerDTO2);
            model.addAttribute("code",customerDTO2.getCustomerCode());
        }
        return new ModelAndView("updateForm");
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(@Valid @ModelAttribute("customerDto") CustomerDTO customerDTO, @ModelAttribute("code") String code, BindingResult bindingResult, Model model, Principal principal){
        System.out.println("update customer: "+ customerDTO + " code: "+code);
//        customerDTO.setCustomerCode(code);
        if(bindingResult.hasErrors()){
            // use logger -> bindingResult.getAllErrors()
            logger.info("Customer details can't be updated due to the following errors:");
            List<ObjectError> errors = bindingResult.getAllErrors();
            int i = 0;
            for(ObjectError e: errors){
                // check if logger.error can be used
                String str = "\n" + i + " " + e;
                logger.info(str);
            }
            return "updateForm";
        }

        if(customerDTO.getRecordStatus().equals("A") || customerDTO.getRecordStatus().equals("MR")){
            // set record status to "M" in temp table
            customerDTO.setRecordStatus("M");
        }
        else if(customerDTO.getRecordStatus().equals("NR")){
            // set record status to "N" in temp table
            customerDTO.setRecordStatus("N");
        }
        customerDTO.setModifiedDate(Date.valueOf(LocalDate.now()));
        customerDTO.setModifiedBy(principal.getName());
        System.out.println("dto: "+customerDTO);
        tempService.saveOrUpdate(customerDTO);
        model.addAttribute("customers", tempService.getCustomers());
        model.addAttribute("masterCustomers", masterService.getCustomers());

        return "redirect:displayCustomer";
    }

    @RequestMapping("/deletePage")
    public ModelAndView deleteCustomer(Model model, @RequestParam("customerCode") String customerCode){
        CustomerDTO customerDTO1 = tempService.getById(customerCode);
        CustomerDTO customerDTO2 = masterService.getById(customerCode);

        if(customerDTO1!=null){
            // record exists in temp table
            if(customerDTO1.getRecordStatus().equals("N") || customerDTO1.getRecordStatus().equals("M") || customerDTO1.getRecordStatus().equals("NR") || customerDTO1.getRecordStatus().equals("MR") || customerDTO1.getRecordStatus().equals("DR")){
                //hard delete from temp table
                tempService.delete(customerDTO1);
            }
        }
        else{
            // record exists in master table
            //set record status to "D" in temp table
            customerDTO2.setRecordStatus("D");
            tempService.saveOrUpdate(customerDTO2);
        }
        return new ModelAndView("redirect:displayCustomer");
    }

    @RequestMapping("/display")
    public ModelAndView display(Model model){
        List<CustomerDTO> tempCustomers = tempService.getCustomers();
        List<CustomerDTO> masterCustomers = masterService.getCustomers();
        ModelAndView modelAndView = new ModelAndView("displayPage");
        model.addAttribute("customers", tempCustomers);
        model.addAttribute("masterCustomers", masterCustomers);
        return modelAndView;
    }

    @RequestMapping("/fileUpload")
    public ModelAndView fileUpload(Model model){
        return new ModelAndView("fileUpload");
    }



    @PostMapping(value = "/uploadFile")
    public ModelAndView uploaded(@RequestParam("submittedFile") CommonsMultipartFile file, HttpSession httpSession, Model model)
    {
        byte[] data = file.getBytes();

        String filePath = (httpSession.getServletContext().getRealPath("/")).substring(0,49) + "resources/fileuploads/" + file.getOriginalFilename();

        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(data);

            model.addAttribute("filePath", filePath);
            return new ModelAndView("redirect:fetchRecords");
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("error");
        }
    }

    @RequestMapping(value = "/fetchRecords")
    public ModelAndView fetchRecords(@ModelAttribute("filePath") String filePath,  Model model, Principal principal){
        List<String> arr;
        String str;
        ArrayList<CustomerDTO> customers = new ArrayList<>();

        try(FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while ((str = bufferedReader.readLine()) != null) {
                arr = new ArrayList<>(Arrays.asList(str.split("~", str.length())));

                if(validateRecords.validate(arr)){
                    customers.add(makeDtoObjService.makeObj(arr));
                }
            }
            model.addAttribute("cust", customers);
            for(CustomerDTO c: customers){
                // setting id
                c.setCustomerId(generateCustomerIdService.generatedId());

                // setting other properties
                c.setCreateDate(Date.valueOf(LocalDate.now()));
                c.setCreatedBy(principal.getName());
                c.setRecordStatus("N");

                //saving in temp table
                tempService.save(c);
            }
            return new ModelAndView("redirect:/displayCustomer");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("error");
        }
    }
}
