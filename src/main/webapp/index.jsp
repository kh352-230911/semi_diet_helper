<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"  pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<main class="p-4" style="margin-top: -300px;">


    <section class="bg-white dark:">
        <div class="py-8 px-4 mx-auto max-w-screen-xl text-center lg:py-16">
            <h1 class="mb-4 text-4xl font-extrabold tracking-tight leading-none text-gray-900 md:text-5xl lg:text-6xl dark:text-black">언제까지 내일부터라고 하실겁니까?</h1>
            <p class="mb-8 text-lg font-normal text-gray-500 lg:text-xl sm:px-16 lg:px-48 dark:text-red-700 font-bold">다우미와 함께라면 당신도 살을 뺄 수 있습니다. 지금 당장 시작하세요.</p>
            <c:if test="${loginMember == null}">
            <div class="flex flex-col space-y-4 sm:flex-row sm:justify-center sm:space-y-0">
                <a href="${pageContext.request.contextPath}/member/memberRegister" class="inline-flex justify-center items-center py-3 px-5 text-base font-medium text-center text-white rounded-lg bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 dark:focus:ring-red-900">
                    당장 회원가입부터 하기
                    <svg class="w-3.5 h-3.5 ms-2 rtl:rotate-180" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                    </svg>
                </a>

            </div>
            </c:if>
        </div>
    </section>

</main>


<%--<a href="${pageContext.request.contextPath}/daily/dailyRecode">일일 기록폼 페이지 이동</a>--%>

</body>
</html>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
