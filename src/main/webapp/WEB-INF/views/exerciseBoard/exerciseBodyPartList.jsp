<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<br><br><br>
    <body style="display: flex;
                flex-direction: column;
                flex: 1;
                width: 100%;
                height: 100%;
                -webkit-font-smoothing: antialiased;
                -moz-osx-font-smoothing: grayscale;">
    <div class="grid grid-cols-2 gap-4">
        <div class="bg-[#d9d9d9] p-4 text-center text-xl text-black">
            <a href="${pageContext.request.contextPath}/exercise/bodyPartList">
                스크랩
            </a>
        </div>
        <c:forEach items="${bodyParts}" var="bodypart" varStatus="vs">
            <div class="bg-[#d9d9d9] p-4 text-center text-xl text-black">
                <a href="${pageContext.request.contextPath}/exercise/bodyPartDetail?id=${bodypart}">
                    ${bodypart}
                </a>
            </div>
        </c:forEach>
    </div>
    </body>
</html>


<%--</body>--%>
<%--<div class="bg-gradient-to-bl from-blue-50 to-violet-50 flex items-center justify-center lg:h-screen">--%>
<%--    <div class="container mx-auto mx-auto p-4">--%>
<%--        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-2 lg:grid-cols-4 xl:grid-cols-4 gap-4">--%>
<%--            <!-- Replace this with your grid items -->--%>
<%--            <div class="bg-white rounded-lg border p-4">--%>
<%--                <img src="https://placehold.co/300x200/d1d4ff/352cb5.png" alt="Placeholder Image" class="w-full h-48 rounded-md object-cover">--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <div class="font-bold text-xl mb-2">Blog Title</div>--%>
<%--                    <p class="text-gray-700 text-base">--%>
<%--                        This is a simple blog card example using Tailwind CSS. You can replace this text with your own blog content.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <a href="#" class="text-blue-500 hover:underline">Read More</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="bg-white rounded-lg border p-4">--%>
<%--                <img src="https://placehold.co/300x200/d1d4ff/352cb5.png" alt="Placeholder Image" class="w-full h-48 rounded-md object-cover">--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <div class="font-bold text-xl mb-2">Blog Title</div>--%>
<%--                    <p class="text-gray-700 text-base">--%>
<%--                        This is a simple blog card example using Tailwind CSS. You can replace this text with your own blog content.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <a href="#" class="text-blue-500 hover:underline">Read More</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="bg-white rounded-lg border p-4">--%>
<%--                <img src="https://placehold.co/300x200/d1d4ff/352cb5.png" alt="Placeholder Image" class="w-full h-48 rounded-md object-cover">--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <div class="font-bold text-xl mb-2">Blog Title</div>--%>
<%--                    <p class="text-gray-700 text-base">--%>
<%--                        This is a simple blog card example using Tailwind CSS. You can replace this text with your own blog content.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <a href="#" class="text-blue-500 hover:underline">Read More</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="bg-white rounded-lg border p-4">--%>
<%--                <img src="https://placehold.co/300x200/d1d4ff/352cb5.png" alt="Placeholder Image" class="w-full h-48 rounded-md object-cover">--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <div class="font-bold text-xl mb-2">Blog Title</div>--%>
<%--                    <p class="text-gray-700 text-base">--%>
<%--                        This is a simple blog card example using Tailwind CSS. You can replace this text with your own blog content.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="px-1 py-4">--%>
<%--                    <a href="#" class="text-blue-500 hover:underline">Read More</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <!-- Add more items as needed -->--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>