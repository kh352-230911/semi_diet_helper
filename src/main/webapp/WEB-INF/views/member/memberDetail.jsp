<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 12/13/2023
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="flex flex-col items-center justify-center px-6 py-8 mx-auto lg:py-0">
    <div class="w-full bg-white rounded-lg shadow my-4 sm:max-w-md xl:p-0">
        <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
            <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
                ${loginMember.name}님, 안녕하세요🐽
            </h1>
            <form name="memberUpdateFrm" action="${pageContext.request.contextPath}/member/memberUpdate" method="post" class="space-y-4 md:space-y-6">
                <div>
                    <label for="id" class="block mb-2 text-sm font-medium text-gray-900 after:content-['*'] after:ml-0.5 after:text-red-500">아이디</label>
                    <input type="text" name="id" id="id" value="${loginMember.memberId}" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" readonly required>
                </div>
                <div>
                    <label for="name" class="block mb-2 text-sm font-medium text-gray-900 after:content-['*'] after:ml-0.5 after:text-red-500">이름</label>
                    <input type="text" name="name" id="name" value="${loginMember.name}" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" disabled required>
                </div>
                <div>
                    <label for="birthDay" class="block mb-2 text-sm font-medium text-gray-900">생일</label>
                    <input type="text" name="birthDay" id="birthDay" value="${loginMember.birthDay}" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5">
                </div>

                <div>
                    <label for="point" class="block mb-2 text-sm font-medium text-gray-900">포인트</label>
                    <input type="number" name="point" id="point" value="${loginMember.point}" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" readonly>
                </div>

                <button type="button" onclick="location.href = '${pageContext.request.contextPath}/member/updatePassword';" class="text-white w-full bg-pink-300 hover:bg-pink-400 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">비밀번호 변경</button>
                <%--                    <button type="submit" class="text-white w-full bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">저장</button>--%>
                <p class="text-sm font-light text-red-500"><a href="javascript:confirm('🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?🐽진짜 탈퇴하실거에요?') && document.memberDeleteFrm.submit();" class="font-medium text-red-600 hover:underline">회원탈퇴하기🐽</a>  << 근데 다이어트 안하세요?
                </p>
            </form>
        </div>
    </div>
</div>
<form action="${pageContext.request.contextPath}/member/memberDelete" method="post" name="memberDeleteFrm"></form>
<script src="${pageContext.request.contextPath}/js/member/memberDetail.js"></script>
