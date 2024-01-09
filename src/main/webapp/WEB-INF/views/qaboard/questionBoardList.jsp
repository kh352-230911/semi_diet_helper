
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container mx-auto my-6">
    <div class="flex justify-start">
        <h1 class="m-4 text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
            질답게시판
        </h1>
    </div>
    <form name="boardSearchFrm">
        <div class="p-4 bg-white flex">
            <select id="search-type" name="search-type" required class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 p-1.5">
                <option value="" disabled selected>검색</option>
                <option value="member_id" ${param['search-type'] eq 'member_id' ? 'selected' : ''}>회원아이디</option>
                <option value="m.member_no" ${param['search-type'] eq 'member_no' ? 'selected' : ''}>회원고유번호</option>
                <option value="qb_no" ${param['search-type'] eq 'qb_no' ? 'selected' : ''}>질문고유번호</option>
            </select>
            <div class="ml-1">
                <input type="search" id="search-keyword" name="search-keyword" placeholder="검색어를 입력하세요..." value="${param['search-keyword']}" required class="block p-2 text-sm text-gray-900 border border-gray-300 rounded-lg w-80 bg-gray-50 focus:ring-blue-500 focus:border-blue-500" >
            </div>
        </div>
    </form>
    <c:if test="${loginMember != null}">
        <div class="flex justify-end">
            <button
                    type="button"
                    onclick="location.href = '${pageContext.request.contextPath}/qaboard/questionBoardCreate';"

                    class="middle none center mr-4 rounded-lg bg-pink-500 py-3 px-5 font-sans text-base font-bold uppercase text-white shadow-md shadow-pink-500/20 transition-all hover:shadow-lg hover:shadow-pink-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none">

                    글쓰기</button>
        </div>
    </c:if><br>
    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left rtl:text-right text-gray-500">

            <thead class="text-xs text-pink-700 uppercase bg-pink-50">

            <tr>
                <th scope="col" class="px-6 py-3">질문고유번호</th>
                <th scope="col" class="px-6 py-3">회원고유번호</th>
                <th scope="col" class="px-6 py-3">회원아이디</th>
                <th scope="col" class="px-6 py-3">제목</th>
                        <%--   본문을 굳이 목록에?? 일단 보류    --%>
<%--                <th scope="col" class="px-6 py-3">본문</th>--%>
                <th scope="col" class="px-6 py-3">작성일</th>
                <th scope="col" class="px-6 py-3">추천 게시물 선정</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${questionBoardvos}" var="qaboardvo" varStatus="vs">

                <tr class="odd:bg-white even:bg-gray-50 border-b ">


                    <th scope="row" class="px-6 py-4 font-medium text-pink-300 whitespace-nowrap">${qaboardvo.qbNo}</th>
                    <td class="px-6 py-4">${qaboardvo.memberNo}</td>
                    <td class="px-6 py-4">${qaboardvo.member.memberId}</td>
                            <%--  조회수인듯 몰겠음 일단 주석함  --%>
<%--                        <c:if test="${board.commentCount ge 10}">--%>
<%--                            <span class="inline-flex items-center rounded-md bg-red-50 px-2 py-1 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">${board.commentCount}</span>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${board.commentCount gt 0 && board.commentCount lt 10}">--%>
<%--                            <span class="inline-flex items-center rounded-md bg-gray-50 px-2 py-1 text-xs font-medium text-gray-700 ring-1 ring-inset ring-gray-600/10">${board.commentCount}</span>--%>
<%--                        </c:if>--%>
                    <td class="px-6 py-4">
                        <a href="${pageContext.request.contextPath}/qaboard/questionBoardDetail?qbNo=${qaboardvo.qbNo}" class="hover:underline">${fn:escapeXml(qaboardvo.title)}</a>
                    </td>

<%--                    <td class="px-6 py-4">${qaboardvo.regDate}</td>--%>
                    <td class="px-6 py-4">
                        <fmt:parseDate value="${qaboardvo.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>
                        <fmt:formatDate value="${regDate}" pattern="yy/MM/dd"/>
                    </td>


                    <td class="px-6 py-4">${qaboardvo.adminChoice}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="flex justify-center mt-6">
    <nav aria-label="Page navigation example">
        <ul class="my-8 flex items-center -space-x-px h-8 text-sm">
            <%-- 생성한 pagebar --%>
            ${pagebar}
        </ul>
    </nav>
</div>

