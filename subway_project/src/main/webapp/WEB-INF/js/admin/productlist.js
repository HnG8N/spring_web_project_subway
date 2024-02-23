window.onload = function(){
	// AJAX 요청
	$.ajax({
	type: "POST",
	url: "ProductList_Servlet", 	// class 명
	data: {mnname : ""},		// key와 value, 변수 이름(key)과 let name에 받아온 value값(value), dictionary라고 함
	success: function(response){
		// 서버에서 받은 응답 처리
		createList(response)
		}
	})

}

// response를 data로 받음
function createList(data){	
	
	// 검색해온 데이터를 다른 function에서 사용하기 위해 전역변수의 배열변수로 복사
	dataReal = Array.from(data)	// Json을 Array로 변환
	
	let list = ""
	// 데이터 행 추가
	for(let i=0; i<data.length; i++){
		list += '<div class="card">' +
	            '<table style="width: 100%;">' +
	          	'<tr>' +
	 			'<td style="width: 12%;"><img src="img/' + data[i].mnimg + '" class="card-img-top" alt="..." ></td>' +
	          	'<td style="width: 5%;">' + data[i].mncode + '</td>' +
	          	'<td style="width: 10%;">' + data[i].mnctg + '</td>' +
	          	'<td style="width: 15%;">' + data[i].mnname + '</td>' +
	          	'<td style="width: 15%;">' + data[i].mnengname + '</td> ' +
	          	'<td style="width: 30%;">' + data[i].mninfo + '</td>' +
	          	'<td style="width: 8%; text-align: right;">' + 
	          	data[i].mnprice.toLocaleString() + 
	          	"원" + '</td>' +
	            '<td style="width: 10%; text-align: center;"><a href="productdetail.do?mncode='
	             + data[i].mncode + '" class="btn btn-primary">수정</a></td>'+
	          	'</tr>' +
	            '</table>' +
	            '</div>'
	}
	
	$("#result").html(list);
}

// 엔터를 눌렀을 때 검색버튼이 클릭되게 하는 function
$(document).ready(function() {
  // 검색 input 엘리먼트를 찾습니다.
  let input = $("#search");
  
  // input 엘리먼트에 대해 keypress 이벤트를 추가합니다.
  input.on("keypress", function(event) {
    // Enter 키의 keyCode는 13입니다.
    if (event.keyCode === 13) {
      // Enter 키가 눌렸을 때 검색 버튼을 클릭합니다.
      $("#searchBtn").click();
    }
  });
});

// 검색에서 이름이나 코드를 선택해 검색
$(document).ready(function() {
  $("#searchBtn").click(function() {
    // 선택한 옵션의 값을 가져옴
    let selectSearch = $("#selectSearch").val();
    let mnname = $("#search").val().trim();
    let mnengname = $("#search").val().trim();
    let mncode = $("#search").val().trim();
    
    if(selectSearch==="nameSearch"){    // AJAX를 사용하여 서버에 값을 전달
      $.ajax({
        type: "POST",
        url: "PLSearchName_Servlet",
        data: {
			mnname : mnname,
			mnengname : mnengname
		}, // 전달할 데이터
        success: function(response) {
          // 성공적으로 서버로부터 응답을 받았을 때 실행할 코드
          console.log(response);
          createList(response)
        },
        error: function(xhr, status, error) {
          // 요청이 실패했을 때 실행할 코드
          alert(error);
        }
      });
    }
    if(selectSearch==="codeSearch"){    // AJAX를 사용하여 서버에 값을 전달
      $.ajax({
        type: "POST",
        url: "PLSearchName_Servlet",
        data: {
			mncode : mncode,
		}, // 전달할 데이터
        success: function(response) {
          // 성공적으로 서버로부터 응답을 받았을 때 실행할 코드
          console.log(response);
          createList(response)
        },
        error: function(xhr, status, error) {
          // 요청이 실패했을 때 실행할 코드
          alert(error);
        }
      });
    }
  });
});
