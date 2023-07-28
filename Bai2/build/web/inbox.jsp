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
        <a href="create" >Create Message</a>
        <table border ="1">
            <th>Title</th>
            <th>From</th>
            <th>At</th>
            <th>Seen</th>
            <c:forEach items ="${listM}" var ="m">
            <tr>
                <td>
                    <a href ="Message?id=${m.messageid}">${m.messagetitle}</a>
                </td>
                <td>${m.from}</td>
                <td>${m.messagetime}</td>
                <td>${m.isread}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
