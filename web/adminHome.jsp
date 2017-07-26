<%-- 
    Document   : userHome
    Created on : Apr 21, 2017, 10:05:22 AM
    Author     : chamara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <link href="assets/css/custom.css" rel="stylesheet" />
        <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <title>Admin Home</title>
    </head>
    <body>
        <%@include file="adminDash.jsp" %>
        
        
        <%
            Object requestCount =  request.getAttribute("newRequests");
            
        %>
        <!--Page content start from here-->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    
                <!-- DMR Request-->
                
                    <div class="col-md-3 col-sm-6 col-xs-6">           
			<div class="panel panel-back noti-box">
                            <span class="icon-box bg-color-brown set-icon">
                                <i class="fa fa-envelope-square"></i>
                            </span>
                            <div class="text-box" >
                                <p class="main-text"><%=requestCount%> New</p>
                                <p class="text-muted">DMR Request</p>
                            </div>
                        </div>
		    </div>

                    <!--Notifications box-->         
                    <div class="col-md-3 col-sm-6 col-xs-6">           
			<div class="panel panel-back noti-box">
                            <span class="icon-box bg-color-blue set-icon">
                                <i class="fa fa-bell-o"></i>
                            </span>
                            <div class="text-box" >
                                <p class="main-text">240 New</p>
                                <p class="text-muted">Notifications</p>
                            </div>
                        </div>
                    </div>
                                
                <!--Remaining tasks-->
                <div class="col-md-3 col-sm-6 col-xs-6">           
                    <div class="panel panel-back noti-box">
                        <span class="icon-box bg-color-green set-icon">
                            <i class="fa fa-bar-chart"></i>
                        </span>
                        <div class="text-box" >
                            <p class="main-text">Visual Analytics</p>
                            <p class="text-muted"></p>
                        </div>
                    </div>
                   </div>
                
                <!-- Orders-->
                    <div class="col-md-3 col-sm-6 col-xs-6">           
			<div class="panel panel-back noti-box">
                            <span class="icon-box bg-color-red set-icon">
                                <i class="fa fa-envelope-square"></i>
                            </span>
                            <div class="text-box" >
                                <p class="main-text">Send<br>SMS</p>
                                <p class="text-muted"></p>
                            </div>
                        </div>
		    </div>
                    

                </div>
            </div>
        </div>
    </div>
    </body>
</html>
