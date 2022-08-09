<%--
  Created by IntelliJ IDEA.
  User: Truon
  Date: 5/25/2022
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<div id="formContent">
    <!-- Tabs Titles -->
    <!-- Icon -->
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}">
            <strong>${message}</strong>
        </div>
    </c:if>
    <div class="fadeIn first">
        <h1>Đăng nhập</h1>
    </div>
    <!-- Login Form -->
    <form id="formLogin" method="post" action="<c:url value="/dang-nhap"/>">
        <input type="text" id="userName" class="fadeIn second" name="userName" placeholder="Tên đăng nhập">
        <input type="password" id="password" class="fadeIn third" name="passWord" placeholder="Mật khẩu">
        <input type="hidden" name="action" value="login" >
        <input type="submit" class="fadeIn fourth" value="Đăng nhập">
    </form>
    <!-- Remind Passowrd -->
<!--    <div id="formFooter">-->
<!--        <a class="underlineHover" href="#">Forgot Password?</a>-->
<!--    </div>-->
</div>
</body>
</html>
