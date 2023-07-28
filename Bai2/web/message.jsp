<%-- 
    Document   : inbox
    Created on : Jul 27, 2023, 10:19:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border ="1">
            <tr>
                <td>From</td>
                <td>${message.from}</td>
            </tr>
               <tr>
                <td>Title</td>
                <td>${message.messagetitle}</td>
            </tr>
               <tr>
                <td>Created Time</td>
                <td>${message.messagetime}</td>
            </tr>
               <tr>
                <td>Content</td>
                <td>${message.messagecontent}</td>
            </tr>
     
        </table>
    </body>
</html>
