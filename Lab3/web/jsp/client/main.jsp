
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ilyacoding
  Date: 11/28/2017
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users page</title>
    <script src="../../resources/js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <script src="../../resources/js/popper.min.js"></script>
    <script src="../../resources/js/bootstrap.min.js"></script>
</head>
<body>

    <jsp:include page="../block/sitenavbar.jsp"/>

    <div class="container">
        <div class="row">
            <h2 >${locale_client_table_header} </h2>
        </div>
        <div class="row">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <td scope="col">${locale_client_table_hotelname}</td>
                        <td scope="col">${locale_client_table_hotelcount}</td>
                        <td scope="col">${locale_client_table_reservationform}</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${hotelList}" var="item">
                        <tr>
                            <th scope="row">${item.id}</th>
                            <td scope="col">${item.name}</td>
                            <td scope="col">${item.placesCount}</td>
                            <td scope="col">
                                <form action="/servicehotels" class="form-inline">
                                    <input type="text" name="hotelid" value="${item.id}" hidden="hidden"/>
                                    <input type="text" name="reservedplacescount" class="form-control" />
                                    <input type="text" name="command" hidden="hidden" value="reservehotel"/>
                                    <button type="submit" class="btn btn-success" >${locale_client_table_btnreserve}  </button>
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
            <h3 >${locale_client_reservedtabel_header} </h3>
        </div>
        <div class="row">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <td scope="col">${locale_client_reservedtabel_hotelname}</td>
                        <td scope="col">${locale_client_reservedtabel_hotelcount}</td>
                        <td scope="col">${locale_client_reservedtabel_cancelreservationform}</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestList}" var="item">
                        <tr>
                            <th scope="row">${item.id}</th>
                            <td scope="col">${item.hotelName}</td>
                            <td scope="col">${item.placesCount}</td>
                            <td scope="col">
                                <form action="/servicehotels" >
                                    <input type="text" name="command" hidden="hidden" value="cancelreservation"/>
                                    <input type="text" name="requestid" hidden="hidden" value="${item.id}"/>
                                    <input type="text" name="placescount" hidden="hidden" value="${item.placesCount}"/>
                                    <input type="text" name="hotelid" value="${item.hotelId}" hidden="hidden"/>
                                    <button type="submit" class="btn btn-danger">${locale_client_reservedtabel_btncancelreservation} </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
