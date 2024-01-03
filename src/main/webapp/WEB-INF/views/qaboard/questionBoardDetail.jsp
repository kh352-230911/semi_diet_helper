<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sh.diet.member.model.entity.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <%-- 작성자 본인과 관리자에게만 노출 --%>
        <c:if test="${loginMember.memberId eq questionBoardvo.member.memberId || loginMember.role eq Role.A}">
            <div class="flex justify-end">
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
            <form
                    action="${pageContext.request.contextPath}/qaboard/questionBoardDelete"
                    method="post"
                    name="boardDeleteFrm">
                <input type="hidden" name="memberId" value="${questionBoardvo.member.memberId}">
            </form>
        </c:if>
    </div>

    <!-- 답글 폼 -->
    <div class="w-full my-2">
        <form
                name="boardCommentCreateFrm"
                action="${pageContext.request.contextPath}/qaboard/answerBoardCreate"
                method="post">
            <input type="hidden" name="name" value="${questionBoardvo.member.name}">
            <input type="hidden" name="memberId" value="${loginMember.memberId}">
            <div class="w-full mb-4 border border-gray-200 rounded-lg bg-gray-50">
                <div class="px-4 py-2 bg-white rounded-t-lg">
                    <label for="content" class="sr-only">답글 작성하기</label>
                    <textarea id="content"
                              name="content"
                              rows="4"
                              onclick="'${loginMember.memberId}' || alert('로그인후 댓글을 작성하세요');"
                              class="resize-none w-full px-0 text-sm text-gray-900 bg-white border-0"
                              placeholder="답글을 작성하세요" required></textarea>
                </div>
                <div class="flex items-center justify-end px-3 py-2 border-t">
                    <button type="submit"
                            class="inline-flex items-center py-2.5 px-4 text-xs font-medium text-center text-white bg-blue-700 rounded-lg focus:ring-4 focus:ring-blue-200 hover:bg-blue-800">
                        답글 등록
                    </button>
                </div>
            </div>
        </form>
    </div>

    <!-- 답글 테이블 얘는 일단 보류-->
<%--    <div class="relative my-8 shadow-xl sm:rounded-lg">--%>
<%--        <table class="w-full text-sm text-left rtl:text-right text-gray-500">--%>
<%--            <tbody>--%>
<%--                    &lt;%&ndash; 답글 tr &ndash;%&gt;--%>
<%--                    <tr class="bg-white border-b hover:bg-gray-50">--%>
<%--                        <td scope="row" colspan="2" class="w-4/6 px-6 py-4 font-medium text-gray-800">--%>
<%--                            <sub class="text-gray-500">${questionBoardvo.member.memberId}</sub>--%>
<%--                            <sub class="text-gray-400">--%>
<%--                                <fmt:parseDate value="${answerBoard.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>--%>
<%--                                <fmt:formatDate value="${regDate}" pattern="yy/MM/dd HH:mm"/>--%>
<%--                            </sub>--%>
<%--                            <h2>${answerBoard.title}</h2>--%>
<%--                            <p class="mt-2">--%>
<%--                                    ${answerBoard.content}--%>
<%--                            </p>--%>
<%--                        </td>--%>
<%--                        <td class="px-8 py-4">--%>
<%--                            <c:if test="${loginMember.memberId eq questionBoardvo.member.memberId || loginMember.role eq Role.A}">--%>
<%--                                <div class="flex">--%>
<%--                                    <a href="javascript:confirm('수정하시겠습니까? 😲') && document.boardCommentDeleteFrm${comment.id}.submit();" class="font-medium text-red-600 hover:underline ms-3">수정</a>--%>
<%--                                </div>--%>
<%--                                <form name="boardCommentDeleteFrm${questionBoardvo.member.memberId}" action="${pageContext.request.contextPath}/qaboard/answerBoardUpdate" method="post">--%>
<%--                                    <input type="hidden" name="name" value="${questionBoardvo.member.name}">--%>
<%--                                    <input type="hidden" name="memberId" value="${loginMember.memberId}">--%>
<%--                                </form>--%>
<%--                            </c:if>--%>
<%--                        </td>--%>
<%--                        <td class="px-1 py-4">--%>
<%--                            <c:if test="${loginMember.memberId eq questionBoardvo.member.memberId || loginMember.role eq Role.A}">--%>
<%--                                <div class="flex">--%>
<%--                                    <a href="javascript:confirm('정말 삭제하시겠습니까? 😲') && document.boardCommentDeleteFrm${comment.id}.submit();" class="font-medium text-red-600 hover:underline ms-3">삭제</a>--%>
<%--                                </div>--%>
<%--                                <form name="boardCommentDeleteFrm${questionBoardvo.member.memberId}" action="${pageContext.request.contextPath}/qaboard/answerBoardDelete" method="post">--%>
<%--                                    <input type="hidden" name="name" value="${questionBoardvo.member.name}">--%>
<%--                                    <input type="hidden" name="memberId" value="${loginMember.memberId}">--%>
<%--                                </form>--%>
<%--                            </c:if>--%>
<%--                        </td>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
    </div>
</div>
<script>

</script>
<script src="${pageContext.request.contextPath}/js/qbboard/questionBoardDetail.js"></script>
