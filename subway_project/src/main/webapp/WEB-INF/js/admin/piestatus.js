$(document).ready(function() {
    
    // Field
	let startDay = '23-01-01'; // 달력에서 시작 날짜
	let endDay = '24-12-31'; // 달력에서 마지막 날짜
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
            url: "SalesStatusServlet",
            data: {
				chart: "menuPieChart",
                startDay: startDay,
                endDay: endDay
            },
            success: function(data) {
				console.log(data)
                let omenuArray = [];
                let ocountmncodeArray = [];
                for (let i = 0; i < data.length; i++) {
                    omenuArray.push(data[i].mnname);
                    ocountmncodeArray.push(data[i].countmncode * 1);
                }
                // 기존 차트가 존재한다면 제거
                if (myChart !== null) {
                    myChart.destroy();
                }
                console.log(omenuArray);
                console.log(ocountmncodeArray);
                pieChart(omenuArray, ocountmncodeArray);
            }
        });
    });

    // 검색하면 pieChart를 생성
    function pieChart(omenuArray, ocountmncodeArray){
        const ctx = document.getElementById('myChart');
        const config = {
            type: 'pie',
            data: {
                labels: omenuArray,
                datasets:[{
                    label: "Menu",
                    data: ocountmncodeArray,
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
