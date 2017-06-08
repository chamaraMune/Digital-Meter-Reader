<%-- 
    Document   : userCurrentUsage
    Created on : May 20, 2017, 2:50:16 AM
    Author     : chamara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Current Usage</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
        <!--Responsive meta tag-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--link to bootstrap css--> 
        <link rel="stylesheet" href="public/bootstrap/css/bootstrap.min.css" type="text/css">
        <!--Responsive CSS file-->
        <link rel="stylesheet" type="text/css" href="public/css/responsive.css">
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <!--Morris chart-->
        <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </head>
    <body>
        <%@include file="UserDash.jsp" %>
        <!--statr content of the page-->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="panel panel-default" style="margin-left:0;margin-top: 5%;">
                                <div class="panel-heading">Your Current Usage</div>        
                                      
                                <div class="panel-body" style="text-align: left;"> 
                                    <div class="row">
                                        <div class="col-sm-4" style="text-align: left">
                                            <h5>Current Units(kWh) :</h5>
                                        </div>
                                        <div class="col-sm-3"><h5>52</h5></div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <h5>Current Bill(LKR) :</h5>
                                        </div>
                                        <div class="col-sm-3"><h5>900.00</h5></div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <h5>Lately updated :</h5>
                                        </div> 
                                        <div class="col-sm-5"><h5>2017-05-18 15:14:46</h5></div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-sm-10">
                                            <a href="#" class="btn btn-primary btn-default" style="float: right;">Refresh</a>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
 
                        </div>
                        <div class="col-sm-6">                     
                            <div class="panel panel-default" style="margin-top: 5%;">
                                <div class="panel-heading">Usage Chart</div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <img src="public/images/charts.png"  style="width: 90%;height: 50%">
                                        </div> 
                                    </div>
                                    
                                </div>
                            </div>            
                        </div>
                    </div>
                    <hr>
                    <a><h5>Click here to view Usage history...</h5></a>
                
                </div>
            
            </div>
        </div>
        
        
     <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
<!--    <script src="assets/js/custom.js"></script>-->
    <!-- MORRIS CHART SCRIPTS -->
     <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
    </body>
</html>
