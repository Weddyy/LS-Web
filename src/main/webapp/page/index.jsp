<%@ page import="com.Stone.Pages.Login" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta name="description" content="LolStone">
    <meta name="keywords" content="League of legend,lol,speck">
    <title>League of legend</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/anim.css">
    <link rel="stylesheet" href="/css/main.css">

    <script type="text/javascript" src="/js/jquery-2.2.0.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="/js/holder.js"></script>
    <script src="/js/bootstrap.js"></script>
    <script src="/js/validator.js"></script>
    <script type="text/javascript" src="/js/Stone.js"></script>
</head>

<body>
<div class="main_light">
    <div class="lite1"></div>
    <div class="lite2"></div>
    <div class="lite3"></div>
    <div class="lite4"></div>
    <div class="lite5"></div>
    <div class="lite6"></div>
    <div class="lite7"></div>
    <div class="lite8"></div>
</div>
<div id="top">
    <a class="btn_Home" href="/index" onclick="return openPage('/index','/index/1');"><span class="glyphicon glyphicon-home" style="margin-right:4px"></span>Home</a>
    <a class="btn_Game" href="/speak" onclick="return openPage('/speak','/speak/1');"><span class="glyphicon glyphicon-eye-open" style="margin-right:4px"></span>Games</a>
    <div class="lng">
        <a id="btn_eng" onclick="openPage('eng')"></a>
        <a id="btn_ru" onclick="openPage('ru')"></a>
    </div>
    <div id="user_form">
        <c:choose>
            <c:when test="${user != null}">
                <%=Login.LOGIN %>
            </c:when>
            <c:otherwise>
                <%=Login.NO_LOGIN %>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="top_line"></div>
</div>
<div class="head">
    <div id="zilean">
        <div id="smokeOne"></div>
        <div id="smokeTwo"></div>
    </div>
</div>

<div id="wrapper">
    <c:if test="${textBody != null}">
        ${textBody}
    </c:if>
</div>

<jsp:include page="login_form.jsp" />
<jsp:include page="reg_form.jsp" />
</body>
</html>