<%--
  Created by IntelliJ IDEA.
  User: ilyacoding
  Date: 11/24/2017
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%session.setAttribute("locale","eng");%>
<c:redirect url = "/servicehotels"/>
</body>
</html>
