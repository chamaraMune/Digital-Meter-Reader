<%-- 
    Document   : blank
    Created on : Apr 15, 2017, 11:47:27 PM
    Author     : Ruwani Jayarathna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Dashboard</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />

   
</head>
<body>
    <div id="wrapper" style="background-color: #145D8E;">
        <nav class="navbar navbar-default navbar-static-top " role="navigation" style="margin-bottom: 0; background-color: #145D8E;">
            
            <div class="navbar-header"   style="position: fixed;">

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="adminHome" style="text-align: center;font-size: 20px;background-color: #EECD47; float: right; width: 260px; height: 60px">
                    Digital Meter Reader</a>
                
            </div>         
            	
            <%
                
                String loggeduser = (String)session.getAttribute("loggedUsername");
                String welcomeMsg = "Hello " +loggeduser;                                                    
            %>
            
            <div style="color: white;padding: 15px 50px 5px 50px; float: right;font-size: 16px;">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" data-toggle="dropdown" type="button"><i class="fa fa-user"></i>&nbsp;<%=welcomeMsg%>
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="fa fa-edit"></i>&nbsp;&nbsp;Edit Profile</a></li>
                        <li><a href="LogoutHandler"><i class="fa fa-power-off"></i>&nbsp;&nbsp;Log out</a></li>
                    </ul>           
                </div>
            </div>
            
            
            
        </nav>   
           <!-- /. NAV TOP LEFT  -->
           <nav class="navbar-default navbar-left" role="navigation" style="width:260px; position: fixed; margin-top: 50px">
               <div class="sidebar-collapse" style="background-color: white;">
                   <ul class="nav" id="main-menu" style="">

				
					
                    <li>
                        <a  href="AdminHomePage" style="background-color: #145D8E  ;"><i class="fa fa-home fa-3x"></i>Home</a>
                    </li>
                    <li>
                        <a  href="AdminDMRRequest" style="background-color: #145D8E;"><i class="fa fa-user fa-3x"></i>User Registration</a>
                    </li>
                    
                    <li>
                        <a  href="tab_panel.jsp" style="background-color: #145D8E;"><i class="fa fa-bell-o fa-3x"></i>Notifications</a>
                    </li>
                    <li>
                        <a  href="chart.jsp" style="background-color: #145D8E;"><i class="fa fa-bar-chart fa-3x"></i>Visual Analytics</a>
                    </li>	
                    <li>
                        <a  href="table.jsp" style="background-color: #145D8E;"><i class="fa fa-send fa-3x"></i>Send SMS</a>
                    </li>             	
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        
         <!-- /. PAGE WRAPPER  -->
<!--        </div>-->
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
<!--    <script src="assets/js/custom.js"></script>-->
    
   
</body>
</html>
