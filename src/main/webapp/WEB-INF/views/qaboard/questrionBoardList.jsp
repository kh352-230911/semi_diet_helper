
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container mx-auto my-6">
    <div class="flex justify-start">
        <h1 class="m-4 text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
            질답게시판
        </h1>
    </div>

    <%--    <c:if test="${loginMember != null}">--%>
    <div class="flex justify-end">
        <button
                type="button"
                onclick="location.href = '${pageContext.request.contextPath}/qaboard/questionBoardCreate';"
                class="text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">글쓰기</button>
    </div>
    <%--    </c:if>--%>
    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left rtl:text-right text-gray-500">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-3">질문고유번호</th>
                <th scope="col" class="px-6 py-3">회원고유번호</th>
                <th scope="col" class="px-6 py-3">제목</th>
                <%--   본문을 굳이 목록에?? 일단 보류    --%>
                <%--                <th scope="col" class="px-6 py-3">본문</th>--%>
                <th scope="col" class="px-6 py-3">작성일</th>
                <th scope="col" class="px-6 py-3">추천 게시물 선정</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${questionBoards}" var="qaboard" varStatus="vs">
                <tr class="odd:bg-white even:bg-gray-50 border-b ">
                    <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap">${questionBoard.qbNo}</th>
                    <td class="px-6 py-4">${questionBoard.memberNo}</td>
                        <%--  조회수인듯 몰겠음 일단 주석함  --%>
                        <%--                        <c:if test="${board.commentCount ge 10}">--%>
                        <%--                            <span class="inline-flex items-center rounded-md bg-red-50 px-2 py-1 text-xs font-medium text-red-700 ring-1 ring-inset ring-red-600/10">${board.commentCount}</span>--%>
                        <%--                        </c:if>--%>
                        <%--                        <c:if test="${board.commentCount gt 0 && board.commentCount lt 10}">--%>
                        <%--                            <span class="inline-flex items-center rounded-md bg-gray-50 px-2 py-1 text-xs font-medium text-gray-700 ring-1 ring-inset ring-gray-600/10">${board.commentCount}</span>--%>
                        <%--                        </c:if>--%>
                    <td class="px-6 py-4">
                        <a href="${pageContext.request.contextPath}/qaboard/questionBoardDetail?qaNo=${questionBoard.qbNo}" class="hover:underline">${fn:escapeXml(questionBoard.title)}</a>
                    </td>
                    <td class="px-6 py-4">${questionBoard.regDate}</td>
                        <%--                    <td class="px-6 py-4">--%>
                        <%--                        <fmt:parseDate value="${qaboard.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>--%>
                        <%--                        <fmt:formatDate value="${regDate}" pattern="yy/MM/dd"/>--%>
                        <%--                    </td>--%>
                    <td class="px-6 py-4">${questionBoard.adminChoice}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%--<div class="flex justify-center mt-6">--%>
<%--    <nav aria-label="Page navigation example">--%>
<%--        <ul class="my-8 flex items-center -space-x-px h-8 text-sm">--%>
<%--            &lt;%&ndash; 생성한 pagebar &ndash;%&gt;--%>
<%--            ${pagebar}--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--</div>--%>

