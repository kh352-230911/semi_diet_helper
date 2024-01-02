<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 질문 폼 --%>
<div class="xl:container p-8">
    <div class="w-full p-6 bg-white border border-gray-200 rounded-lg shadow">
        <h5 class="mb-2 text-2xl font-semibold tracking-tight text-gray-900 ">${fn:escapeXml(qaboard.title)}(${qaboard.qbNo})</h5>
        <p class="mb-3 font-normal text-gray-700">${qaboard.content}</p>
        <p class="mb-3 font-normal text-gray-500">${qaboard.member.name} (${qaboard.memberId}) [${qaboard.memberNo}]</p>
        <div class="text-sm mt-2 font-medium text-gray-400">
            작성일
            <span>
            <fmt:parseDate value="${qaboard.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>
            <fmt:formatDate value="${regDate}" pattern="yy/MM/dd HH:mm"/>
        </span>
        </div>
        <div class="text-sm mt-2 font-medium text-gray-400">
            추천게시물설정 <span>${qaboard.adminChoice}</span>
        </div>
        <!-- 답글 폼 -->
<%--        <div class="w-full my-2">--%>
<%--            <form--%>
<%--                    name="boardCommentCreateFrm"--%>
<%--                    action="${pageContext.request.contextPath}/board/boardCommentCreate"--%>
<%--                    method="post">--%>
<%--                <input type="hidden" name="boardId" value="${board.id}">--%>
<%--                <input type="hidden" name="memberId" value="${loginMember.id}">--%>
<%--                <input type="hidden" name="commentLevel" value="1">--%>
<%--                <div class="w-full mb-4 border border-gray-200 rounded-lg bg-gray-50">--%>
<%--                    <div class="px-4 py-2 bg-white rounded-t-lg">--%>
<%--                        <label for="content" class="sr-only">댓글 작성하기</label>--%>
<%--                        <textarea id="content"--%>
<%--                                  name="content"--%>
<%--                                  rows="4"--%>
<%--                                  onclick="'${loginMember.id}' || alert('로그인후 댓글을 작성하세요');"--%>
<%--                                  class="resize-none w-full px-0 text-sm text-gray-900 bg-white border-0"--%>
<%--                                  placeholder="댓글을 작성하세요" required></textarea>--%>
<%--                    </div>--%>
<%--                    <div class="flex items-center justify-end px-3 py-2 border-t">--%>
<%--                        <button type="submit"--%>
<%--                                class="inline-flex items-center py-2.5 px-4 text-xs font-medium text-center text-white bg-blue-700 rounded-lg focus:ring-4 focus:ring-blue-200 hover:bg-blue-800">--%>
<%--                            댓글 등록--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>