<%-- 
    Document   : ProductDetail
    Created on : Jun 27, 2022, 2:14:16 PM
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
        <form>
            ProductID: <input type="text" value="${id}" name="id">
            <br>ProductName: <input type="text" name="name">
            <br>Unit: <input type="text" name="unit">
            <br>Price: <input type="text" name="price">
            <br>Image: <input type="text" name="image">
            <br><input type="submit" name="Update" value="update">

        </form>
    </body>
</html>
