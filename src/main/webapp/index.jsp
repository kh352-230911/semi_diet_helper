<%@ page contentType="text/html; charset=utf-8"  pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<body>
<div class="w-[1150px] h-[700px] relative overflow-hidden bg-white">

    <p class="absolute left-[121px] top-[264px] text-[40px] text-left text-black">
        <span class="text-[40px] text-left text-black">사이트 설명</span><br />
    </p>
    <div
            class="flex justify-center items-center w-[680px] h-[463px] absolute left-[389px] top-[85px] gap-2.5 px-[43px] py-[55px] bg-[#d9d9d9]">
        <p class="flex-grow-0 flex-shrink-0 text-[40px] text-left text-black">홈페이지 썸네일</p>
    </div>
</div>

<a href="${pageContext.request.contextPath}/daily/dailyRecode">일일 기록폼 페이지 이동</a>
<a href="${pageContext.request.contextPath}/member/memberMain">캘린더 페이지 이동</a>
</body>
</html>
