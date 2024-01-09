<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="py-8 px-4 mx-auto max-w-2xl lg:py-16">
    <h2 class="mb-4 text-xl font-bold text-gray-900">질답게시글 수정</h2>
    <form name="boardCreateFrm" method="post">
        <div class="grid gap-4 sm:grid-cols-2 sm:gap-6">
            <div class="sm:col-span-2">
                <label for="title" class="block mb-2 text-sm font-medium text-gray-900">제목</label>
                <input type="text" name="title" id="title" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" placeholder="제목을 작성하세요." required>
            </div>
            <%--            <div class="sm:col-span-2">--%>
            <%--                <label for="memberId" class="block mb-2 text-sm font-medium text-gray-900">작성자</label>--%>
            <%--                <input type="text" name="memberId" id="memberId" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" value="${loginMember.id}" required readonly>--%>
            <%--            </div>--%>
            <div class="sm:col-span-2">
                <label for="memberNo" class="block mb-2 text-sm font-medium text-gray-900">회원고유번호</label>
                <input type="text" name="memberNo" id="memberNo" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5" value="${questionBoard.memberNo}" required readonly>
            </div>
            <div class="sm:col-span-2">
                <label for="content" class="block mb-2 text-sm font-medium text-gray-900">본문</label>
                <textarea name="content" id="content" rows="8" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-primary-500 focus:border-primary-500" placeholder="내용을 작성하세요." required></textarea>
            </div>
        </div>

        <button type="submit" class="inline-flex items-center px-5 py-2.5 mt-4 sm:mt-6 text-sm font-medium text-center text-white bg-primary-700 rounded-lg focus:ring-4 focus:ring-primary-200">
            저장
        </button>
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/qaboard/questionBoardUpdate.js"></script>