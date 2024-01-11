<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <h1 class="mb-10 text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
            로그인
        </h1>
        <form class="max-w-md mx-auto" name="memberLoginFrm" class="space-y-6" method="POST">
            <div class="relative z-0 w-full mb-7 group">
                <input type="text" name="memberId" id="memberId"
                       class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                       placeholder=" " required />
                <label for="memberId"
                       class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6"
                >아이디</label>
            </div>
            <div class="relative z-0 w-full mb-7 group">
                <input type="password" name="password" id="password"
                       class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
                       placeholder=" " required />
                <label for="password"
                       class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6"
                >비밀번호</label>
            </div>
            <div class="flex items-center">
                <input id="saveId" name="saveId" type="checkbox"
                       class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 rounded focus:ring-blue-500" />
                <label for="saveId" class="ms-2 text-sm font-medium text-gray-700">아이디 저장</label>
                <a href="${pageContext.request.contextPath}" class="ms-2 text-sm font-medium text-gray-700">아이디 찾기</a>
                <a href="${pageContext.request.contextPath}/member/passwordLookup"
                   class="ms-2 text-sm font-medium text-gray-700">비밀번호 찾기</a>
            </div>
            <button type="submit"
                    class="mt-8 text-white w-full bg-pink-300 hover:bg-pink-400 focus:ring-4 focus:outline-none focus:ring-pink-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                로그인
            </button>

        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/member/memberLogin.js"></script>
