<%-- 
    Document   : newjsp1
    Created on : 2018-03-11, 22:55:30
    Author     : Mateusz Cieśliński
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result of HashingMashine ---></title>
    </head>
    <body>
        <p>Result: <%= request.getAttribute("md5hash") %></p>
        <a href="index.jsp">Back</a>
    </body>
</html>
