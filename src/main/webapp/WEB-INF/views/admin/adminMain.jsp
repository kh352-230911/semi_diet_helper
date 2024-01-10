<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<body style="display: flex;
            flex-direction: column;
            flex: 1;
            width: 100%;
            height: 100%;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;">
<div class="w-[1152px] h-[700px] relative overflow-hidden bg-white">
    <div class="w-[161px] h-11 absolute left-[259px] top-[276px] bg-[#d9d9d9]"></div>
    <p class="w-[141px] h-5 absolute left-[270px] top-[289px] text-xl text-center text-black">
        <span class="w-[141px] h-5 text-xl text-center text-black">신고 게시물 관리</span><br />
    </p>
    <div class="w-[161px] h-11 absolute left-[492px] top-[276px] bg-[#d9d9d9]"></div>
    <a href="${pageContext.request.contextPath}/adminMemberManage" class="w-[141px] h-5 absolute left-[503px] top-[289px] text-xl text-center text-black">
        회원 관리

    </a>
    <div class="w-[161px] h-11 absolute left-[725px] top-[276px] bg-[#d9d9d9]"></div>
    <p class="w-[141px] h-5 absolute left-[736px] top-[289px] text-xl text-center text-black">
        회원 통계 조회
    </p>
    <div class="w-[161px] h-11 absolute left-[251px] top-[477px] bg-[#d9d9d9]"></div>
    <p class="w-[141px] h-5 absolute left-[262px] top-[490px] text-xl text-center text-black">
        등록 음식 관리
    </p>
    <div class="w-[161px] h-11 absolute left-[494px] top-[477px] bg-[#d9d9d9]"></div>
    <p class="w-[141px] h-5 absolute left-[505px] top-[490px] text-xl text-center text-black">
        등록 운동 관리
    </p>
    <div class="w-[161px] h-11 absolute left-[733px] top-[477px] bg-[#d9d9d9]"></div>
    <p class="w-[141px] h-5 absolute left-[744px] top-[490px] text-xl text-center text-black">
        그룹 관리
    </p>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>