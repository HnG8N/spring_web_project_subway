$(document).ready(function() {
    
    // Field
    let startDay = ''; // 달력에서 시작 날짜
    let endDay = ''; // 달력에서 마지막 날짜
    let myChart = null; // 차트 객체를 저장할 변수

    // 텍스트필드를 클릭해 시작 날짜를 선택하는 function
    $('input[name="startCalendar"]').daterangepicker({
        singleDatePicker: true,
        "locale": {
            "format": 'YYYY-MM-DD', 
            "separator": " ~ ", 
            "applyLabel": "확인", 
            "cancelLabel": "취소", 
            "fromLabel": "From", 
            "toLabel": "To", 
            "customRangeLabel": "Custom", 
            "weekLabel": "주", 
            "daysOfWeek": ["토", "일", "월", "화", "수", "목", "금"],
            "monthNames": ["01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"],
            "firstDay": 1 
        },
    }, function(start) {
        startDay = start.format('YYYY-MM-DD')
    });

    // 텍스트필드를 클릭해 마지막 날짜를 선택하는 function
    $('input[name="endCalendar"]').daterangepicker({
        singleDatePicker: true,
        "locale": {
            "format": 'YYYY-MM-DD', 
            "separator": " ~ ", 
            "applyLabel": "확인", 
            "cancelLabel": "취소", 
            "fromLabel": "From", 
            "toLabel": "To", 
            "customRangeLabel": "Custom", 
            "weekLabel": "주", 
            "daysOfWeek": ["토", "일", "월", "화", "수", "목", "금"],
            "monthNames": ["01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월"],
            "firstDay": 1 
        },
    }, function(end) {
        endDay = end.format('YYYY-MM-DD')
        console.log(startDay + endDay)
    });
    
    // 검색 버튼을 누르면 시작 날짜와 마지막 날짜가 ajax로 전송되고 차트가 보이게 하는 function
    $("#calendar").on("click", function() {
        $.ajax({
            type: "POST",
            url: "MenuStatus_Servlet",
            data: {
                startDay: startDay,
                endDay: endDay
            },
            success: function(data) {
                let odayArray = [];
                let omenuArray = [];
                for (let i = 0; i < data.length; i++) {
                    odayArray.push(data[i].mnname);
                    omenuArray.push(data[i].countMncode * 1);
                }
                // 기존 차트가 존재한다면 제거
                if (myChart !== null) {
                    myChart.destroy();
                }
                console.log(odayArray);
                console.log(omenuArray);
                pieChart(odayArray, omenuArray);
            }
        });
    });

    // 검색하면 pieChart를 생성
    function pieChart(odayArray, omenuArray){
        const ctx = document.getElementById('myChart');
        const config = {
            type: 'pie',
            data: {
                labels: odayArray,
                datasets:[{
                    label: "Menu",
                    data: omenuArray,
                    borderWidth: 1
                }]
            },
            options: {
                responsive: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        };
        ctx.width = 485;
        ctx.height = 485;

        // 새로운 차트 객체 생성 및 저장
        myChart = new Chart(ctx, config);
    }
});
