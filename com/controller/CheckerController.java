package com.controller;

import com.model.dto.CustomerDTO;
import com.service.serviceinterface.CustomerMasterServiceInterface;
import com.service.serviceinterface.CustomerTempServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;


@Controller
public class CheckerController {
    @Autowired
    private CustomerTempServiceInterface tempService;
    @Autowired
    private CustomerMasterServiceInterface masterService;
    @Autowired
    CustomerDTO customerDTO;

    @RequestMapping("/checker")
    public ModelAndView displayCustomerTempRecords(Model model){
        ModelAndView modelAndView = new ModelAndView("displayTempRecords");
        model.addAttribute("customers", tempService.getCustomers());
        return modelAndView;
    }

    @RequestMapping("/approveRecord")
    public ModelAndView approveRecord(Model model, @RequestParam("customerCode") String customerCode, Principal principal){
        customerDTO = tempService.getById(customerCode);

        // setting record status
        if(customerDTO.getRecordStatus().equals("N") || customerDTO.getRecordStatus().equals("M")){
            // update in master table
            customerDTO.setRecordStatus("A");
            customerDTO.setAuthorizedDate(Date.valueOf(LocalDate.now()));
            customerDTO.setAuthorizedBy(principal.getName());
            masterService.saveOrUpdate(customerDTO);
        }
        else if(customerDTO.getRecordStatus().equals("D")){
            //delete the record from the master table
            masterService.delete(customerDTO);
        }
        else{
            //log error
            System.out.println("Record status: "+customerDTO.getRecordStatus());
        }

        tempService.delete(customerDTO);

        model.addAttribute("customers", tempService.getCustomers());
        return new ModelAndView("displayTempRecords");
    }

    @RequestMapping("/rejectRecord")
    public ModelAndView rejectRecord(Model model, @RequestParam("customerCode") String customerCode, Principal principal){
        customerDTO = tempService.getById(customerCode);

        customerDTO.setRecordStatus(customerDTO.getRecordStatus()+"R");
        customerDTO.setAuthorizedDate(Date.valueOf(LocalDate.now()));
        customerDTO.setAuthorizedBy(principal.getName());

        tempService.update(customerDTO);


        model.addAttribute("customers", tempService.getCustomers());
        return new ModelAndView("displayTempRecords");
    }

    @RequestMapping("/show")
    public ModelAndView displayTempRecords(Model model){
        ModelAndView modelAndView = new ModelAndView("show");
        model.addAttribute("customers", tempService.getCustomers());
        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logoutPage(){
        return new  ModelAndView("logout");
    }

}
