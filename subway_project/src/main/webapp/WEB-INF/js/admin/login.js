$(document).ready(function() {
	$("#loginBtn").on("click",function(event) {
		event.preventDefault(); // form submit 중지
		
		let loginID = $("#loginID").val(); // loginID textField의 값을 가져옴
		let loginPW = $("#loginPW").val(); // loginPW textField의 값을 가져옴
        let regex = /^admin\d{4}$/; // loginID의 정규식 패턴
        let mpw = "";
        
        // 아이디 확인을 먼저 함
        if (!regex.test(loginID)) { // 정규식 패턴과 일치하지 않으면
            alert("ID나 PW가 올바르지 않습니다.");
        }else{
	        // 비밀번호 확인을 위한 AJAX 요청
			$.ajax({
				type: "POST",
				url: "loginverification", 	// class 명
				data: {
					"mid" : loginID,
					"mpw" : loginPW
				},		// key와 value, 변수 이름(key)과 let name에 받아온 value값(value), dictionary라고 함
				success: function(data){
					alert(data);
					// 서버에서 받은 응답 처리
					dataReal = Array.from(data); // Json을 Array로 변환
					mpw = data.mpw
					//console.log(mpw)
					//console.log(loginPW)
					if(mpw === loginPW) {
						$("#loginForm").submit(); // textField의 값과 DB에서 불러온 값이 같으면 form submit
					}else{
						alert("ID나 PW가 올바르지 않습니다.");
					}
				}, // success End
				error: function(xhr, status, error) {
		          // 요청이 실패했을 때 실행할 코드
		          	alert("응답에 실패했습니다 :" + error);
		        } // error End
			}) // ajax End
		}
	}); // #loginBtn.on End
}); // document.ready() End
