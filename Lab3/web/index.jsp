<%--
  Created by IntelliJ IDEA.
  User: ilyacoding
  Date: 11/16/2017
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>Authorization</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="resources/js/jquery-3.2.1.js"></script>
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="resources/js/popper.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>

  <jsp:include page="jsp/block/sitenavbar.jsp"/>

  <div class="container">
    <div class="row">
      <div class="span12">
        ${errorLoginOrPassword}
        <form name="loginForm" method="POST" action="servicehotels" >
          <input type="hidden" name="command" value="login" />
          <h3 >${locale_authorization_header}: </h3>

          <div class="form-group">
            <label>${locale_authorization_label_login}:</label>
            <input type="text" name="login" value="" size="20" class="form-control" />
          </div>

          <div class="form-group">
            <label>${locale_authorization_label_password}:</label>
            <input type="password" name="password" value="" size="20" class="form-control" />
          </div>
          <br />
          <input class="btn btn-primary" type="submit" value="${locale_authorization_btn}" />
        </form>
      </div>
    </div>
  </div>
</body>
<%session.removeAttribute("errorLoginOrPassword");%>
</html>
