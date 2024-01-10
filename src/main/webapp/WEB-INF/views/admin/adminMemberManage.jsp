<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div class="w-full p-8 bg-white border border-gray-200 rounded-lg shadow">
        <table class="w-full p-8 bg-white border border-gray-200 rounded-lg shadow">
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
                <form name="adminMemberManageFrm" method="post">
                    <tr class="odd:bg-white even:bg-gray-50 border-b ">
                        <td class="px-6 py-4 text-center">${member.memberNo}</td>
                        <td class="px-6 py-4 text-center">${member.nickName}</td>
                        <td class="px-6 py-4 text-center">${member.name}</td>
                        <td class="px-6 py-4 text-center">${member.regDate}</td>
                        <td class="px-6 py-4 text-center">${member.point}</td>
                        <td class="px-6 py-4 text-center">
                        <button type="submit" class="text-center middle none center mr-2 rounded-lg bg-pink-500 py-2 px-3 font-sans text-base font-bold uppercase text-white shadow-md shadow-pink-500/20 transition-all hover:shadow-lg hover:shadow-pink-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none">
                            유저 삭제
                        </button>
                        <input type="hidden" value="${member.memberId}" name="memberId" id="memberId">
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="flex justify-center mt-6">
        <nav aria-label="Page navigation example">
            <ul class="my-8 flex items-center -space-x-px h-8 text-sm">
                ${pagebar}
            </ul>
        </nav>
    </div>
</html>