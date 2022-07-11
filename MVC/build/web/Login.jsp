<%-- 
    Document   : Login
    Created on : May 27, 2022, 2:00:50 PM
    Author     : duypham0705
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action='LoginController' method="POST" style="margin:auto">
            Username: <input type='text' name='acc' value="${acc}">
            <br>Password: <input type='text' name='pass' value="${pass}">
            <br> <input type="submit" name="Login">
            </form>
    </body>
</html>
