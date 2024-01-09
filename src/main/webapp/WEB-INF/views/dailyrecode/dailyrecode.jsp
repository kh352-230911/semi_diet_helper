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
            <div>
                <label for="today-weight">오늘의 몸무게</label>
                <input type="text" name="today-weight" id="today-weight" />
            </div>
            <fieldset>
                <legend>음식</legend>
                <input id="countFoodSet" type="hidden" name="countFoodSet" value="1">
                <table>
                    <tbody>
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
                            <input type="text" name="meal" id="meal" class="mealautocomplete"/>
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
                        <td>
                            <button id="addMeal">음식 추가 버튼</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>운동</legend>
                <input id="countExerciseSet" type="hidden" name="countExerciseSet" value="1">
                    <table>
                        <tbody>
                        <tr>
                            <th>
                                <label for="exercise">운동</label>
                            </th>
                            <td>
                                <input type="text" name="exercise" id="exercise" class="exerciseautocomplete"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="exercise-time">운동 시간(단위: 10분)</label>
                            </th>
                            <td>
                                <input type="text" name="exercise-time" id="exercise-time" />
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
                            <td>
                                <button id="addExercise">운동 추가 버튼</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
            </fieldset>
            <fieldset>
                <legend>눈바디</legend>
                <table>
                    <tbody>
                    <tr>
                        <th>
                            <label for="eyebody-photo">눈 바디 사진 등록</label>
                        </th>
                        <td>
                            <input type="file" name="eyebody-photo" id="eyebody-photo" />
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
    </fieldset>
    <button>등록</button>
</form>

<script>
    const contextPath = '${pageContext.request.contextPath}';
</script>
<script>
    document.querySelector("#addMeal").addEventListener('click', (e) => {
        e.preventDefault()
        const value = e.target.innerHTML;
        const html = `
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
                            <input type="text" name="meal" id="meal" class="mealautocomplete" />
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="gain-kcal">kcal</label>
                        </th>
                        <td>
                            <input type="text" name="gain-kcal" id="gain-kcal" />
                        </td>
                    </tr>`;

        const hiddenCount = document.querySelector("#countFoodSet");
        let count = parseInt(hiddenCount.value, 10);
        count++;
        hiddenCount.value = count.toString();

        // 특정요소기준으로 새요소 추가
        // - beforebegin 시작태그앞. 이전 형제요소로 추가
        // - afterbegin 시작태그뒤. 첫 자식요소로 추가
        // - beforeend 종료태그앞. 마지막 자식요소로 추가
        // - afterend 종료태그뒤. 다음 형제요소로 추가
        // e.target.parentElement : label#hobby-etc를 감싼 div태그
        e.target.parentElement.parentElement.insertAdjacentHTML('beforebegin', html);
        // e.target.innerHTML = '직접입력';
    });
</script>

<script>
    document.querySelector("#addExercise").addEventListener('click', (e) => {
        e.preventDefault()
        const value = e.target.innerHTML;
        const html = `
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
                                <label for="exercise-time">운동 시간(단위: 10분)</label>
                            </th>
                            <td>
                                <input type="text" name="exercise-time" id="exercise-time" />
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="consume-kcal">운동-소모칼로리</label>
                            </th>
                            <td>
                                <input type="text" name="consume-kcal" id="consume-kcal" />
                            </td>
                        </tr>`;

        const hiddenCount = document.querySelector("#countExerciseSet");
        let count = parseInt(hiddenCount.value, 10);
        count++;
        hiddenCount.value = count.toString();

        // 특정요소기준으로 새요소 추가
        // - beforebegin 시작태그앞. 이전 형제요소로 추가
        // - afterbegin 시작태그뒤. 첫 자식요소로 추가
        // - beforeend 종료태그앞. 마지막 자식요소로 추가
        // - afterend 종료태그뒤. 다음 형제요소로 추가
        // e.target.parentElement : label#hobby-etc를 감싼 div태그
        e.target.parentElement.parentElement.insertAdjacentHTML('beforebegin', html);
        // e.target.innerHTML = '직접입력';
    });
</script>

<script src="${pageContext.request.contextPath}/js/daily/dailyrecode.js"></script>
</body>
</html>
