<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 12/25/16
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
<jsp:include page="../layout/header.jsp"></jsp:include>
    <script src="../../js/books.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
//            var cb=new crawelBook();
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div>book list</div>
        <div class="col-md-2">title ${count}</div>
        <div class="col-md-10">
            <table class="table table-bordered table-hover">
                <thead>
                <tr><th>ID</th>
                    <th>bookName</th>
                    <th>bookLink</th>
                    <th>updateTime</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.bookName}</td>
                        <td><a href="${item.bookLink}" target="_blank">${item.bookLink}</a></td>
                        <td>
                            <fmt:formatDate value="${item.insertTime}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<%--<script src="js/bootstrap.min.js"></script>--%>
</body>
</html>
