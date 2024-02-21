$(document).ready(function() {
	$("#logout").on("click",function(event) {
		let confirmLogout = confirm("로그아웃 하시겠습니까?")
		    if (!confirmLogout) {
			// "Yes"를 선택한 경우에만 이벤트 진행
			event.preventDefault(); // "No"일 경우 form submit 중지
        }
	});
}); 