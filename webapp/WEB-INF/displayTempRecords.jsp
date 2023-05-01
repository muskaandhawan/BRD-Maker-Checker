<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.model.dto.CustomerDTO,java.util.List" %>

<html>
    <head>
        <title>Customer Records</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <style>
            .error
            {
            color: #fff;
            padding:6px;
            font-weight: bold;
            }

            /* table {
              width: 100%;
              border-collapse: collapse;
            }

            table, td, th {
              border: 1px solid;
            } */
        </style>
    </head>

    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="home"><i class='fas fa-chalkboard-teacher'></i> Dashboard </a>
                <a class="navbar-brand" href="logout">Logout &nbsp;<i class='fas fa-user-alt'></i></a>
            </div>
        </nav>

        <div style="margin-top:80px">

            <%!
                List<CustomerDTO> customers;
            %>
            <%
                customers = (List<CustomerDTO>) request.getAttribute("customers");
            %>

            <table class="table table-striped table-hover">
                <tr>
                    <th>CUSTOMER ID</th>
                    <th>CUSTOMER CODE</th>
                    <th>CUSTOMER NAME</th>
                    <th>CUSTOMER ADDRESS1</th>
                    <th>CUSTOMER ADDRESS2</th>
                    <th>CUSTOMER PIN CODE</th>
                    <th>EMAIL ADDRESS</th>
                    <th>CONTACT NUMBER</th>
                    <th>PRIMARY CONTACT PERSON</th>
                    <th>RECORD STATUS</th>
                    <th>ACTIVE INACTIVE FLAG</th>
                    <th>CREATED DATE</th>
                    <th>CREATED BY</th>
                    <th>MODIFIED DATE</th>
                    <th>MODIFIED BY</th>
                    <th>AUTHORIZED DATE</th>
                    <th>AUTHORIZED BY</th>
                    <th>ACTION</th>
                </tr>

                <%
                    for(CustomerDTO c: customers){
                        if(!(c.getRecordStatus().endsWith("R"))){
                %>

                <tr>
                    <td>
                    <%= c.getCustomerId() %>
                    </td>
                    <td>
                        <%= c.getCustomerCode() %>
                    </td>
                    <td>
                        <%= c.getCustomerName() %>
                    </td>
                    <td>
                        <%= c.getCustomerAddress1() %>
                    </td>
                    <td>
                        <%= c.getCustomerAddress2() %>
                    </td>
                    <td>
                        <%= c.getCustomerPinCode() %>
                    </td>
                    <td>
                        <%= c.getEmailAddress() %>
                    </td>
                    <td>
                        <%= c.getContactNumber() %>
                    </td>
                    <td>
                        <%= c.getPrimaryContactPerson() %>
                    </td>
                    <td>
                        <%= c.getRecordStatus() %>
                    </td>
                    <td>
                        <%= c.getActiveInactiveFlag() %>
                    </td>
                    <td>
                        <%= c.getCreateDate() %>
                    </td>
                    <td>
                        <%= c.getCreatedBy() %>
                    </td>
                    <td>
                        <%= c.getModifiedDate() %>
                    </td>
                    <td>
                        <%= c.getModifiedBy() %>
                    </td>
                    <td>
                        <%= c.getAuthorizedDate() %>
                    </td>
                    <td>
                        <%= c.getAuthorizedBy() %>
                    </td>
                    <td>
                        &nbsp;
                        <a href="approveRecord?customerCode=<%= c.getCustomerCode()%>"+ <%= c.getCustomerCode() %>><i class='fas fa-check-circle' style="color:green; font-size:18px"></i></i></a>
                        &nbsp;
                        <a href="rejectRecord?customerCode=<%= c.getCustomerCode()%>"><i class="fa fa-times-circle" style="color:red; font-size:18px"></i></a>
                        &nbsp;
                    </td>
                </tr>

                <%
                        }
                    }
                %>
            </table>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</html>