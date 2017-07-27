<%-- 
    Document   : userUsageHistory
    Created on : Jun 8, 2017, 6:05:39 AM
    Author     : chamara
--%>

<%@page import="java.util.Collections"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import = "com.dmr.project.model.MeterReading" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usage History</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="public/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="public/css/responsive.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <link href="assets/js/dataTables/dataTables.bootstrap.css">
       
    </head>
    <body>
        <div id="wrapper">
            <%@include file="UserDash.jsp" %>
            
            <div id="page-wrapper">
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 style="color: #1a237e">Usage History</h2>
                            <h5>Here is summary of your electricity usage</h5>
                        </div>
                    </div>
                    <hr>
                    
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading" style="margin-bottom: 3%">
                                    Daily Electricity Usages
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" 
                                           id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center;">Date</th>
                                                <th style="text-align: center;">Voltage(V)</th>
                                                <th style="text-align: center;">Amphere(A)</th>
                                                <th style="text-align: center;">Consumption Units(kWh)</th>
                                                
                                            </tr>
                                        </thead>
                                        
                                        <%
                                            List<MeterReading> readingList = (List<MeterReading>) request.getAttribute("readingList");
//                                            System.out.println("IN JSP : "+ readingList.get(0).getDate());
                                 
                                        %>
                                        
                                        <tbody>
                                            <% if(!readingList.isEmpty()){%>
                                            <c:forEach items="<%=readingList%>" var= "object">
                                            <tr class="gradeA" style="text-align: center;">
                                                <td><c:out value="${object.getDate()}"/></td>
                                                <td><c:out value="${object.getVoltage()}"/></td>
                                                <td><c:out value="${object.getAmphere()}"/></td>
                                                <td><c:out value="${object.getUnit()}"/></td>
                                            </tr>
                                        </c:forEach>
                                            <%}%>
                                        
                                        
                                        </tbody>
                                        
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <script src="assets/js/jquery-1.10.2.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>
            <script src="assets/js/jquery.metisMenu.js"></script>
            <script src="assets/js/dataTables/jquery.dataTables.js"></script>
            <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
            <script>
                $(document).ready(function () {
                    $('#dataTables-example').dataTable({
                        "sort": false
                    });
                });
            </script>
            <script src="assets/js/custom.js"></script>
            
    </body>
</html>
