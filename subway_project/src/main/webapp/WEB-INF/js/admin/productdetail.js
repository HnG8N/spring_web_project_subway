 $(document).ready(function() {
	 
	 // textfield에 입력된 값
	 let mnctgtxt = $("#mnctgtext").val();
	 
	 // textfiled에 입력된 값이 있을 경우 combobox를 그 밸류 값으로 selected
	 if(mnctgtxt != null) {
		 $("#mnctg").val(mnctgtxt).attr("selected","selected");
	 }
	 
    $("#mnname").keyup(function() {
        var replace_text = $(this).val().replace(/[^ㄱ-ㅎㅏ-ㅣ가-힣&\s]/g, '');
        $(this).val(replace_text);
    });
    $("#mnengname").keyup(function() {
        var replace_text = $(this).val().replace(/[^a-zA-Z& .™]/g, '');
        $(this).val(replace_text);
    });
    $("#mnprice").keyup(function() {
        var replace_text = $(this).val().replace(/[^-0-9]/g, '');
        $(this).val(replace_text);
    });
    $("#mngram, #mnkcal, #mnprotein, #mnfat, #mnsugar, #mnnatrum").keyup(function() {
	var replace_text = $(this).val().replace(/[^\d.]/g, '').replace(/^(\d{0,3}(?:\.\d{0,2})?).*/, '$1');
        $(this).val(replace_text);
    });
    $('#product').validate({
        rules: {
            mnctg: {
                required: true,
                maxlength: 10
            },
            mnname: {
                required: true,
                maxlength: 30
            },
            mnengname: {
                required: true,
                maxlength: 50
            },
            mninfo: {
                required: true
            },
            mnprice: {
                required: true,
                maxlength: 5
            },
            mngram: {
                required: true,
                maxlength: 5
            },
            mnkcal: {
                required: true,
                maxlength: 5
            },
            mnprotein: {
                required: true,
                maxlength: 5
            },
            mnfat: {
                required: true,
                maxlength: 5
            },
            mnsugar: {
                required: true,
                maxlength: 5
            },
            mnnatrum: {
                required: true,
                maxlength: 5
            },
        },
        messages: {
            mnctg: {
                required: "카테고리를 입력하세요.",
                maxlength: "10자 이하로 입력해주세요."
            },
            mnname: {
                required: "이름을 입력하세요.",
                maxlength: "30자 이하로 입력해주세요."
            },
            mnengname: {
                required: "영문명을 입력하세요.",
                maxlength: "50자 이하로 입력해주세요."
            },
            mninfo: {
                required: "상세 정보를 입력하세요."
            },
            mnprice: {
                required: "가격을 입력하세요.",
                maxlength: "10만원 미만으로 입력해주세요."
            },
            mngram: {
                required: "중량(g)을 입력하세요.",
                maxlength: "5글자 이하로 입력해주세요."
            },
            mnkcal: {
                required: "열량(kcal)을 입력하세요.",
                maxlength: "5글자 이하로 입력해주세요."
            },
            mnprotein: {
                required: "단백질(g)을 입력하세요.",
                maxlength: "5글자 이하로 입력해주세요."
            },
            mnfat: {
                required: "포화지방(g) 입력하세요.",
                maxlength: "5글자 이하로 입력해주세요."
            },
            mnsugar: {
                required: "당류(g)를 입력하세요.",
                maxlength: "5글자 이하로 입력해주세요."
            },
            mnnatrum: {
                required: "나트륨(mg)을 입력하세요.",
                maxlength: "5글자 이하로 입력해주세요."
            },
        }
    });
    
    $('#product').submit(function(event) {
    // 이미지 파일이 선택되었는지 확인
    
	    let mnimg = $('#mnimg').val();
	    alert(image)
	    alert(mnimg)
	    
	    if (!img && !mnimg) {	// 이미지가 선택되지 않았고 이미지가 출력되지 않았을 경우 제출 막고 메시지 출력
	        event.preventDefault(); // 폼 제출 방지
	        alert('이미지를 등록해주세요.');
	    }
	});
});
// 이미지를 미리보기하는 함수
function previewImage(event) {
    // HTML에서 이미지를 표시할 img 요소를 가져옵니다.
    let imgPreview = $('#imgPreview');

    // 파일 입력 필드에서 선택한 파일을 가져옵니다.
    let file = event.target.files[0];

    // 파일이 선택된 경우
    if (file) {
        // 선택한 파일의 URL을 생성하여 이미지를 표시합니다.
        imgPreview.attr('src', URL.createObjectURL(file));
    } else {
        // 파일 선택이 취소되었을 때, 기본 이미지를 표시합니다.
        imgPreview.attr('src', 'img/cat1.png');
    }
}



// 이미지가 존재하는지 확인하는 함수를 정의합니다.
function checkImageExists(url, callback) {
    // 새로운 이미지 객체를 생성합니다.
    var img = new Image();
    
    // 이미지 로드가 성공했을 때 실행할 콜백 함수를 정의합니다.
    $(img).on('load', function() {
        // 콜백 함수를 호출하고 이미지가 존재함을 전달합니다.
        callback(true);
    });
    
    // 이미지 로드가 실패했을 때 실행할 콜백 함수를 정의합니다.
    $(img).on('error', function() {
        // 콜백 함수를 호출하고 이미지가 존재하지 않음을 전달합니다.
        callback(false);
    });
    
    // 이미지 객체의 src 속성을 설정하여 이미지를 로드합니다.
    img.src = url;
}

// 이미지 요소의 src 속성을 가져옵니다.
var imageUrl = $('#img').attr('src');

// checkImageExists 함수를 호출하여 이미지가 존재하는지 확인합니다.
checkImageExists(imageUrl, function(exists) {
    // 이미지가 존재하는 경우에 대한 조건문입니다.
    if (exists) {
        // 이미지가 존재함을 콘솔에 출력합니다.
        console.log("이미지가 존재합니다.");
    } 
    // 이미지가 존재하지 않는 경우에 대한 조건문입니다.
    else {
        // 이미지가 존재하지 않음을 콘솔에 출력합니다.
        console.log("이미지가 존재하지 않습니다.");
    }
});
