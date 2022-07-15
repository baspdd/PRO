<%-- 
    Document   : session
    Created on : Jul 9, 2022, 4:25:30 PM
    Author     : duypham0705
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
        <h1>Hello World!</h1>
        <h2>
            Request:${requestScope.name1}
            <br>Session:${sessionScope.name2}
        </h2>
        <form action="session">
            name : <input type="text" name="name" placeholder="enter name">
            <br> <input type="submit" value="submit">
        </form>
        <h3>
            <c:forEach items="${sessionScope.data}" var="i">
                ${i}<br>
            </c:forEach>
        </h3>
    </body>
</html>
