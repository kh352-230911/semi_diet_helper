<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<div class="container mx-auto my-6">--%>
<%--    <div class="flex justify-start">--%>
<%--        <h1 class="m-4 text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">--%>
<%--            게시판--%>
<%--        </h1>--%>
<%--    </div>--%>
<%--    <div class="flex justify-end">--%>
<%--        <button type="button" class="text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">글쓰기</button>--%>
<%--    </div>--%>
<%--    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">--%>
<%--        <table class="w-full text-sm text-left rtl:text-right text-gray-500">--%>
<%--            <thead class="text-xs text-gray-700 uppercase bg-gray-50">--%>
<%--        <c:forEach items="${questionboards}" var="questionboard" varStatus="vs">--%>
<%--            <tr>--%>
<%--                <th scope="col" class="px-6 py-3">질문고유번호</th>--%>
<%--                <th scope="col" class="px-6 py-3">회원고유번호</th>--%>
<%--                <th scope="col" class="px-6 py-3">제목</th>--%>
<%--                <th scope="col" class="px-6 py-3">본문</th>--%>
<%--                <th scope="col" class="px-6 py-3">조회수</th>--%>
<%--                <th scope="col" class="px-6 py-3">작성일</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr class="odd:bg-white even:bg-gray-50 border-b ">--%>
<%--                <td class="px-6 py-4">${questionboard.qbNo}</td>--%>
<%--                <td class="px-6 py-4">${questionboard.memberNo}</td>--%>
<%--                <td class="px-6 py-4">${questionboard.title}</td>--%>
<%--                <td class="px-6 py-4">${questionboard.content}</td>--%>
<%--                <td class="px-6 py-4">${questionboard.count}</td>--%>
<%--                <td class="px-6 py-4">${questionboard.regDate}</td>--%>
<%--&lt;%&ndash;                <td class="px-6 py-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <fmt:parseDate value="${questionboard.regDate}" pattern="yyyy-MM-dd'T'HH:mm" var="regDate"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <fmt:formatDate value="${regDate}" pattern="yy/MM/dd HH:mm:ss"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </td>&ndash;%&gt;--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--&lt;%&ndash;    <div class="flex justify-center mt-6">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <nav aria-label="Page navigation example">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <ul class="flex items-center -space-x-px h-8 text-sm">&ndash;%&gt;--%>
<%--&lt;%&ndash;                ${pagebar}&ndash;%&gt;--%>
<%--&lt;%&ndash;            </ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </nav>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>
<%--</div>--%>