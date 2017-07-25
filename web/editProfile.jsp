<%-- 
    Document   : editProfile
    Created on : Jul 25, 2017, 3:23:22 PM
    Author     : Ruwani Jayarathna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Responsive meta tag-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--link to bootstrap css--> 
        <link rel="stylesheet" href="public/bootstrap/css/bootstrap.min.css" type="text/css">
        <!--Responsive CSS file-->
        <link rel="stylesheet" type="text/css" href="public/css/responsive.css">
        
        <title>Edit Profil</title>
    </head>
    <body>
        <%@include file="UserDash.jsp" %>
        <div id ="page-wrapper" style="margin-top: 50px">
            <div id="page-inner"> 
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <h1>Edit Profile</h1>
                        </div>
                    </div>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3">First name:</label>
                        <div class="col-sm-3">
                            <input class="form-control" type="text" value="Jane">
                        </div>
                        </div>
                    </form>
            </div>
        </div>
    </body>
</html>
