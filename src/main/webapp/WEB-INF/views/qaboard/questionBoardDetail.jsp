<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div style="display: flex; justify-content: flex-end;">
    <button onclick="history.back()" style="padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer;">
        질답페이지로 돌아가기
    </button>
</div>
<div class="xl:container p-8">
    <div class="flex">
        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="20" height="30" fill="none" viewBox="0 0 14 20">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 7a3 3 0 0 1 3-3M5 19h4m0-3c0-4.1 4-4.9 4-9A6 6 0 1 0 1 7c0 4 4 5 4 9h4Z"/>
        </svg>
        <svg class="w-6 h-6 text-gray-800 dark:text-white ml-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 16">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 2-8.4 7.05a1 1 0 0 1-1.2 0L1 2m18 0a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1m18 0v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2"/>
        </svg>
        <svg class="w-6 h-6 text-gray-800 dark:text-white ml-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 20">
            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"  d="M4 7a3 3 0 0 1 3-3M5 19h4m0-3c0-4.1 4-4.9 4-9A6 6 0 1 0 1 7c0 4 4 5 4 9h4Z"/>
        </svg>
    </div>
    <div class="w-full p-6 bg-white border border-gray-200 rounded-lg shadow">
        <h5 class="mb-2 text-2xl font-semibold tracking-tight text-gray-900 ">${fn:escapeXml(questionBoardvo.title)}</h5>
        <p class="mb-3 font-normal text-gray-500">${questionBoardvo.member.name} (${questionBoardvo.member.memberId})</p>
        <p class="mb-3 font-normal text-gray-700">${questionBoardvo.content}</p>

        <div class="text-sm mt-2 font-medium text-gray-400">
            질문고유번호 <span>${questionBoardvo.qbNo}</span>
        </div>
        <div class="text-sm mt-2 font-medium text-gray-400">
            작성일
            <span>
            <fmt:parseDate value="${questionBoardvo.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>
            <fmt:formatDate value="${regDate}" pattern="yy/MM/dd HH:mm"/>
        </span>
        </div>
        <c:if test="${loginMember != null && loginMember.memberNo != questionBoardvo.memberNo}">
<%--        <c:if test="${loginMember != null}" >--%>
        <div style="display: flex; justify-content: flex-start;">
            <form>
                <button
                        type="button"
                    onclick="location.href = '${pageContext.request.contextPath}/qaboard/answerBoardCreate?qbNo=${questionBoardvo.qbNo}'"
                    class="px-5 py-2.5 mt-4 mr-4 sm:mt-6 text-sm font-medium text-center text-white bg-primary-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                답글 등록
                </button>
            </form>
            </c:if>
        </div>
            <div style="display: flex; justify-content: flex-end;">
         <c:if test="${loginMember != null && (loginMember.memberNo eq questionBoardvo.memberNo || loginMember.role eq Role.A)}">
                    <button
                            type="button"
                            onclick="location.href = '${pageContext.request.contextPath}/qaboard/questionBoardUpdate?qbNo=${questionBoardvo.qbNo}';"
                            class="px-5 py-2.5 mt-4 mr-4 sm:mt-6 text-sm font-medium text-center text-white bg-primary-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                        수정
                    </button>
                <button type="button"
                        onclick="confirm('정말 삭제하시겠습니까? 😯') && document.querySelector('#boardDeleteFrm').submit()"
                        class="px-5 py-2.5 mt-4 sm:mt-6 text-sm font-medium text-center text-white bg-red-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                    삭제
                </button>
                </c:if>
            </div>
        </div>
            <form
                    action="${pageContext.request.contextPath}/qaboard/questionBoardDelete"
                    method="post"
                    id="boardDeleteFrm">
                <input type="hidden" name="qbNo" value="${questionBoardvo.qbNo}">
            </form>
    </div>

