// **************************** Method 모음 ****************************
// AJAX 요청 function
function requestAjax(url, data){
	$.ajax({
		type: "POST",
		url: url,
		data: data,
		success: function(response){
			console.log(response.products, response.buttonCount);
			createList(response.products, response.buttonCount);
		},
		error : function(xhr, status, error) {
          // 요청이 실패했을 때 실행할 코드
          alert(error);
        }
	});
};

// response를 data로 받음, table과 버튼을 만드는 function
function createList(data, buttonCount){
	
	// 검색해온 데이터를 다른 function에서 사용하기 위해 전역변수의 배열변수로 복사
	dataReal = Array.from(data)	// Json을 Array로 변환
	
	let list = ""
	// 데이터 행 추가
	for(let i=0; i<data.length; i++){
		list += '<div class="card">' +
	            '<table style="width: 100%;">' +
	          	'<tr>' +
	 			'<td style="width: 12%;"><img src="../views/upload/menu/' + data[i].mnimg + '" class="card-img-top" alt="..." ></td>' +
	          	'<td style="width: 5%;">' + data[i].mncode + '</td>' +
	          	'<td style="width: 10%;">' + data[i].mnctg + '</td>' +
	          	'<td style="width: 15%;">' + data[i].mnname + '</td>' +
	          	'<td style="width: 15%;">' + data[i].mnengname + '</td> ' +
	          	'<td style="width: 30%;">' + data[i].mninfo + '</td>' +
	          	'<td style="width: 8%; text-align: right;">' + 
	          	data[i].mnprice.toLocaleString() + 
	          	"원" + '</td>' +
	            '<td style="width: 10%; text-align: center;"><a href="productdetail?mncode='
	             + data[i].mncode + '" class="btn btn-primary">수정</a></td>'+
	          	'</tr>' +
	            '</table>' +
	            '</div>'
	}
	
    // 버튼 HTML 생성
    for (let i = 0; i < buttonCount; i++) {
      list += '<button onclick = "buttonClick(' + (i+1) + ')">' + (i+1) + '</button>'; // 버튼 HTML 추가
    }
    
	$("#result").html(list);
}

// 엔터를 눌렀을 때 검색버튼이 클릭되게 하는 function
function enterInput() {
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
};
// **************************** Method 모음 End ****************************



// **************************** 기능 구현 ****************************



$(document).ready(function() {
	
	// 엔터를 눌렀을 때 검색버튼이 클릭
//	enterInput();
	
	// productList 첫 화면에서 Ajax 호출
	requestAjax(
		"productList",
		{"buttonNum" : 1,
		"search" : "",
		"selectSearch" : "mnname"
		}
	);
	
	// 검색에서 이름이나 코드를 선택해 검색
	$("#searchBtn").on("click",function() {
	    // combobox의 value와 text에 입력된 value를 가져옴
	    let selectSearch = $("#selectSearch").val();
	    let search = $("#search").val().trim();
    
	  // AJAX를 사용하여 서버에 값을 전달
	  requestAjax(
		  "productList",
		  {
			"buttonNum" : 1,
			"search" : search,
			"selectSearch" : selectSearch
		  }
	  );
   });
});

// 버튼을 클릭 했을 때 해당 페이지를 보여주는 function
function buttonClick(page){
	
	let selectSearch = $("#selectSearch").val();
	let search = $("#search").val().trim();
	
    requestAjax(
		"productList",
    	{"buttonNum" : page,
    	"search" : search,
		"selectSearch" : selectSearch}
    )
}
// **************************** End ****************************