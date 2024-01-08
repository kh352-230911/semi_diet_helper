// document.querySelector("#pre_month").addEventListener('submit', (e) => e.preventDefault());
//
// document.querySelector("#pre_month").addEventListener('click', () => {
//     const currentViewMonthValue = document.querySelector("#currentViewMonth").value;
//     console.log(currentViewMonthValue);
//
//     $.ajax({
//         url : `${contextPath}/member/memberMain`,
//         method : "post",
//         data : {
//             currentViewMonthValue : currentViewMonthValue,
//             handMadeCalendarList : handMadeCalendarList
//         },
//         success(handMadeCalendarList) {
//             console.log(handMadeCalendarList);
//             const tbody = document.querySelector("tbody");
//             tbody.innerHTML = '';
//             tbody.innerHTML +=`
//                             <tr>
//                 <c:forEach items="${handMadeCalendarList}" var="handMadeCalendar" varStatus="vs">
//                     <c:if test="${vs.count < currentDayOfMonthInJspTitle}">
//                         <td>
//                         </td>
//                     </c:if>
//                     <c:if test="${vs.count >= currentDayOfMonthInJspTitle}">
//                         <td>
//                                 <button class="calendarContentButton">${vs.count - (currentDayOfMonthInJspTitle - 1)}</button>
//                         </td>
//                         <c:if test="${(vs.count % 7) == 0}">
//                             <tr></tr>
//                         </c:if>
//                     </c:if>
//                 </c:forEach>
//             </tr>`;
//         },
//         complete() {
//
//         }
//     })
// });
//
// document.querySelector("#next_month").addEventListener('click', () => {
//     const currentViewMonthValue = document.querySelector("#currentViewMonth").value;
//     console.log(currentViewMonthValue);
//
//     $.ajax({
//         url : `${contextPath}/member/memberMain`,
//         method : "post",
//         data : {
//             currentViewMonthValue : currentViewMonthValue,
//             handMadeCalendarList : handMadeCalendarList
//         },
//         success(handMadeCalendarList) {
//             console.log(handMadeCalendarList);
//             const tbody = document.querySelector("tbody");
//             tbody.innerHTML = '';
//             tbody.innerHTML =`
//                             <tr>
//                 <c:forEach items="${handMadeCalendarList}" var="handMadeCalendar" varStatus="vs">
//                     <c:if test="${vs.count < currentDayOfMonthInJspTitle}">
//                         <td>
//                         </td>
//                     </c:if>
//                     <c:if test="${vs.count >= currentDayOfMonthInJspTitle}">
//                         <td>
//                                 <button class="calendarContentButton">${vs.count - (currentDayOfMonthInJspTitle - 1)}</button>
//                         </td>
//                         <c:if test="${(vs.count % 7) == 0}">
//                             <tr></tr>
//                         </c:if>
//                     </c:if>
//                 </c:forEach>
//             </tr>`;
//         },
//         complete() {
//
//         }
//     })
// });

document.querySelector("#pre_month").addEventListener("click", (e) => {
    e.preventDefault(); // 동기적 제출방지

    let currentViewMonth = document.querySelector("#currentViewMonth").value;
    let handMadeCalendarList = document.querySelector("#handMadeCalendarList").value;

    $.ajax({
        // url
        url : `${contextPath}/member/memberMain`,
        // 서버 요청 방식(get/post/put - default:get)
        method : "get",
        // 보내는 객체, javascript객체로 전달하면 자동으로 직렬화 수행.
        // 요청 parameter 설정
        data : {
            currentViewMonth : currentViewMonth - 1
        },
        // 서버에서 response 오는 데이터의 데이터 형 설정(xml, json, script, html, text)
        // 값이 없다면 스마트하게 판단(응답헤더의 content-type을 보고 판단)
        // 응답 데이터의 content-type을 override함 응답에는 content-type이 html로 돼있어도 text로 적는다면, text형식으로 보내짐
        dataType : "text",
        // ajax 요청을 하기 전 실행 되는 이벤트 callback 함수
        // 전송하기 전 호출
        beforeSend() {
            console.log('beforeSend');
        },
        // 객체안에 메소드를 작성하는 문법
        // 전송이 성공할 경우 처리할 핸들러
        success(response){
            console.log('success');
            console.log(response);
            location.href = `${contextPath}/member/memberMain?currentViewMonth=${currentViewMonth - 1}`;
        },
        // 전송이 실패할 경우 처리할 핸들러
        // error에는 jqXHR, textStatus, errorThrown의 인자가 넘어옴
        error(jqXHR, textStatus, errorThrown) {
            console.log('error');
            console.log(jqXHR, textStatus, errorThrown);
        },
        // 전송의 실패 유무와 상관없이 무조건 실행
        complete() {
            console.log('complete');
        }

    });
});

