<%--
  Created by IntelliJ IDEA.
  User: hanjunhee
  Date: 1/5/24
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>


<!-- component -->
<div class="bg-white p-8 rounded-md w-full">
    <div class=" flex items-center justify-between pb-6">
        <div>
            <h2 class="text-gray-600 font-semibold">운동영상 조회</h2>
            <span class="text-xs">All products item</span>
        </div>

        <div class="flex items-center justify-between">
            <div class="flex bg-gray-50 items-center p-2 rounded-md">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20"
                     fill="currentColor">
                    <path fill-rule="evenodd"
                          d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                          clip-rule="evenodd" />
                </svg>
                <input class="bg-gray-50 outline-none ml-1 block " type="text" name="" id="" placeholder="search...">
            </div>
            <div class="lg:ml-40 ml-10 space-x-8">
                <button class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer">New Report</button>
                <button class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer">Create</button>
            </div>
        </div>
    </div>
    <div>
        <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
            <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
                <table class="min-w-full leading-normal">
                    <thead>
                    <tr>
                        <th
                                class="px-3 py-3 border-b-2 border-gray-200 bg-gray-100  text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            운동영상 링크
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            운동명
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            10분당 소모 칼로리
                        </th>
                        <%--<th--%>
                        <%--        class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">--%>
                        <%--    QRT--%>
                        <%--</th>--%>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            스크랩 여부
                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            스크랩하기
                        </th>
                    </tr>
                    </thead>
<%--                            ${imgUrls}--%>
                        <tbody>
                            <c:forEach items= "${exerciseDatas}" var="exerciseData" varStatus="vs">
                            <tr>
                                <td class="px-3 text-left border-b border-gray-200 bg-white text-sm ">
                                    <div class="flex justify-center">
                                        <div class="flex-shrink-0 w-30 h-15">
                                            <%--여러 객체를 가져오기 위한 c:set --%>
                                            <c:set var="index" value="${vs.index}"/>
                                            <img src="${imgUrls[index]}">
                                            <a href="${exerciseData.exUrl}">운동 영상 보러가기</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <p class="text-gray-900 whitespace-no-wrap">${exerciseData.exName}</p>
                                </td>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <p class="text-gray-900 whitespace-no-wrap">
                                            ${exerciseData.kcal}
                                    </p>
                                </td>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                    <p class="text-gray-900 whitespace-no-wrap">

                                    </p>
                                </td>
                                <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                            <span
                                                    class="relative inline-block px-3 py-1 font-semibold text-green-900 leading-tight">
                                                <span aria-hidden
                                                      class="absolute inset-0 bg-green-200 opacity-50 rounded-full"></span>
                                            <span class="relative">Activo</span>
                                            </span>
                                </td>
                        </c:forEach>
                    </tbody>
                </table>
                <div
                        class="px-5 py-5 bg-white border-t flex flex-col xs:flex-row items-center xs:justify-between          ">
						<span class="text-xs xs:text-sm text-gray-900">
                            Showing 1 to 4 of 50 Entries
                        </span>
                    <div class="inline-flex mt-2 xs:mt-0">
                        <button
                                class="text-sm text-indigo-50 transition duration-150 hover:bg-indigo-500 bg-indigo-600 font-semibold py-2 px-4 rounded-l">
                            Prev
                        </button>
                        &nbsp; &nbsp;
                        <button
                                class="text-sm text-indigo-50 transition duration-150 hover:bg-indigo-500 bg-indigo-600 font-semibold py-2 px-4 rounded-r">
                            Next
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--체크박스--%>
<%--    <td class ="px-5 py-5 border-b border-gray-200 bg-white text-sm">--%>
<%--        <div class="inline-flex items-center">--%>
<%--            <label--%>
<%--                    class="relative flex cursor-pointer items-center rounded-full p-3"--%>
<%--                    for="checkbox-8"--%>
<%--                    data-ripple-dark="true"--%>
<%--            >--%>
<%--                <input--%>
<%--                        type="checkbox"--%>
<%--                        class="before:content[''] peer relative h-5 w-5 cursor-pointer appearance-none rounded-md border border-blue-gray-200 transition-all before:absolute before:top-2/4 before:left-2/4 before:block before:h-12 before:w-12 before:-translate-y-2/4 before:-translate-x-2/4 before:rounded-full before:bg-blue-gray-500 before:opacity-0 before:transition-opacity checked:border-blue-500 checked:bg-blue-500 checked:before:bg-blue-500 hover:before:opacity-10"--%>
<%--                        id="checkbox-8"--%>
<%--                        checked--%>
<%--                />--%>
<%--                <div class="pointer-events-none absolute top-2/4 left-2/4 -translate-y-2/4 -translate-x-2/4 text-white opacity-0 transition-opacity peer-checked:opacity-100">--%>
<%--                    <svg--%>
<%--                            xmlns="http://www.w3.org/2000/svg"--%>
<%--                            class="h-3.5 w-3.5"--%>
<%--                            viewBox="0 0 20 20"--%>
<%--                            fill="currentColor"--%>
<%--                            stroke="currentColor"--%>
<%--                            stroke-width="1"--%>
<%--                    >--%>
<%--                        <path--%>
<%--                                fill-rule="evenodd"--%>
<%--                                d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"--%>
<%--                                clip-rule="evenodd"--%>
<%--                        ></path>--%>
<%--                    </svg>--%>
<%--                </div>--%>
<%--            </label>--%>
<%--        </div>--%>
<%--    </td>--%>
<%--</tr>--%>

<script src = "${pageContext.request.contextPath}/js/exercise/exerciseThumbnailUrl.js">
</script>
</html>
