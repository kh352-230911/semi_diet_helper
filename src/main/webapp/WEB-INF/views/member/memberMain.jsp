<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <style>
        .calendarContentButton{
            width: 100px;
            height: 100px;
        }
        th{
            font-size: 100px;
        }
    </style>
</head>
<body>
    <div>
        <button type="button" id="pre_month" onclick="document.preMonthFrm.submit()">이전 달</button>
            ${handMadeCalendarList[20].calc_year}년도 ${handMadeCalendarList[20].calc_month}월
        <button type="button" id="pre_month" onclick="document.nextMonthFrm.submit()">다음 달</button>
    </div>
    <form name="preMonthFrm" method="post">
<%--        <input id="preMonth" value="${handMadeCalendarList[20].calc_month-1}" name="preMonth" type="hidden">--%>
        <input value="pre" name="pre" type="hidden">
        <input value="${handMadeCalendarList[20].calc_month}" name="prepageMonth" type="hidden">
        <input value="${handMadeCalendarList[20].calc_year}" name="prepageYear" type="hidden">
    </form>
    <form name="nextMonthFrm" method="post">
<%--        <input id="currentViewMonth" value="${handMadeCalendarList[20].calc_month+1}" name="preMonth" type="hidden">--%>
        <input value="next" name="next" type="hidden">
        <input value="${handMadeCalendarList[20].calc_month}" name="prepageMonth" type="hidden">
        <input value="${handMadeCalendarList[20].calc_year}" name="prepageYear" type="hidden">

    </form>
    <table>
        <thead>
            <tr>
                <th>일</th>
                <th>월</th>
                <th>화</th>
                <th>수</th>
                <th>목</th>
                <th>금</th>
                <th>토</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <c:forEach items="${handMadeCalendarList}" var="handMadeCalendar" varStatus="vs">
                    <c:if test="${vs.count lt currentDayOfMonthInJspTitle}">
                        <td>
                        </td>
                    </c:if>
                    <c:if test="${vs.count ge currentDayOfMonthInJspTitle}">
                        <td>
                                <button class="calendarContentButton">
                                        ${vs.count - (currentDayOfMonthInJspTitle - 1)}
                                        <br>
                                        ${handMadeCalendar.dailyRecode.dailyWeight}kg
                                        <br>
                                        달성 여부: ${handMadeCalendar.dailyRecode.pointCheck}

                                </button>
                        </td>
                        <c:if test="${(vs.count % 7) eq 0}">
                            <tr></tr>
                        </c:if>
                    </c:if>
                </c:forEach>
            </tr>
        </tbody>
    </table>

<%--    <script>--%>
<%--        let currentMonth = ${handMadeCalendarList[20].calc_month};--%>
<%--    </script>--%>

    <script>
        const contextPath = '${pageContext.request.contextPath}';
    </script>

<%--    <script>--%>
<%--        document.querySelector("#pre_month").addEventListener("click", (e) => {--%>
<%--            e.preventDefault(); // 동기적 제출방지--%>

<%--            $.ajax({--%>
<%--                // url--%>
<%--                url : `${pageContext.request.contextPath}/member/memberMain`,--%>
<%--                // 서버 요청 방식(get/post/put - default:get)--%>
<%--                method : "get",--%>
<%--                // 보내는 객체, javascript객체로 전달하면 자동으로 직렬화 수행.--%>
<%--                // 요청 parameter 설정--%>
<%--                data : {--%>
<%--                    changeMonth : ${handMadeCalendarList[20].calc_month} - 1--%>
<%--                },--%>
<%--                // 서버에서 response 오는 데이터의 데이터 형 설정(xml, json, script, html, text)--%>
<%--                // 값이 없다면 스마트하게 판단(응답헤더의 content-type을 보고 판단)--%>
<%--                // 응답 데이터의 content-type을 override함 응답에는 content-type이 html로 돼있어도 text로 적는다면, text형식으로 보내짐--%>
<%--                dataType : "text",--%>
<%--                // ajax 요청을 하기 전 실행 되는 이벤트 callback 함수--%>
<%--                // 전송하기 전 호출--%>
<%--                beforeSend() {--%>
<%--                    console.log('beforeSend');--%>
<%--                    console.log(${handMadeCalendarList[20].calc_month}, ": currentMonth입니다.");--%>
<%--                },--%>
<%--                // 객체안에 메소드를 작성하는 문법--%>
<%--                // 전송이 성공할 경우 처리할 핸들러--%>
<%--                success(response){--%>
<%--                    console.log('success');--%>
<%--                },--%>
<%--                // 전송이 실패할 경우 처리할 핸들러--%>
<%--                // error에는 jqXHR, textStatus, errorThrown의 인자가 넘어옴--%>
<%--                error(jqXHR, textStatus, errorThrown) {--%>
<%--                    console.log('error');--%>
<%--                    console.log(jqXHR, textStatus, errorThrown);--%>
<%--                },--%>
<%--                // 전송의 실패 유무와 상관없이 무조건 실행--%>
<%--                complete() {--%>

<%--                }--%>

<%--            });--%>
<%--        });--%>




<%--        document.querySelector("#next_month").addEventListener("click", (e) => {--%>
<%--            e.preventDefault(); // 동기적 제출방지--%>

<%--            $.ajax({--%>
<%--                // url--%>
<%--                url : `${pageContext.request.contextPath}/member/memberMain`,--%>
<%--                // 서버 요청 방식(get/post/put - default:get)--%>
<%--                method : "get",--%>
<%--                // 보내는 객체, javascript객체로 전달하면 자동으로 직렬화 수행.--%>
<%--                // 요청 parameter 설정--%>
<%--                data : {--%>
<%--                    changeMonth : ${handMadeCalendarList[20].calc_month} + 1--%>
<%--                },--%>
<%--                // 서버에서 response 오는 데이터의 데이터 형 설정(xml, json, script, html, text)--%>
<%--                // 값이 없다면 스마트하게 판단(응답헤더의 content-type을 보고 판단)--%>
<%--                // 응답 데이터의 content-type을 override함 응답에는 content-type이 html로 돼있어도 text로 적는다면, text형식으로 보내짐--%>
<%--                dataType : "text",--%>
<%--                // ajax 요청을 하기 전 실행 되는 이벤트 callback 함수--%>
<%--                // 전송하기 전 호출--%>
<%--                beforeSend() {--%>
<%--                    console.log('beforeSend');--%>
<%--                    console.log(${handMadeCalendarList[20].calc_month}, ": currentMonth입니다.");--%>
<%--                },--%>
<%--                // 객체안에 메소드를 작성하는 문법--%>
<%--                // 전송이 성공할 경우 처리할 핸들러--%>
<%--                success(response){--%>
<%--                    console.log('success');--%>
<%--                },--%>
<%--                // 전송이 실패할 경우 처리할 핸들러--%>
<%--                // error에는 jqXHR, textStatus, errorThrown의 인자가 넘어옴--%>
<%--                error(jqXHR, textStatus, errorThrown) {--%>
<%--                    console.log('error');--%>
<%--                    console.log(jqXHR, textStatus, errorThrown);--%>
<%--                },--%>
<%--                // 전송의 실패 유무와 상관없이 무조건 실행--%>
<%--                complete() {--%>
<%--                    console.log('complete');--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>

    <script src="${pageContext.request.contextPath}/js/daily/memberMain.js"></script>
</body>
</html>