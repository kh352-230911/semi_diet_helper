<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<body>



<div class="flex space-x-24 flex justify-center mt-24">
<div class="max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-pink-300 dark:border-gray-700">
    <a href="${pageContext.request.contextPath}/adminMemberManage">
        <img class="rounded-t-lg" src="${pageContext.request.contextPath}/images/pizza.png" alt="" />
    </a>
    <div class="p-5">
        <a href="${pageContext.request.contextPath}/adminMemberManage">
            <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">회원관리</h5>
        </a>
        <p class="mb-3 font-normal text-gray-700 dark:text-white">악성유저를 탈퇴시킬 수 있습니다.</p>
        <a href="${pageContext.request.contextPath}/adminMemberManage" class="inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-pink-700 rounded-lg hover:bg-pink-800 focus:ring-4 focus:outline-none focus:ring-pink-300 dark:bg-pink-500 dark:hover:bg-red-700 dark:focus:ring-blue-800">
            처단하기
            <svg class="rtl:rotate-180 w-3.5 h-3.5 ms-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
            </svg>
        </a>
    </div>
</div>



<div class="max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
    <a href="#">
        <img class="rounded-t-lg" src="${pageContext.request.contextPath}/images/foodInsert.jpg" alt="" />
    </a>
    <div class="p-5">
        <a href="#">
            <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">등록된 음식관리</h5>
        </a>
        <p class="mb-3 font-normal text-gray-700 dark:text-gray-400">증말~~ 마시케따~</p>
        <a href="#" class="inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            고고혓
            <svg class="rtl:rotate-180 w-3.5 h-3.5 ms-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
            </svg>
        </a>
    </div>
</div>
</div>
</body>
</html>