document.querySelector("#next_month").addEventListener("click", (e) => {
    e.preventDefault(); // 동기적 제출방지

    let currentViewMonth = document.querySelector("#currentViewMonth").value;
    let handMadeCalendarList = document.querySelector("#handMadeCalendarList").value;

    $.ajax({
        // url
        url : `${contextPath}/member/memberMain`,
        // 서버 요청 방식(get/post/put - default:get)
        method : "get",
        // 보내는 객체, javascript객체로 전달하면 자동으로 직렬화 수행.
        // 요청 parameter 설정
        data : {
            currentViewMonth : currentViewMonth + 1
        },
        // 서버에서 response 오는 데이터의 데이터 형 설정(xml, json, script, html, text)
        // 값이 없다면 스마트하게 판단(응답헤더의 content-type을 보고 판단)
        // 응답 데이터의 content-type을 override함 응답에는 content-type이 html로 돼있어도 text로 적는다면, text형식으로 보내짐
        dataType : "text",
        // ajax 요청을 하기 전 실행 되는 이벤트 callback 함수
        // 전송하기 전 호출
        beforeSend() {
            console.log('beforeSend');
        },
        // 객체안에 메소드를 작성하는 문법
        // 전송이 성공할 경우 처리할 핸들러
        success(response){
            console.log('success');
            console.log(response);
            location.href = `${contextPath}/member/memberMain?currentViewMonth=${currentViewMonth+1}`;
        },
        // 전송이 실패할 경우 처리할 핸들러
        // error에는 jqXHR, textStatus, errorThrown의 인자가 넘어옴
        error(jqXHR, textStatus, errorThrown) {
            console.log('error');
            console.log(jqXHR, textStatus, errorThrown);
        },
        // 전송의 실패 유무와 상관없이 무조건 실행
        complete() {
            console.log('complete');
        }

    });
});
//
//
//
//
// document.querySelector("#next_month").addEventListener("click", (e) => {
//     e.preventDefault(); // 동기적 제출방지
//
//     $.ajax({
//         // url
//         url : `${contextPath}/member/memberMain`,
//         // 서버 요청 방식(get/post/put - default:get)
//         method : "get",
//         // 보내는 객체, javascript객체로 전달하면 자동으로 직렬화 수행.
//         // 요청 parameter 설정
//         data : {
//             changeMonth : currentMonth + 1
//         },
//         // 서버에서 response 오는 데이터의 데이터 형 설정(xml, json, script, html, text)
//         // 값이 없다면 스마트하게 판단(응답헤더의 content-type을 보고 판단)
//         // 응답 데이터의 content-type을 override함 응답에는 content-type이 html로 돼있어도 text로 적는다면, text형식으로 보내짐
//         dataType : "text",
//         // ajax 요청을 하기 전 실행 되는 이벤트 callback 함수
//         // 전송하기 전 호출
//         beforeSend() {
//             console.log('beforeSend');
//             console.log(currentMonth, ": currentMonth입니다.")
//         },
//         // 객체안에 메소드를 작성하는 문법
//         // 전송이 성공할 경우 처리할 핸들러
//         success(response){
//             console.log('success');
//             console.log(response);
//         },
//         // 전송이 실패할 경우 처리할 핸들러
//         // error에는 jqXHR, textStatus, errorThrown의 인자가 넘어옴
//         error(jqXHR, textStatus, errorThrown) {
//             console.log('error');
//             console.log(jqXHR, textStatus, errorThrown);
//         },
//         // 전송의 실패 유무와 상관없이 무조건 실행
//         complete() {
//             console.log('complete');
//         }
//
//     });
// });