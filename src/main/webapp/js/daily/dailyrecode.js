$(".exerciseautocomplete").autocomplete({
    //request: 사용자가 입력한 검색어, callback: 검색 결과를 처리하고 화면에 표시하는 함수
    source(request, callback) {
        console.log(request);
        console.log(callback); // 콜백함수

        $.ajax({
            url : `${contextPath}/text/exerciseSearch`,
            method : 'get',
            data : request,
            dataType : 'text',
            //response: ajax의 비동기 요청이 수행되고 success시 서버로 받은 응답받는 데이터
            success(response) {
                console.log(response);
                // 서버로 부터 응답받은 메세지가 있는 경우에만. 실행
                if(response) {
                    const temp = response.split("\r\n");
                    // temp에 저장된 요소 1개씩 순서대로 메소드를 실행
                    const exercises = temp.map((exercise) => {
                        const [id, name] = exercise.split(',');
                        return {
                            label : `${name}(${id})`,
                            value : name
                        };
                    });
                    console.log(exercises);
                    callback(exercises); // jqueryui#autocomplete에 전달. 화면자동으로 렌더.
                }
            },
            error(jqXHR, textStaus, errorThrown){
                console.log(jqXHR, textStaus, errorThrown);
            }
        });
    },
    // select: 이벤트 콜백 중 하나로, 이 콜백은 사용자가 자동완성 목록에서 항목을 선택했을 때 호출되는 함수
    // selected: 선택된 항목에 대한 정보를 담고 있는 객체
    select(e, selected) {
        console.log(e, selected);
        // const {item: {value}}는 구조 분해(Destructuring) 문법을 사용하여
        // selected객체의 item 속성에 해당하는 값(객체)을 추출하고,
        // 그 안에서 value 속성에 해당하는 값을 value 변수에 할당하는 것을 의미
        const {item : {value}} = selected;
    }
});

$(".mealautocomplete").autocomplete({
    //request: 사용자가 입력한 검색어, callback: 검색 결과를 처리하고 화면에 표시하는 함수
    source(request, callback) {
        console.log(request);
        console.log(callback); // 콜백함수

        $.ajax({
            url : `${contextPath}/text/foodSearch`,
            method : 'get',
            data : request,
            dataType : 'text',
            //response: ajax의 비동기 요청이 수행되고 success시 서버로 받은 응답받는 데이터
            success(response) {
                console.log(response);
                // 서버로 부터 응답받은 메세지가 있는 경우에만. 실행
                if(response) {
                    const temp = response.split("\r\n");
                    // temp에 저장된 요소 1개씩 순서대로 메소드를 실행
                    const meals = temp.map((meal) => {
                        const [id, name] = meal.split(',');
                        return {
                            label : `${name}(${id})`,
                            value : name
                        };
                    });
                    console.log(meals);
                    callback(meals); // jqueryui#autocomplete에 전달. 화면자동으로 렌더.
                }
            },
            error(jqXHR, textStaus, errorThrown){
                console.log(jqXHR, textStaus, errorThrown);
            }
        });
    },
    // select: 이벤트 콜백 중 하나로, 이 콜백은 사용자가 자동완성 목록에서 항목을 선택했을 때 호출되는 함수
    // selected: 선택된 항목에 대한 정보를 담고 있는 객체
    select(e, selected) {
        console.log(e, selected);
        // const {item: {value}}는 구조 분해(Destructuring) 문법을 사용하여
        // selected객체의 item 속성에 해당하는 값(객체)을 추출하고,
        // 그 안에서 value 속성에 해당하는 값을 value 변수에 할당하는 것을 의미
        const {item : {value}} = selected;
    }
});

document.dailyRecodeFrm.addEventListener("submit", (e) => {
    e.preventDefault(); // 동기적 제출방지

    const frm = e.target;
    const frmData = new FormData(frm); // input태그의 사용자입력값 모두 등록
    $.ajax({
        url : `${contextPath}/daily/dailyRecode`,
        method : "post",
        data : frmData,
        contentType : false, // 기본값 application/x-www-form-urlencoded 처리하지 않음.
        processData : false, // 직렬화처리(ex)a=b&c=d)하지 않고, multipart로 처리
        success(response) {
            console.log(response);
            const {msg} = response;
            // alert(msg);
        },
        complete() {
            frm.reset();
            location.href=`${contextPath}/member/memberMain`
        }
    })
});