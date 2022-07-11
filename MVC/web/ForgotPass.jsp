<%-- 
    Document   : ForgotPass
    Created on : Jun 6, 2022, 2:20:29 PM
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
        <form action='ResetPass' style="margin:auto">
            Username: <input type='text' name='acc' value="${acc}">
            <br>Birth date <input type='text' name='dob' value="${dob}">
            <br> <input type="submit" name="Login">
            <br>New pass<input type='text' name='pass' value="${pass}" readonly="">
            </form>
    </body>
</html>
