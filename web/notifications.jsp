<%-- 
    Document   : sendNews
    Created on : Apr 25, 2017, 3:03:31 AM
    Author     : root
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.dmr.project.model.RedBill"%>
<%@page import="com.dmr.project.controller.NotificationPage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="public/css/bootstrap-select.min.css">
        <!--<script src="public/js/jquery-3.2.1.min.js" type="text/javascript"></script>-->
        <script src="public/js/jquery-2.1.3.min.js" type="text/javascript"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="public/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="public/js/bootstrap-select.min.js" type="text/javascript"></script>
        <script src="public/js/transformers.js"></script>
    </head>
    <body>
        <%@include file="adminDash.jsp" %>
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="panel panel-default">
<!--                    <div style="margin-top: 100px;margin-left:0;" class="container">-->
<div class="panel-heading" style="font-size: 14"><b>Red Bill Notifications</b></div>
                        
                            <form action="Notificationpage" method="post" >
                            <div class="panel-body">
                                <div class="container">
                                    <div class="row" style="margin-right: 200px">
                                        <div class="form-group">
                                            <table class="table table-striped table-hover table-responsive">
                                                <tr>
                                                    <th style="width:190px; text-align: left">Meter Id</th>
<!--                                                    <th>Customer name</th>-->
                                                    <th style=" text-align: left;width: 190px">Last Bill</th>
                                                    <th style=" text-align: left;width: 190px">Current Bill</th>
                                                    <th style=" text-align: left;width: 190px">Bill Date</th>
                                                    <th style=" text-align: left;width: 190px">Bill2</th>
                                                    <th style=" text-align: left;width: 190px">Date</th>
<!--                                                    <th>&nbsp;</th>-->
                    <!--                                <th>&nbsp;</th>-->
                                                </tr>
                                                    <% ArrayList<RedBill> list = (ArrayList) request.getAttribute("rs");
                                                             for (int i = 0; i < list.size(); i++) {
                                                    %>
                                                <tr>
                                                    <td><% out.print(list.get(i).getMeter_id());%></td>
                                                    <td><% out.print(list.get(i).getLast_bill());%></td>
                                                    <td><% out.print(list.get(i).getCurrent_bill());%></td>
                                                    <td><% out.print(list.get(i).getDate());%></td>
                                                    <td><% out.print(list.get(i).getLast_bill()-list.get(i).getCurrent_bill());%></td>
                                                    <td>2017-08-04</td>    
                                                </tr>
                                                    <%
                                                        }
                                                    %>
                                                      
                                             </table>  
                                                    <table>
                                                        
                                                    <tr>
                                                   <b> <button style="text-align: center; margin-left: 810px;" type="submit">  Send</button></b>    
                                                    </tr>  
                                                    </table>
                                             
                                        </div>
                                    </div>
                                </div>
                            </div>
                                             
                            </form>                
                </div>
            </div>
       </div>

    </body>

</html>
