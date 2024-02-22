$(document).ready(function() {
	
	// welcome값이 빈칸이 아니라면 logoutForm을 생성
	if($("#welcome").val() !== "") {
	  // logoutForm 생성
	  let logoutForm = 	'<form action="logout" method="post">' +
			'<span class="welcome_logout">' +
		   	'<input class="welcome" id="welcome" type="text" value="' + 
		   	$("#welcome").val() + '" readonly="readonly">' +
		   	'&nbsp;&nbsp;&nbsp;' + 
		   	'<input type="submit" id="logout" class="img-button" value="logout">' + 
	 		'</span>' +
	 		'</form>'
	
	  // 생성한 logoutForm을 #logoutForm div에 삽입
	  $("#logoutForm").html(logoutForm);
	}

	// logout 버튼을 클릭 했을 때
	$("#logout").on("click",function(event) {
		let confirmLogout = confirm("로그아웃 하시겠습니까?")
		    if (!confirmLogout) {
			// "Yes"를 선택한 경우에만 이벤트 진행
			event.preventDefault(); // "No"일 경우 form submit 중지
	    }
	});
}); 