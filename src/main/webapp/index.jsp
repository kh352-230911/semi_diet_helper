<%@ page contentType="text/html; charset=utf-8"  pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<body>
<main class="p-4">
    <section id="section1" class="mb-8">
        <h2 class="text-2xl font-bold">다이어트 소개</h2>
        <p>다이어트에 대한 기본 소개와 필요한 정보를 제공합니다.</p>
    </section>

    <section id="section2" class="mb-8">
        <h2 class="text-2xl font-bold">식단 정보</h2>
        <p>건강한 식단 및 식이 관리에 대한 정보를 찾아보세요.</p>
    </section>

    <section id="section3" class="mb-8">
        <h2 class="text-2xl font-bold">운동 계획</h2>
        <p>효과적인 운동 계획과 운동에 관한 조언을 확인하세요.</p>
    </section>

    <section id="section4" class="mb-8">
        <h2 class="text-2xl font-bold">성공 스토리</h2>
        <p>다이어트에 성공한 이들의 경험과 스토리를 공유합니다.</p>
    </section>
</main>


<a href="${pageContext.request.contextPath}/daily/dailyRecode">일일 기록폼 페이지 이동</a>

<a href="${pageContext.request.contextPath}/member/memberMain">캘린더 페이지 이동</a>
</body>
</html>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
