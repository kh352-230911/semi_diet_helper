<%--
  Created by IntelliJ IDEA.
  User: audwn
  Date: 2024-01-01
  Time: 오후 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="celebRegisterFrm">
    <fieldset>
        <legend>Celeb 등록폼</legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <label for="today-weight">오늘의 몸무게</label>
                </th>
                <td>
                    <input type="text" name="name" id="today-weight" />
                </td>
            </tr>
            <tr>
                <th>
                    <label for="meal">식사</label>
                </th>
                <td>
                    <select name="type" id="meal">
                        <option value="morning">아침</option>
                        <option value="lunch">점심</option>
                        <option value="dinner">저녁</option>
                        <option value="snack">간식</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="gain-kcal">kcal</label>
                </th>
                <td>
                    <input type="file" name="kcal" id="gain-kcal" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>등록</button>
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset>
</form>

<script
        src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
<script>
    const contextPath = '${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath}/js/dailyrecode.js"></script>

</body>
</html>
