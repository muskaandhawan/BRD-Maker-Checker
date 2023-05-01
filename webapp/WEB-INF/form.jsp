<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
    <head>
        <title><spring:message code="form.pageTitle"/></title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <style>
            .error {
                color: #d70808;
                font-size: 12px;
                padding: 6px;
                font-weight: bold;
            }
        </style>
    </head>

    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="home"><i class='fas fa-chalkboard-teacher'></i> Dashboard </a>
                <a class="navbar-brand" href="logout">Logout &nbsp;<i class='fas fa-user-alt'></i></a>
            </div>
        </nav>

        <div class="container-fluid container" style="margin-top:80px">
            <h3 class="mb-4">
                <spring:message code="form.heading" text="Customer Registration Form" />
            </h3>

            <form:form class="was-validated" action="registerCustomer" novalidate="true" method="POST" modelAttribute="customerDto">

                <div class="row align-items-start">
                    <div class="form-group col-5">
                        <spring:message code="form.field.customerCode" />
                        <form:input class="form-control" path="customerCode" pattern="^[a-zA-Z0-9]*$" required="true" />
                        <div class="invalid-feedback"><spring:message code="form.error.customerCode" /></div>
                        <form:errors path="customerCode" cssClass="error" />
                    </div>

                    <div class="col-1"></div>

                    <div class="form-group col-5">
                        <spring:message code="form.field.customerName" />
                        <!-- <form:label path="customerName">Customer Name: </form:label> -->
                        <form:input class="form-control" path="customerName" pattern="^[A-Za-z ]+$" required="true"/>
                        <div class="invalid-feedback"><spring:message code="form.error.customerName" /></div>
                        <form:errors path="customerName" cssClass="error" />
                    </div>
                </div>
        
                <br>
                <br>

                <div class="row align-items-start">
                    <div class="form-group col-5">
                        <spring:message code="form.field.customerAddress1" />
                        <!--<form:label path="customerAddress1">Customer Address Line1: </form:label> -->
                        <form:input class="form-control" path="customerAddress1" pattern="^^[a-zA-Z0-9 ,./-]*$" required="true"/>
                        <div class="invalid-feedback"><spring:message code="form.error.customerAddress1" /></div>
                        <form:errors path="customerAddress1" cssClass="error" />
                    </div>
                    
                    <div class="col-1"></div>

                    <div class="form-group col-5">
                        <spring:message code="form.field.customerAddress2" />
                        <!--<form:label path="customerAddress2">Customer Address Line2: </form:label> -->
                        <form:input class="form-control" path="customerAddress2" pattern="^^[a-zA-Z0-9 ,./-]*$"/>
                        <div class="invalid-feedback"><spring:message code="form.error.customerAddress2" /></div>
                        <form:errors path="customerAddress2" cssClass="error" />
                    </div>
                </div>
                
                <br>
                <br>

                <div class="row align-items-start">
                    <div class="form-group col-5">
                        <spring:message code="form.field.customerPinCode" />
                        <!--<form:label path="customerPinCode">Pin Code: </form:label> -->
                        <form:input class="form-control" path="customerPinCode" type="text" pattern="^[1-9][0-9]{5,5}$" min="100000" max="999999"  required="true" />
                        <div class="invalid-feedback"><spring:message code="form.error.customerPinCode" /></div>
                        <form:errors path="customerPinCode" cssClass="error" />
                    </div>
                    
                    <div class="col-1"></div>

                    <div class="form-group col-5">
                        <spring:message code="form.field.emailAddress" />
                        <!--<form:label path="emailAddress">Email Address: </form:label> -->
                        <form:input type="email" required="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="form-control" path="emailAddress" />
                        <div class="invalid-feedback"><spring:message code="form.error.emailAddress" /></div>
                        <form:errors path="emailAddress" cssClass="error" />
                    </div>
                </div>
                
                <br>
                <br>

                <div class="row align-items-start">
                    <div class="form-group col-5">
                        <spring:message code="form.field.contactNumber" />
                        <!-- <form:label path="contactNumber">Contact Number: </form:label> -->
                        <form:input class="form-control" path="contactNumber" pattern="^[1-9][0-9]{9,9}$" min="1000000000" max="9999999999"/>
                        <div class="invalid-feedback"><spring:message code="form.error.contactNumber" /></div>
                        <form:errors path="contactNumber" cssClass="error" />
                    </div>
                    
                    <div class="col-1"></div>

                    <div class="form-group col-5">
                        <spring:message code="form.field.primaryContactPerson" />
                        <!-- <form:label path="primaryContactPerson">Primary Contact Person: </form:label> -->
                        <form:input class="form-control" path="primaryContactPerson" pattern="^[A-Za-z ]+$" required="true"/>
                        <div class="invalid-feedback"><spring:message code="form.error.primaryContactPerson" /></div>
                        <form:errors path="primaryContactPerson" cssClass="error" />
                    </div>
                </div>
                
                <br>
                <br>

                <div class="form-group col-5">
                    <spring:message code="form.field.activeInactiveFlag" />
                    <form:select class="form-control" path="activeInactiveFlag">
                        <form:option value="A">
                            <spring:message code="form.field.activeInactiveFlag.option1" />
                        </form:option>
                        <form:option value="I">
                            <spring:message code="form.field.activeInactiveFlag.option2" />
                        </form:option>
                    </form:select>
                    <form:errors path="activeInactiveFlag" cssClass="error" />
                </div>
                
                <br>
                <br>

                <button path="add" class="btn btn-primary" type="submit">
                    <spring:message code="form.btn.add" />
                </button>
            </form:form>
        </div>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</html>