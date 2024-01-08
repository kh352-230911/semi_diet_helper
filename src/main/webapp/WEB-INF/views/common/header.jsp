<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sh.diet.member.model.entity.Role" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>🐽다우미 :: 다이어트도우미</title>
    <link href="https://webfontworld.github.io/SaenggeoJincheon/SaenggeoJincheon.css" rel="stylesheet">

    <script src="https://cdn.tailwindcss.com"></script>
    <script src="${pageContext.request.contextPath}/js/tailwind.config.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script>
        const contextPath = '${pageContext.request.contextPath}';
        <c:if test="${msg != null}">
        alert(`${msg}`);
        // 여러줄 작성을 위해 `` 을 사용해 감싸준다
        <%--session 속성 msg를 제거해서 1회만 출력되도록 한다 --%>
        <c:remove var="msg" scope="session"/>
        </c:if>
    </script>

    <style>
        @font-face {
            font-family : '이쁜폰트';
            src : ${pageContext.request.contextPath} (nanumsquare.ttf)
        }
        * { font-family: 'TangsBudaeJjigae';}
body {background-color: white;}
    </style>
        <style>
         .body1 {
             display:grid;
             grid-template-rows: 1fr 10rem auto;
             grid-template-areas:"main" "." "footer";
             overflow-x:hidden;
             background: #f9a8d4;
             min-height:100vh;
             font-family: 'Open Sans', sans-serif;
             .footer {
                 z-index: 1;
                 --footer-background: #f9a8d4;
                 display:grid;
                 position: relative;
                 grid-area: footer;
                 min-height:12rem;
                 .bubbles {
                     position: absolute;
                     top:0;
                     left:0;
                     right:0;
                     height:1rem;
                     background:var(--footer-background);
                     filter:url("#blob");
                     .bubble {
                         position: absolute;
                         left:var(--position, 50%);
                         background:var(--footer-background);
                         border-radius:100%;
                         animation:bubble-size var(--time, 4s) ease-in infinite var(--delay, 0s),
                         bubble-move var(--time, 4s) ease-in infinite var(--delay, 0s);
                         transform:translate(-50%, 100%);
                     }
                 }
                 .content {
                     z-index: 2;
                     display:grid;
                     grid-template-columns: 1fr auto;
                     grid-gap: 4rem;
                     padding:2rem;
                     background:var(--footer-background);
                     a, p {
                         color:#F5F7FA;
                         text-decoration:none;
                     }
                     b {
                         color:white;
                     }
                     p {
                         margin:0;
                         font-size:.75rem;
                     }
                     >div {
                         display:flex;
                         flex-direction:column;
                         justify-content: center;
                         >div {
                             margin:0.25rem 0;
                             >* {
                                 margin-right:.5rem;
                             }
                         }
                         .image {
                             align-self: center;
                             width:4rem;
                             height:4rem;
                             margin:0.25rem 0;
                             background-size: cover;
                             background-position: center;
                         }
                     }
                 }
             }
         }

        @keyframes bubble-size {
            0%, 75% {
                width:var(--size, 4rem);
                height:var(--size, 4rem);
            }
            100% {
                width:0rem;
                height:0rem;
            }
        }
        @keyframes bubble-move {
            0% {
                bottom:-4rem;
            }
            100% {
                bottom:var(--distance, 10rem);
            }
        }



    </style>

</head>

<nav class="bg-white border-gray-200 dark:bg-pink-300 mb-auto">
    <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-2">
        <a href="${pageContext.request.contextPath}" class="flex items-center space-x-3 rtl:space-x-reverse">
            <img src="${pageContext.request.contextPath}/images/dawumi_white.svg" class="h-20" alt="dawumi_logo" fill="red" />
            <span class="self-center text-4xl font-semibold whitespace-nowrap dark:text-white">다우미</span>
        </a>
        <ul class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 rtl:space-x-reverse md:mt-0 md:border-0 md:bg-white dark:bg-pink-300 md:dark:bg-pink-300 dark:border-gray-700">
            <c:if test="${loginMember == null}">
                <li>
                    <a href="${pageContext.request.contextPath}/member/memberLogin" class="block py-2 px-3 text-white bg-pink-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-white-500" aria-current="page">로그인</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/member/memberRegister" class="block py-2 px-3 text-white bg-pink-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-white-500" aria-current="page">회원가입</a>
                </li>
            </c:if>
            <c:if test="${loginMember != null}">
                <li>
                    <a href="${pageContext.request.contextPath}/exercise/bodyPartList" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">운동영상 조회</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/qaboard/questionBoardList" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">질문답변게시판</a>
                </li>
                <li>
                <c:if test="${loginMember.role == Role.A}">
                    <a href="#" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">관리페이지</a>
                    </li>
                </c:if>
                <li>
                    <a href="${pageContext.request.contextPath}/member/memberDetail" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">${loginMember.memberId}님, 안녕하세요🐽</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/member/memberLogout" class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">로그아웃</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
