<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="xl:container p-8">
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
        <%-- 작성자 본인과 관리자에게만 노출 --%>
        <c:if test="${loginMember.memberId eq questionBoardvo.member.memberId || loginMember.role eq Role.A}">
            <div style="display: flex; justify-content: flex-end;">
                <button
                        type="button"
                        onclick="location.href = '${pageContext.request.contextPath}/qaboard/questionBoardUpdate?qbNo=${questionBoardvo.qbNo}';"
                        class="px-5 py-2.5 mt-4 mr-4 sm:mt-6 text-sm font-medium text-center text-white bg-primary-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                    수정
                </button>
                <button type="button"
                        onclick="confirm('정말 삭제하시겠습니까? 😯') && document.boardDeleteFrm.submit()"
                        class="px-5 py-2.5 mt-4 sm:mt-6 text-sm font-medium text-center text-white bg-red-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                    삭제
                </button>
            </div>
        </div>
            <form
                    action="${pageContext.request.contextPath}/qaboard/questionBoardDelete"
                    method="post"
                    name="boardDeleteFrm">
                <input type="hidden" name="qbNo" value="${questionBoardvo.qbNo}">
            </form>
        </c:if>
    </div>

<%-- 답변 --%>
<%--<c:if test = "${answerBoards!=null}">--%>
<div class="xl:container p-8">
    <div class="w-full p-6 bg-white border border-gray-200 rounded-lg shadow">
<%--        <input type="hidden" name="qbNo" value="${answer.qbNo}">--%>
<c:forEach items="${answerBoardvo}" var="answer" varStatus="vs">
    <div class="xl:container p-8">
        <h5 class="mb-2 text-2xl font-semibold tracking-tight text-gray-900 ">${fn:escapeXml(answer.title)}</h5>
        <p class="mb-3 font-normal text-gray-500">${answer.member.name} (${answer.member.memberId})</p>
        <p class="mb-3 font-normal text-gray-700">${answer.content}</p>
        <div class="text-sm mt-2 font-medium text-gray-400">
            답변고유번호 <span>${answer.acNo}</span>
<%--            <input type="hidden" name="acNo" value="${answer.acNo}">--%>
        </div>
        <div class="text-sm mt-2 font-medium text-gray-400">
            작성일
                <fmt:parseDate value="${answer.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>
                <fmt:formatDate value="${regDate}" pattern="yy/MM/dd HH:mm"/>
            </span>
        </div>

         <div style="display: flex; justify-content: flex-end;">
            <button
                    type="button"
                    onclick="location.href = '${pageContext.request.contextPath}/qaboard/answerBoardUpdate?acNo=${answer.acNo}';"
                    class="px-5 py-2.5 mt-4 mr-4 sm:mt-6 text-sm font-medium text-center text-white bg-primary-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                수정

            </button>

            <button type="button"
                    onclick="confirm('정말 삭제하시겠습니까? 😯') && document.answerboardDeleteFrm.submit()"
                    class="px-5 py-2.5 mt-4 sm:mt-6 text-sm font-medium text-center text-white bg-red-700 rounded-lg focus:ring-4 focus:ring-primary-200">
                삭제
            </button>
        </div>
    </div>
    <form
            action="${pageContext.request.contextPath}/qaboard/answerBoardDelete"
            method="post"
            name="answerboardDeleteFrm">
        <input type="hidden" name="acNo" value="${answer.acNo}">
    </form>
</c:forEach>
<%--</c:if>--%>
</div></div>

<script src="${pageContext.request.contextPath}/js/qaboard/questionBoardDetail.js"></script>
