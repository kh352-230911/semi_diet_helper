<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
<form name="dailyRecodeFrm">
    <fieldset>
        <legend>일일 기록폼</legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <label for="today-weight">오늘의 몸무게</label>
                </th>
                <td>
                    <input type="text" name="today-weight" id="today-weight" />
                </td>
            </tr>
            <tr>
                <th>
                    <label for="meal-time">음식 섭취 시간</label>
                </th>
                <td>
                    <select name="meal-time" id="meal-time">
                        <option value="M">아침</option>
                        <option value="L">점심</option>
                        <option value="D">저녁</option>
                        <option value="S">간식</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="meal">음식</label>
                </th>
                <td>
                    <input type="text" name="meal" id="meal" />
                </td>
            </tr>
            <tr>
                <th>
                    <label for="gain-kcal">kcal</label>
                </th>
                <td>
                    <input type="text" name="gain-kcal" id="gain-kcal" />
                </td>
            </tr>
            <tr>
                <th>
                    <label for="exercise">운동</label>
                </th>
                <td>
                    <input type="text" name="exercise" id="exercise" />
                </td>
            </tr>
            <tr>
                <th>
                    <label for="consume-kcal">운동-소모칼로리</label>
                </th>
                <td>
                    <input type="text" name="consume-kcal" id="consume-kcal" />
                </td>
            </tr>
            <tr>
                <th>
                    <label for="exercise-time">운동-시간</label>
                </th>
                <td>
                    <input type="text" name="exercise-time" id="exercise-time" />
                </td>
            </tr>
            <tr>
                <th>
                    <label for="eyebody-photo">눈 바디 사진</label>
                </th>
                <td>
                    <input type="file" name="eyebody-photo" id="eyebody-photo" />
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

<script>
    const contextPath = '${pageContext.request.contextPath}';
</script>


<script src="${pageContext.request.contextPath}/js/dailyrecode.js"></script>
</body>
</html>
