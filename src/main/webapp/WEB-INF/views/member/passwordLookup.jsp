<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
        <h1 class="mb-6 text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl">
            비밀번호 찾기
        </h1>
        <form name="findIdFrm"  class="space-y-6" method="POST">
            <div>
                <label for="memberId" class="block text-sm font-medium leading-6 text-gray-900">아이디</label>
                <div class="mt-2">
                    <input id="memberId" name="memberId" type="text" required class="px-4 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                </div>
            </div>
            <div>
                <label for="name" class="block text-sm font-medium leading-6 text-gray-900">이름</label>
                <div class="mt-2">
                    <input id="name" name="name" type="text" required class="px-4 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                </div>
            </div>
            <div>
                <label for="birthDay" class="block text-sm font-medium leading-6 text-gray-900">생년월일</label>
                <div class="mt-2">
                    <input id="birthDay" name="birthDay" type="text" placeholder="YYYYMMDD" required class="px-4 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                </div>
            </div>

            <div>
                <select name="menu" id="menu" class="block text-sm font-medium leading-6 text-gray-900">
                    <option value="">== 가입시 선택한 질문  ==</option>
                    <option value="캐릭터">내가 좋아하는 캐릭터는?</option>
                    <option value="타인">타인이 모르는 자신만의 신체비밀이 있다면?</option>
                    <option value="홍박사">홍박사님을 아세여?</option>
                    <option value="좌우명">자신의 인생 좌우명은?</option>
                    <option value="짝꿍">초등학생때 기억에 남는 짝꿍은?</option>
                    <option value="친구">유년시절 가장 생각나는 친구 이름은?</option>
                    <option value="날짜">추억하고 싶은 날짜가 있다면?(예:19960408)</option>
                    <option value="환생">다시 태어나면 되고 싶은 것은?</option>
                    <option value="영화">가장 감명깊게 본 영화는?</option>
                    <option value="읽은책">읽은 책 중에서 좋아하는 구절이 있다면?</option>
                    <option value="장소">기억에 남는 추억의 장소는</option>
                    <option value="책이름">인상 깊게 읽은 책 이름은?</option>
                    <option value="보물">자신의 보물 제 1호는?</option>
                    <option value="선물">받았던 선물 중 기억에 남는 독특한 선물은?</option>
                    <option value="인물">자신이 두번째로 존경하는 인물은?</option>
                    <option value="아버지">아버지의 성함은?</option>
                    <option value="어머니">어머니의 성함은?</option>
                    <option value="여행">가장 여행하고 싶은 나라는?</option>
                </select>
<%--                <label for="answer" class="block text-sm font-medium leading-6 text-gray-900">가입 시 작성한 질문</label>--%>
                <div class="mt-2">
                    <input id="answer" name="answer" type="text" required class="px-4 block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6">
                </div>
            </div>

            <!-- Existing login form elements... -->

<%--            <div class="flex items-center">--%>
<%--                <input id="saveId" name="saveId" type="checkbox" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 rounded focus:ring-blue-500">--%>
<%--                <label for="saveId" class="ms-2 text-sm font-medium text-gray-700">아이디 저장</label>--%>
<%--                <a href="${pageContext.request.contextPath}" class="ms-2 text-sm font-medium text-gray-700">비밀번호 찾기</a>--%>
<%--            </div>--%>

            <div>
                <button type="submit" class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">비밀번호 찾기</button>
            </div>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/member/passwordLookup.js"></script>
