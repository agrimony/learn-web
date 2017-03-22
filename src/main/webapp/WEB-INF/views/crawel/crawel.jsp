<%--
  Created by IntelliJ IDEA.
  User: hou
  Date: 3/12/17
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../layout/header.jsp"></jsp:include>
</head>
<body>
<div class="container-fluid">
    <form method="post" action="/crawel/addcrawelBooks.html">
        <div class="form-group">
            <label for="website">抓取页面:</label>
            <input type="text" class="form-control" id="website" placeholder="http://">
        </div>
        <div class="form-group">
            <label for="rule">抓取规则:</label>
            <input type="text" class="form-control" id="rule" placeholder="ul > li">
        </div>
        <div class="form-group">
            <label for="exampleInputFile">File input</label>
            <input type="file" id="exampleInputFile">
            <p class="help-block">Example block-level help text here.</p>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Check me out
            </label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

</div>
</body>
</html>
