<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<br><br>
    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
        <div class="flex justify-end">
            <button
                    type="button"
                    onclick="location.href = '${pageContext.request.contextPath}/admin/addFoodData';"

                    class="middle none center mr-4 rounded-lg bg-pink-500 py-3 px-5 font-sans text-base font-bold uppercase text-white shadow-md shadow-pink-500/20 transition-all hover:shadow-lg hover:shadow-pink-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none">
                음식 추가</button>
        </div>
        <br>
        <table class="w-full text-sm text-left rtl:text-right text-gray-500">
            <thead class="text-xs text-pink-700 uppercase bg-pink-50">
            <tr>
                <th scope="col" class="px-6 py-3">이름</th>
                <th scope="col" class="px-6 py-3">총 칼로리(kcal)</th>
                <th scope="col" class="px-6 py-3">탄수화물(g)</th>
                <th scope="col" class="px-6 py-3">단백질(g)</th>
                <th scope="col" class="px-6 py-3">지방(g)</th>
                <th scope="col" class="px-6 py-3">삭제하기</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${foodDatas}" var="foodData" varStatus="vs">
                <form name="adminMemberManageFrm" method="post">
                    <tr class="odd:bg-white even:bg-gray-50 border-b ">
                        <td class="px-6 py-4">${foodData.name}</td>
                        <td class="px-6 py-4">${foodData.kcal}</td>
                        <td class="px-6 py-4">${foodData.carbo}</td>
                        <td class="px-6 py-4">${foodData.prot}</td>
                        <td class="px-6 py-4">${foodData.fat}</td>
                        <td class="px-6 py-4">
                        <button type="submit" class="inline-flex items-center py-2.5 px-4 text-xs font-medium text-center text-white bg-pink-300 rounded-lg focus:ring-4 focus:ring-blue-200 hover:bg-pink-500">
                            음식 삭제
                        </button>
                        <input type="hidden" value="${foodData.foodNo}" name="foodNo" id="foodNo">
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
            <%-- 생성한 pagebar --%>
            ${pagebar}
        </ul>
    </nav>
</div>