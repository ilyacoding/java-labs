<%--
  Created by IntelliJ IDEA.
  User: ilyacoding
  Date: 11/28/2017
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin page</title>
    <script src="../../resources/js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <script src="../../resources/js/popper.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</head>
<body>

    <jsp:include page="../block/sitenavbar.jsp"/>

    <div class="container">
        <div class="row">
            <h2>${locale_admin_table_header} </h2>
        </div>
        <div class="row">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <td scope="col">${locale_admin_table_hotelname}</td>
                        <td scope="col">${locale_admin_table_hotelcount}</td>
                        <td scope="col">${locale_admin_table_deleteform}</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${hotelList}" var="item">
                        <tr>
                            <th scope="row">${item.id}</th>
                            <td scope="col">${item.name}</td>
                            <td scope="col">${item.placesCount}</td>
                            <td scope="col">
                                <form action="/servicehotels">
                                    <input type="text" name="hotelid" value="${item.id}" hidden="hidden"/>
                                    <input type="text" name="command" value="deletehotel" hidden="hidden"/>
                                    <button type="submit" class="btn btn-danger">${locale_admin_table_btndelete}  </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <br/>
    <hr/>

    <div class="container">
        <div class="row">
            <h3>${locale_admin_registration_header}</h3>
        </div>
        <div class="row">
            <div class="form-group">
                <form action="/servicehotels">
                    <div class="form-group">
                        <label>${locale_admin_registration_label_hotelname}:</label>
                        <input type="text" name="hotelname" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label>${locale_admin_registration_label_hotelcount}:</label>
                        <input type="text" name="placescount" class="form-control" />
                    </div>
                    <input type="text" name="command" value="addhotel" hidden="hidden"/>
                    <button type="submit" class="btn btn-primary">${locale_admin_registration_btnadd}</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
