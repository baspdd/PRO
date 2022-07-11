<%-- 
    Document   : Calculate
    Created on : May 27, 2022, 1:18:06 PM
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
        <h1>Hello World!</h1>
        
        <form action="math" method='get'>
            Enter a: <input type='text' name='a'value="${a}" /> <br/>
            Enter b: <input type='text' name='b' value="${b}"/> <br/>
            <input type='submit' name='gcd' value="BCNN"/>
            <input type='submit' name='lcm' value="UCLN"/>
            <br> result <input type="text" name="result" value="${result}">
        </form>
    </body>
</html>
