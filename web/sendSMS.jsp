<%-- 
    Document   : sendNews
    Created on : Apr 25, 2017, 3:03:31 AM
    Author     : root
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.PrintWriter"%>
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
                        <div class="panel-heading">SMS Alert</div>
                        
                            <form action="SMSHandler" method="post" >
                            <div class="panel-body">
                                <div class="container">
                                    <div class="row">
                        <div class="form-group">

<!--                        <label for="area">Area office:</label>-->
                        <table>
                            
                            <tr>
                                <td>Area Office</td>
                                <td> <select class="selectpicker" multiple id="area_list" name="area_list" >
                            <%           ArrayList list = (ArrayList) request.getAttribute("areaList");
                                for (int i = 0; i < list.size(); i++) {
                            %>

                            <option><% out.print(list.get(i));%></option>

                            <%
                                }
                            %>
                        </select></td>
                        
                        
                        <td>Location</td>
                        <td><select class="selectpicker" multiple id="transformer_list" name="transformer_list">

                            </select></td>
                            <td>
                                Message
                            </td>
                            <td>
                                  <textarea style="width: 156px;margin-top: -8px;"row="8" col="10" name="message" id="message">
          
                            </textarea>
                            </td>
                            </tr>
                            
                            
                        </table> 
                       

                        </div>
                    
                       

<!--                        <div class="form-group" style="margin-left: 369px;"> 
                            <p>
                                <label>Message</label>
                            </p>
                            <textarea style="width: 156px;margin-top: -8px;"row="8" col="10" name="message" id="message">
          
                            </textarea>
                        </div>-->
                        <button style="margin-left: 466px" type="submit" id="send" name="send" class="btn btn-default">Send</button> 
                            </div>
                            </div>
                          </div>
                    </form>

            <div id="show"></div>
      
                </div>
            </div>
        <!--</div>-->
<!--    </div>-->



        <!--</div>-->

    </body>

</html>
