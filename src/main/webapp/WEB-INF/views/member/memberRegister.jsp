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

<form action="memberRegister" method="post">

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

        <button type="submit" class="text-white w-full bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">회원가입</button>
        <p class="text-sm font-light text-gray-500">
            이미 회원이신가요? <a href="#" class="font-medium text-primary-600 hover:underline">여기서 로그인하세요😀</a>
        </p>

    </form>

    </section>
<script src="${pageContext.request.contextPath}/js/member/memberRegister.js"></script>

