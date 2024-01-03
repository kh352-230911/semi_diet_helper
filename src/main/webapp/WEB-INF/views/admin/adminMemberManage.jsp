<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<br><br>
<body>
    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left rtl:text-right text-gray-500">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-3">회원번호</th>
                <th scope="col" class="px-6 py-3">가입일</th>
                <th scope="col" class="px-6 py-3">작성글 내역</th>
                <th scope="col" class="px-6 py-3">회원 관리</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${members}" var="member" varStatus="vs">
                <tr class="odd:bg-white even:bg-gray-50 border-b ">
                    <td class="px-6 py-4">${member.memberNo}</td>
                    <td class="px-6 py-4">${member.regDate}</td>
                    <td class="px-6 py-4">
                        <%--<a href="">총 ${} 건</a>--%>
                    </td>
                    <td class="px-6 py-4">
                        <button
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
