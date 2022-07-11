<%-- 
    Document   : ListUser
    Created on : Jun 6, 2022, 1:16:13 PM
    Author     : duypham0705
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Product"  %>
<%@page import="java.util.ArrayList"  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${name}!</h1>
        <!--        <table border="1">
                    <tr>
                        <td>ProductID</td>
                        <td>ProductName</td>
                        <td>Unit</td>
                        <td>Price</td>
                        <td>Image</td>
                    </tr>
        <%
          ArrayList<Product> list = new ArrayList<Product>();
            if(request.getAttribute("listAll")!=null){
                list= (ArrayList<Product>)request.getAttribute("listAll");
            }
            for(Product item : list)
            {
                out.print("<tr>");
                out.print("<td>" + item.getProductID() + "</td>");
                out.print("<td>" + item.getProductName() + "</td>");
                out.print("<td>" + item.getUnit() + "</td>");
                out.print("<td>" + item.getPrice() + "</td>");
                out.print("<td><img width='200' src=" + item.getImage() + "></td>");
                out.print("</tr>");
            }
        %>
    </table>-->
        <h1>Using JSTL</h1>
        <c:set var="age" value="page"></c:set>
        <c:forEach begin="${1}" end="${numPage}" var="item">
            <a href="ProductController?xPage=${item}">${item}</a>
        </c:forEach>
        <table border="1">
            <tr>
                <td>ProductID</td>
                <td>ProductName</td>
                <td>Unit</td>
                <td>Price</td>
                <td>Image</td>
            </tr>
            <c:forEach items = "${listPage}" var="item" >
                <tr>
                    <td>${item.getProductID()}</td>
                    <td>${item.getProductName()}</td>
                    <td>${item.getUnit()}</td>
                    <td>${item.getPrice()}</td>
                    <td><img src="${item.getImage()}" alt="${item.getImage()}" width="200"></td>
                    <td><a href="Edit?id=${item.getProductID()}&mode=Update">Update</a></td>
                    <td><a href="Edit?id=${item.getProductID()}&mode=Delete">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
