<%-- 
    Document   : editProfile
    Created on : Jul 25, 2017, 3:23:22 PM
    Author     : Ruwani Jayarathna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.dmr.project.model.User" %>
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
        
        <title>Edit Profile</title>
        <style>
            .lblTxt{
                color: black;
                text-align: center;
            }
            .inputTxt{
                
            }
        </style>
    </head>
    <body>
        <%
            User loggedUser = (User) request.getAttribute("loggeduser");
        %>
        <%@include file="UserDash.jsp" %>
        <div id ="page-wrapper" style="margin-top: 50px">
            <div id="page-inner"> 
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <h1>Edit Profile</h1>
                            <p id="updateMsg" style="margin-top: -26px;margin-bottom: -12px; color: red; display:none"> Profile Update Failed! </p>
                        </div>
                    </div>
                    <hr>
                    <form class="form-horizontal" role="form" action="UpdateUserProfile" method="POST">
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt">First name:</label>
                            <div class="col-sm-3 ">
                                <input class="form-control inputTxt" type="text" name="new_firstname" value=<%=loggedUser.getFirstname()%>>
                            </div>
                        </div>
                       
                        
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt">Last name:</label>
                            <div class="col-sm-3">
                                <input class="form-control" type="text" name="new_lastname" value=<%=loggedUser.getLastname()%>>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt">Address:</label>
                            <div class="col-sm-3">
                                <input class="form-control" type="text" value="<% out.print(loggedUser.getAddress());
                                       %>" readonly>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt">National ID No:</label>
                        <div class="col-sm-3">
                            <input class="form-control" type="text" value=<%=loggedUser.getUsername()%> readonly>
                        </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt">E-mail:</label>
                        <div class="col-sm-3">
                            <input class="form-control" type="text" name="new_email" value=<%=loggedUser.getEmail()%>>
                        </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt">Mobile No:</label>
                        <div class="col-sm-3">
                            <input class="form-control" type="text" name="new_mobilenumber" value=<%=loggedUser.getMobileNo()%>>
                        </div>
                        </div>

                        
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt" id="oldPwdLbl">Old Password:</label>
                            <div class="col-sm-3">
                                <input class="form-control"  name="old_password" type="password" placeholder="Enter old password" required>
                                 <p id="oldPwd" style="display:none ;color: red;font-size: 11px;margin-top: -15px;margin-bottom: -15px;">Incorrect Password!</p>
                            </div>
                           
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 lblTxt">New Password:</label>
                            <div class="col-sm-3">
                                <input class="form-control" name="new_password" type="password" placeholder="Enter New PasSword" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label"></label>
                            <div class="col-md-8">
                                <input type="submit" class="btn btn-primary" value="Save Changes">
                                <span></span>
                                <input type="reset" class="btn btn-default" value="Cancel">
                            </div>
                        </div>
                   </form>

                </div>
            </div>
        </div>
    </body>
    <script>
        var pwdStat = '${pwdStautes}';
        if(pwdStat){
            document.getElementById("oldPwd").style.display = "block";
            document.getElementById("oldPwdLbl").style.color = "red";
            //alert("Incorrect Password");
            
        }
        var update = '${updateStatues}';
        if(update === "fail"){
            document.getElementById("updateMsg").style.display = "block";
        }
    </script>
</html>
