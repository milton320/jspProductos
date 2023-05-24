<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Productos"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Productos> productos = (List<Productos>)request.getAttribute("productos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion de productos</h1>
        <a href="#">Nuevo</a>
        <table border="1">
            <tr>
                <th>id</th>
                <th>descripcion</th>
                <th>cantidad</th>
                <th>precio</th>
                <th>categoria</th>
            </tr>
            <c:forEach var="item" items="${productos}">
            <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.cantidad}</td>
                <td>${item.precio}</td>
                <td>${item.categoria}</td>
            </tr>
            </c:forEach>
        </table>

    </body>
</html>
