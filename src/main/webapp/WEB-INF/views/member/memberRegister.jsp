<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 12/12/2023
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<section>
    <!DOCTYPE html>
    <html>
    <head>
        <title>User Registration Form</title>
    </head>
    <body>

    <form action="memberRegisterFrm" method="post">

        <label for="memberId">아이디:</label>
        <input type="text" id="memberId" name="memberId" required><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="nickName">닉네임:</label>
        <input type="text" id="nickName" name="nickName" required><br>

        <label for="height">키:</label>
        <input type="text" id="height" name="height" required><br>

        <label for="birthDay">생년월일:</label>
        <input type="text" id="birthDay" name="birthDay" required><br>

        <label for="weightLossGoal">감량목표:</label>
        <input type="text" id="weightLossGoal" name="weightLossGoal" required><br>

        <label for="answer">비밀번호 찾기용 질문에 대한 답:</label>
        <input type="text" id="answer" name="answer" required><br>

        <input type="submit" value="등록">

    </form>

    </body>

    </html>
