<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <div class="container-fluid">
            <p class="navbar-brand">Welcome <b><sec:authentication property="principal.username"/></b>!</p>
            <a class="navbar-brand" href="logout">Logout &nbsp;<i class='fas fa-user-alt'></i></a>
        </div>
    </nav>

    <div class="container-fluid container" style="margin-top:80px">


    <sec:authorize access="hasAuthority('maker')">
        <div class="row">
            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">

                <div class="card bg-success text-white text-center mb-4 p-4 mt-5">
                    <div class="card-body">
                        <h2 class="card-title">Register Customer Details</h2>
                        <hr>
                        <a href="maker"><i class='fas fa-address-card mt-5 text-white' style='font-size:150px;'></i></a></h2>
                        <br>
                        <br>
                        <p>Add new customers records</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 mb-4 mb-lg-0 mt-5">
                <div class="card bg-primary text-white mb-4 text-center p-4">
                    <div class="card-body">
                        <h2 class="card-title">Update/Delete Customer Details</h2>
                        <hr>
                        <a href="displayCustomer"><i class='fas fa-user-edit mt-5 text-white' style='font-size:150px;'></i></a></h2>
                        <br>
                        <br>
                        <p>Modify or Delete customers records</p>
                    </div>
                </div>
            </div>


            <div class="col-lg-4 mb-4 mb-lg-0 mt-5">
                <div class="card bg-warning text-white text-center mb-4 p-4">
                    <div class="card-body">
                        <h2 class="card-title">Display Customer Details</h2>
                        <hr>
                        <a href="display"><i class='fas fa-address-book mt-5 text-white' style='font-size:150px;'></i></a></h2>
                        <br>
                        <br>
                        <p>Display all customer records</p>
                    </div>
                </div>
            </div>
        </div>
    </sec:authorize>


    <sec:authorize access="hasAuthority('checker')">
        <div class="row">
            <div class="col-lg-6 col-md-12 mb-4 mb-lg-0">

                <div class="card bg-success text-white text-center mb-4 p-4 mt-5">
                    <div class="card-body">
                        <h2 class="card-title">Authorize Customer Records</h2>
                        <hr>
                        <a href="checker"><i class='fas fa-id-card-alt mt-5 text-white' style='font-size:150px;'></i></a></h2>
                        <br>
                        <br>
                        <p>Approve or Reject customers records</p>
                    </div>
                </div>
            </div>


            <div class="col-lg-6 mb-4 mb-lg-0 mt-5">
                <div class="card bg-warning text-white text-center mb-4 p-4">
                    <div class="card-body">
                        <h2 class="card-title">Display Customer Details</h2>
                        <hr>
                        <a href="show"><i class='fas fa-address-book mt-5 text-white' style='font-size:150px;'></i></a></h2>
                        <br>
                        <br>
                        <p>Display all customer records</p>
                    </div>
                </div>
            </div>
        </div>
    </sec:authorize>
    
    <%-- Roles: <b><sec:authentication property="principal.authorities" /></b>   </p>
    <h2><a href="maker">Maker</a></h2>
    <h2><a href="checker">Checker</a></h2>
    <h4><a href="logout">Logout</h4> --%>
    </div>
    
</body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</html>




