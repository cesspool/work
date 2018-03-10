<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <title>Ð ÐµÐ³Ð¸ÑÑÑÐ°ÑÐ¸Ñ</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="../CSS/registration.css" />

    <link rel="stylesheet" href="../assets/css/main.css" />
    <link rel="stylesheet" type="text/css" href="../Login_v2/css/main.css">
    <link rel="stylesheet" type="text/css" href="../Login_v2/css/util.css">
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>

<body>

<form class="registration">
    <div class="container limiter">
            <span class="login100-form-title p-b-26">
                Ð ÐµÐ³Ð¸ÑÑÑÐ°ÑÐ¸Ñ
            </span>
        <span class="p-b-26">ÐÐ¾Ð¶Ð°Ð»ÑÐ¹ÑÑÐ°, Ð·Ð°Ð¿Ð¾Ð»Ð½Ð¸ÑÐµ ÑÐ»ÐµÐ´ÑÑÑÐ¸Ðµ Ð¿Ð¾Ð»Ñ:</span>
    <table width="100%" cellspacing="0" cellpadding="5">
            <td width="200" valign="top">
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="paulkapay@gmail.com" name="email" required>

                <label for="phone"><b>Ð¢ÐµÐ»ÐµÑÐ¾Ð½</b></label>
                <input type="text" placeholder="+7(926)723-16-50" name="email" required>

                <label for="city"><b>ÐÐ¾ÑÐ¾Ð´</b></label>
                <input type="text" placeholder="ÐÐ¾ÑÐºÐ²Ð°" name="email" required>
            </td>
            <td width="200" valign="top">
                <label for="lastName"><b>Ð¤Ð°Ð¼Ð¸Ð»Ð¸Ñ</b></label>
                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²" name="email" required>

                <label for="firstName"><b>ÐÐ¼Ñ</b></label>
                <input type="text" placeholder="ÐÐ²Ð°Ð½" name="email" required>

                <label for="patronymic"><b>ÐÑÑÐµÑÑÐ²Ð¾</b></label>
                <input type="text" placeholder="ÐÐ²Ð°Ð½Ð¾Ð²Ð¸Ñ" name="email" required>
            </td>

            <td width="200" valign="top">
                <label for="psw"><b>ÐÐ°ÑÐ¾Ð»Ñ</b></label>
                <input type="password" placeholder="ÐÐ²ÐµÐ´Ð¸ÑÐµ Ð¿Ð°ÑÐ¾Ð»Ñ" name="psw" required>

                <label for="psw-repeat"><b>ÐÐ¾Ð²ÑÐ¾ÑÐ½ÑÐ¹ Ð¿Ð°ÑÐ¾Ð»Ñ</b></label>
                <input type="password" placeholder="ÐÐ²ÐµÐ´Ð¸ÑÐµ Ð¿Ð°ÑÐ¾Ð»Ñ ÐµÑÐµ ÑÐ°Ð·" name="psw-repeat" required>
            </td>

    </table>
            <div class="clearfix">
                <button type="button" class="cancelbtn">Cancel</button>
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
    </div>
</form>

</body>
</html>
