<%-- 
    Document   : create
    Created on : Jul 27, 2023, 11:15:45 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "create" method="POST">
        <table border =1>
            <tr>
                <td>To</td>
                <td>
                    <select name ="to">
                        <c:forEach items="${listU}" var="u">
                            <option value="${u.username}">${u.username}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Title</td>
                <td>
                    <input type="text" name ="title">
                </td>
            </tr>
            <tr>
                <td>Content</td>
                <td>
                    <textarea name="content"></textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type ="submit">save</button>
                </td>
            </tr>
           
        </table>
            </form>
    </body>
</html>
