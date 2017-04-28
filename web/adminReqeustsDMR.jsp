<%-- 
    Document   : adminReqeustsDMR
    Created on : Apr 24, 2017, 6:43:20 PM
    Author     : chamara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="com.dmr.project.model.RequestForm" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Responsive meta tag-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--link to bootstrap css--> 
        <link rel="stylesheet" href="public/bootstrap/css/bootstrap.min.css" type="text/css">
        <!--Responsive CSS file-->
        <link rel="stylesheet" type="text/css" href="public/css/responsive.css">
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        
        <title>Home page</title>
        <style>
            .table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
                background-color:#ECFFB3;
                
            .modal-header, h4, .close {
            background-color: #5368C8;
            color:white !important;
            text-align: center;
            font-size: 30px;
            font-family: 'Arial', sans-serif;
         } 
         .modal{
                border-radius: 20px;
                background-color: transparent; 
                margin:30px auto 0;
                padding:6px;  
    
                position:absolute;
                width:800px;
                top: 30%;
                left: 50%;
                margin-left: -400px; 
                margin-top: -40px;
         }
         
         .modal-content{width :80%;height: 80%;}
            }
        </style>
    </head>
    <body>
        <%@include file="adminDash.jsp" %>
        
        <!--Page content start from here-->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-sm-12 col-md-12">
                        <h3> &nbsp;&nbsp;New digital meter requests from public users</h3>
                        <br><br>
                        <%
                            List<RequestForm> list = (List<RequestForm>) request.getAttribute("requestList");
                    
                        %>
                        <form>
                            <input type="hidden" id="row_id"/>
                            <input type="hidden" id="selected_customername"/>
                            <input type="hidden" id ="selected_mobilenumber"/>
                            <input type="hidden" id ="selected_email"/>
                            <input type="hidden" id ="selected_CEBaccount"/>
                            <input type="hidden" id ="selected_areaoffcie"/>
                            <input type="hidden" id ="selected_submitdate"/>
                                <table class="table table-striped table-hover table-responsive">
                                    <tr>
                                        <th style="text-align: center">Request Id</th>
                                        <th>Customer name</th>
                                        <th>Mobile number</th>
                                        <th>E-mail</th>
                                        <th>CEB Account</th>
                                        <th>Area Office</th>
                                        <th>Submitted Date</th>
                                        <th>&nbsp;</th>
        <!--                                <th>&nbsp;</th>-->
                                    </tr>
                                    <c:forEach items="${requestList}" var="requestForm">
                                        <tr id="<c:out value="${requestForm.getRequestId()}"/>">
                                            <th style="text-align: center" scope="row"><c:out value="${requestForm.getRequestId()}"/></th>
                                            <td><c:out value="${requestForm.getFirstName()}"/> <c:out value="${requestForm.getLastName()}"/></td>
                                            <td><c:out value="${requestForm.getMobilenumber()}"/></td>
                                            <td><c:out value="${requestForm.getEmail()}"/></td>
                                            <td><c:out value="${requestForm.getCebAccount()}"/></td>
                                            <td><c:out value="${requestForm.getAreaOffice()}"/></td>
                                            <td><c:out value="${requestForm.getRequestDateTime()}"/></td>
                                            <td><button type="button" 
                                                        class="btn btn-info" 
                                                        data-toggle="modal" 
                                                        data-target="#myModal" 
                                                        onclick=reqeustIdToModal("<c:out value="${requestForm.getRequestId()}"/>","<c:out value="${requestForm.getFirstName()}"/>","<c:out value="${requestForm.getLastName()}"/>","<c:out value="${requestForm.getCebAccount()}"/>")>
                                                    Accept
                                                </button>
                                            </td>
        <!--                                    <td><button type="button" class="btn btn-danger">Delete</button></td>-->
                                        </tr>
                                    </c:forEach>
                                </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                        
             <div class="modal fade" id="myModal" role ="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                     <div class="modal-header" style="padding:35px 50px; margin-bottom:0px;">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span> Confirm</h4>
                        <p id="firstNameLastName"></p>
                    </div>
                    
                        <div class="form-box">
                            <div class="col-sm-4">
                                <div  class="form-box">
                                   
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" action="RequestAcceptor" method="post" class="login-form">
<!--                                        username input field in login form-->
				        <div class="form-group">
				            <label class="sr-only" for="form-username">Username</label>
                                            <input type="text" name="requestId" id="requestId" placeholder="Username..." style="display: none" class="form-username form-control" id="form-username" >
				        </div>
<!--                                        Submit button in login form-->
                                        <div class="form-group" style="margin-left: 415px;margin-bottom: 20px;">
                                            <button type="submit" style="width: 70px;" class="btn btn-success" > Yes </button>
                                            <button type="submit" style="width: 70px;" class="btn btn-danger" > No </button>
                                        </div>
				    </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                        

                        <script>
                            function reqeustIdToModal(requestId,firstName,lastName,CEBaccNum){
                                //alert(requestId);
                                var firstNameAndLastName = firstName + " " + lastName;
                                document.getElementById("firstNameLastName").innerHTML = 'Do you want to accept request from '+firstNameAndLastName+"?";
                                document.getElementById("requestId").value = requestId;
                                
                                
                            }
                        </script>
                            
    </body>
</html>
