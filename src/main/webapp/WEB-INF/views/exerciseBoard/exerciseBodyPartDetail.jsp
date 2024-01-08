<%--
  Created by IntelliJ IDEA.
  User: hanjunhee
  Date: 1/5/24
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sh.diet.member.model.entity.Role" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>


<div class="bg-white p-8 rounded-md w-full">
    <div class=" flex items-center justify-between pb-6">
        <div>
            <h2 class="text-gray-600 font-semibold">운동영상 조회</h2>
            <%--<span class="text-xs">All products item</span>--%>
        </div>
        <div class="flex items-center justify-between">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20"
                     fill="currentColor">
                    <%--<path fill-rule="evenodd"--%>
                    <%--      d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"--%>
                    <%--      clip-rule="evenodd"/>--%>
                </svg>
            <c:if test="${loginMember.role eq Role.A}">
                <div class="lg:ml-40 ml-10 space-x-8">
                    <%--<button class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"--%>
                    <%--        id ="submitCheckbox"--%>
                    <%--        onclick="submitCheckbox()"--%>
                    <%-->--%>
                    <%--    체크한 운동 삭제--%>
                    <%--</button>--%>
                    <form action="${pageContext.request.contextPath}/exercise/addExercise"
                    method="get">
                    <button type="submit" class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                    >운동 추가
                    </button>
                    </form>
                </div>
            </c:if>
        </div>
    </div>
    <div>
        <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
            <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
                <table class="min-w-full leading-normal">
                    <thead>
                    <tr>
                        <c:if test="${loginMember.role eq Role.A}">
                            <th
                                    class="px-3 py-3 border-b-2 border-gray-200 bg-gray-100  text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            </th>
                        </c:if>
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
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">

                        </th>
                        <th
                                class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                            스크랩
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${exerciseDatas}" var="exerciseData" varStatus="vs">
                        <tr>
                            <c:if test="${loginMember.role eq Role.A}">
                                <form
                                        action="${pageContext.request.contextPath}/exercise/deleteExerciseData"
                                        method="post">
                                <td class='px-5 py-5 border-b border-gray-200 bg-white text-sm'>
                                    <button type="submit"
                                            style="width: 82px;"
                                            class="bg-red-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer"
                                    >
                                        <input type="hidden" value="${exerciseData.exNo}" name="exNo">
                                        <input type="hidden" value="${exerciseData.bodyPart}" name="bodyPart">
                                        삭제하기
                                    </button>
                                </td>
                                </form>
                            </c:if>
                            <td class="px-3 text-left border-b border-gray-200 bg-white text-sm ">
                                <div class="flex justify-center">
                                    <div class="flex-shrink-0 w-30 h-15">
                                            <%--여러 객체를 가져오기 위한 c:set --%>
                                        <c:set var="index" value="${vs.index}"/>
                                        <a href="${exerciseData.exUrl}">
                                            <img src="${imgUrls[index]}">
                                        </a>
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
                            <c:if test="${scrapCheck[index] == null}">
                                <form action="${pageContext.request.contextPath}/exercise/addScrapExercise"
                                      method="post">
                                    <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                        <button
                                                class="middle none center mr-4 rounded-lg bg-blue-500 py-3 px-5 font-sans text-xs font-bold uppercase text-white shadow-md shadow-blue-500/20 transition-all hover:shadow-lg hover:shadow-blue-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                                                data-ripple-light="true"
                                        >
                                            스크랩하기
                                        </button>
                                    </td>
                                    <input type="hidden" name="memberNo" value="${loginMember.memberNo}">
                                    <input type="hidden" name="exNo" value="${exerciseData.exNo}">
                                </form>
                            </c:if>
                            <c:if test="${scrapCheck[index] != null}">
                                <form action="${pageContext.request.contextPath}/exercise/deleteScrapExercise"
                                      method="post">
                                    <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                                        <button
                                                style="width: 100px"
                                                class="scrapButton middle none center mr-4 rounded-lg bg-blue-500 py-3 px-5 font-sans text-xs font-bold uppercase text-white shadow-md shadow-blue-500/20 transition-all hover:shadow-lg hover:shadow-blue-500/40 focus:opacity-[0.85] focus:shadow-none active:opacity-[0.85] active:shadow-none disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                                                data-ripple-light="true"
                                                onmouseover="changeText()"
                                                onmouseout="defaultText()"
                                        >
                                            스크랩 중
                                        </button>
                                    </td>
                                    <input type="hidden" name="memberNo" value="${loginMember.memberNo}">
                                    <input type="hidden" name="exNo" value="${exerciseData.exNo}">
                                </form>
                            </c:if>
                        </tr>
                    </c:forEach>
                    <form

                            method="post"
                            name="exerciseDeleteFrm">
                        <input type="hidden" name="exNo" value="${exerciseData.exNo}">
                    </form>
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
<script src = "${pageContext.request.contextPath}/js/exercise/exBodyDetail.js">
</script>
</html>
