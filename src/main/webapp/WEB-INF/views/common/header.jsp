<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sh.diet.member.model.entity.Role" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello MVC</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="${pageContext.request.contextPath}/js/tailwind.config.js"></script>
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script>
        const contextPath = '${pageContext.request.contextPath}';
        <c:if test="${msg != null}">

        alert(`${msg}`)
        // 여러줄 작성을 위해 `` 을 사용해 감싸준다
        <%--session 속성 msg를 제거해서 1회만 출력되도록 한다 --%>
        <c:remove var="msg" scope="session"/>
        </c:if>
    </script>
</head>
<body>
<div class="3xl:container">
    <header class=" bg-sky-200 text-gray-600 body-font">
        <div class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
            <a class="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-linecap="round"
                     stroke-linejoin="round" stroke-width="2"
                     class="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full" viewBox="0 0 24 24">
                    <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
                </svg>
                <a href="${pageContext.request.contextPath}/" class="ml-3 text-3xl text-5xl">다우미</a>
            </a>
            <c:if test="${loginMember == null}">
                <nav class="md:ml-auto  flex flex-wrap items-center text-base justify-center">
                    <a href="${pageContext.request.contextPath}/member/memberLogin"
                       class="text-xl mr-5 hover:text-gray-900">로그인</a>
                    <a href="${pageContext.request.contextPath}/member/memberRegister"
                       class="text-xl mr-5 hover:text-gray-900">회원가입</a>
                </nav>
            </c:if>
            <c:if test="${loginMember != null}">
                <nav class="md:mr-auto flex text-3xl flex-wrap items-center text-base justify-center">
                    <a href="" class="text-xl ml-5 hover:text-gray-900">Group 페이지</a>
                    <a href="${pageContext.request.contextPath}/exercise/bodyPartList" class="text-xl ml-5 hover:text-gray-900">운동영상 조회</a>
                    <a href="${pageContext.request.contextPath}/qaboard/questionBoardList" class="text-xl ml-5 hover:text-gray-900">질답 게시판</a>
                    <a class="text-xl  ml-5 hover:text-gray-900">주변 헬스장 조회</a>
                    <a class="text-xl  mx-14 hover:text-gray-900"></a>
                    <c:if test="${loginMember.role == Role.A}">
                        <nav class="md:ml-auto flex text-3xl flex-wrap items-center text-base justify-center">
                            <a class="text-xl mr-5 hover:text-gray-900">관리 페이지</a>
                        </nav>
                    </c:if>
                    <nav class="md:ml-auto flex text-3xl flex-wrap items-center text-base justify-center">
                    <a href="${pageContext.request.contextPath}/member/memberDetail"
                       class="text-xl ml-auto text-gray-600 hover:underline">${loginMember.memberId}</a>님, 안녕하세요🥑
                    <a href="${pageContext.request.contextPath}/member/memberLogout" class="text-xl  ml-5 hover:text-gray-900">로그아웃</a>
                    </nav>
                </nav>
            </c:if>
            <%--            <c:if test="${loginMember.role == Role.A}">--%>
            <%--                <nav class="md:ml-auto flex text-3xl flex-wrap items-center text-base justify-center">--%>
            <%--                    <a class="text-xl mr-5 hover:text-gray-900"></a>--%>
            <%--                    <a class="text-xl mr-5 hover:text-gray-900"></a>--%>
            <%--                    <a class="text-xl mr-5 hover:text-gray-900"></a>--%>
            <%--                    <a class="text-xl  mr-5 hover:text-gray-900"></a>--%>
            <%--                </nav>--%>
            <%--            </c:if>--%>
            <%--<button class="inline-flex items-center bg-gray-100 border-0 py-1 px-3 focus:outline-none hover:bg-gray-200 rounded text-base mt-4 md:mt-0">Button--%>
            <%--    <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-4 h-4 ml-1" viewBox="0 0 24 24">--%>
            <%--        <path d="M5 12h14M12 5l7 7-7 7"></path>--%>
            <%--    </svg>--%>
            <%--</button>--%>
        </div>
    </header>
    <main class="w-full min-h-[80vh]">