<%-- 답변 --%>
<%--<c:if test = "${answerBoards!=null}">--%>
    <div class="xl:container p-8">

        <c:forEach items="${answerBoardvo}" var="answer" varStatus="vs">
            <div class="flex">
                <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="20" height="30" fill="none" viewBox="0 0 14 20">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 7a3 3 0 0 1 3-3M5 19h4m0-3c0-4.1 4-4.9 4-9A6 6 0 1 0 1 7c0 4 4 5 4 9h4Z"/>
                </svg>
                <svg class="w-6 h-6 text-gray-800 dark:text-white ml-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 8v10a1 1 0 0 0 1 1h16a1 1 0 0 0 1-1V8M1 8a1 1 0 0 1 .4-.8l8-5.75a1 1 0 0 1 1.2 0l8 5.75a1 1 0 0 1 .4.8M1 8l8.4 6.05a1 1 0 0 0 1.2 0L19 8"/>
                </svg>
                <svg class="w-6 h-6 text-gray-800 dark:text-white ml-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="20" height="30" fill="none" viewBox="0 0 14 20">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 7a3 3 0 0 1 3-3M5 19h4m0-3c0-4.1 4-4.9 4-9A6 6 0 1 0 1 7c0 4 4 5 4 9h4Z"/>
                </svg>
            </div>
            <div class="w-full p-6 bg-white border border-gray-200 rounded-lg shadow mb-4">
                <div class="xl:container p-8">
                    <h5 class="mb-2 text-2xl font-semibold tracking-tight text-gray-900 ">${fn:escapeXml(answer.title)}</h5>
                    <p class="mb-3 font-normal text-gray-500">${answer.member.name} (${answer.member.memberId})</p>
                    <p class="mb-3 font-normal text-gray-700">${answer.content}</p>
                    <div class="text-sm mt-2 font-medium text-gray-400">
                        답변고유번호 <span>${answer.acNo}</span>
                    </div>
                    <div class="text-sm mt-2 font-medium text-gray-400">
                        작성일
                        <fmt:parseDate value="${answer.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>
                        <fmt:formatDate value="${regDate}" pattern="yy/MM/dd HH:mm"/>
                    </div>
                    <div style="display: flex; justify-content: flex-end; align-items: flex-start;">
                        <input id="checkbox-all-search" type="checkbox" class="w-5 h-5 text-blue-400 bg-gray-100 border-gray-300 rounded focus:ring-blue-500">
                        <label for="checkbox-all-search" class="sr-only">checkbox</label>
                    </div>
                    <div style="display: flex; justify-content: flex-end;">
                        <c:if test="${loginMember != null && (loginMember.memberNo eq answer.memberNo || loginMember.role eq Role.A)}">
                        <button type="button"
                                onclick="location.href = '${pageContext.request.contextPath}/qaboard/answerBoardUpdate?acNo=${answer.acNo}';"
                                class="px-5 py-2.5 mt-4 mr-4 sm:mt-6 text-sm font-medium text-center text-white bg-primary-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                                수정
                        </button>
                        </c:if>
                        <c:if test="${loginMember != null && (questionBoardvo.qbNo eq answer.qbNo || loginMember.role eq Role.A)}">
                        <button type="button"
                                onclick="confirm('정말 삭제하시겠습니까? 😯') &&  document.querySelector('#answerboardDeleteFrm').submit()"
                                class="px-5 py-2.5 mt-4 sm:mt-6 text-sm font-medium text-center text-white bg-red-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                                삭제
                        </button>
                        </c:if>
                    </div>
                </div>
            </div>
            <form
                    action="${pageContext.request.contextPath}/qaboard/answerBoardDelete"
                    method="post"
                    id="answerboardDeleteFrm">
                    <%--            *** qb_No ac_No 해결 못함 null로 뜸***--%>
                <input type="hidden" name="qbNo" value="${questionBoardvo.qbNo}">
                <input type="hidden" name="acNo" value="${answer.acNo}">
            </form>
        </c:forEach>

        <form
                action="${pageContext.request.contextPath}/qaboard/questionBoardDelete"
                method="post"
                name="boardDeleteFrm">
            <input type="hidden" name="qbNo" value="${questionBoardvo.qbNo}">
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/qaboard/questionBoardDetail.js"></script>
