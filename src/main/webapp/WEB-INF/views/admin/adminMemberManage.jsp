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
                <th scope="col" class="px-6 py-3">닉네임</th>
                <th scope="col" class="px-6 py-3">이름</th>
                <th scope="col" class="px-6 py-3">가입일</th>
                <th scope="col" class="px-6 py-3">포인트</th>
                <th scope="col" class="px-6 py-3">회원 관리</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${members}" var="member" varStatus="vs">
                <form name="">
                    <tr class="odd:bg-white even:bg-gray-50 border-b ">
                        <td class="px-6 py-4">${member.memberNo}</td>
                        <td class="px-6 py-4">${member.nickName}</td>
                        <td class="px-6 py-4">${member.name}</td>
                        <td class="px-6 py-4">${member.regDate}</td>
                        <td class="px-6 py-4">${member.point}</td>
                        <td class="px-6 py-4">
                        <button type="submit"class="inline-flex items-center py-2.5 px-4 text-xs font-medium text-center text-white bg-blue-700 rounded-lg focus:ring-4 focus:ring-blue-200 hover:bg-blue-800">
                            유저 삭제
                        </button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
