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
    <div class="w-[1152px] h-[120px] absolute left-[-1px] top-[-1px] bg-[#d9d9d9]"></div>
    <p class="w-[135px] h-[41px] absolute left-[640px] top-[50px] text-xl text-center text-black">
        <span class="w-[135px] h-[41px] text-xl text-center text-black">주변 헬스장</span><br /><span
            class="w-[135px] h-[41px] text-xl text-center text-black"
    >
      조회</span
    >
    </p>
    <p class="w-[135px] h-[41px] absolute left-[211px] top-[41px] text-xl text-center text-black">
        <span class="w-[135px] h-[41px] text-xl text-center text-black">group </span><br /><span
            class="w-[135px] h-[41px] text-xl text-center text-black"
    >페이지</span
    ><br />
    </p>
    <p class="w-[135px] h-[41px] absolute left-[346px] top-[50px] text-xl text-center text-black">
        <span class="w-[135px] h-[41px] text-xl text-center text-black">운동 영상</span><br /><span
            class="w-[135px] h-[41px] text-xl text-center text-black"
    >
      페이지</span
    ><br /><br />
    </p>
    <p class="w-[135px] h-[41px] absolute left-[490px] top-14 text-xl text-center text-black">
        <span class="w-[135px] h-[41px] text-xl text-center text-black">질답 게시판</span><br />
    </p>
    <p class="w-[135px] h-[41px] absolute left-[895px] top-[54px] text-xl text-center text-black">
        <span class="w-[135px] h-[41px] text-xl text-center text-black">정보수정</span><br />
    </p>
    <p class="w-[135px] h-[41px] absolute left-[1011px] top-[54px] text-xl text-center text-black">
        로그아웃
    </p>
    <p class="w-40 h-12 absolute left-12 top-9 text-[40px] text-left text-black">다우미</p>
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
</body>
</html>
