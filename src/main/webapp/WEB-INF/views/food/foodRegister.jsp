<%--
  Created by IntelliJ IDEA.
  User: hanjunhee
  Date: 1/11/24
  Time: 4:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8"
>
    <form action="${pageContext.request.contextPath}/admin/addFoodData"
          method="post"
          class="max-w-md mx-auto bg-white p-8 rounded-lg border border-gray-300 shadow-2xl">

        <div class="mb-5">
            <label for="name" class="block text-sm text-gray-500 dark:text-gray-400 mb-1">새 음식 이름</label>
            <input type="text" name="name" id="name" class="block w-full py-2.5 px-4 text-sm text-gray-900 bg-transparent border-b-2 border-gray-300 dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600" placeholder=" " required />
        </div>

        <br><br>

        <div class="mb-5">
            <label for="kcal" class="block text-sm text-gray-500 dark:text-gray-400 mb-1">칼로리</label>
            <input type="text" name="kcal" id="kcal" class="block w-full py-2.5 px-4 text-sm text-gray-900 bg-transparent border-b-2 border-gray-300 dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600" placeholder=" " required />
        </div>



        <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div class="mb-5">
                <label for="carbo" class="block text-sm text-gray-500 dark:text-gray-400 mb-1">탄수화물</label>
                <input type="text" name="carbo" id="carbo" class="block w-full py-2.5 px-4 text-sm text-gray-900 bg-transparent border-b-2 border-gray-300 dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600" placeholder=" " />
            </div>

            <div class="mb-5">
                <label for="prot" class="block text-sm text-gray-500 dark:text-gray-400 mb-1">단백질</label>
                <input type="text" name="prot" id="prot" class="block w-full py-2.5 px-4 text-sm text-gray-900 bg-transparent border-b-2 border-gray-300 dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600" placeholder=" " />
            </div>

            <div class="mb-5">
                <label for="fat" class="block text-sm text-gray-500 dark:text-gray-400 mb-1">지방</label>
                <input type="text" name="fat" id="fat" class="block w-full py-2.5 px-4 text-sm text-gray-900 bg-transparent border-b-2 border-gray-300 dark:text-black dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600" placeholder=" " />
            </div>
        </div>

        <button type="submit" class="mt-8 text-white w-full bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">새 음식 등록</button>
    </form>

</div>

<%--<script src="${pageContext.request.contextPath}/js/exercise/exRegister.js">--%>

</script>
</body>
</html>