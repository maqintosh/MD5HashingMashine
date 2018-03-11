<%-- 
    Document   : newjsp
    Created on : 2018-03-11, 22:27:41
    Author     : Mateusz Cieśliński
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MD5 Hash</title>
    </head>
    <body>
        <form action="DoHash.do">
        <p>Input data:</p>
        <textarea name="dataForHash"></textarea>
        <br />
        <input type="submit" value="Send" />
    </form>
    </body>
</html>
