$(document).ready(function() {
	
	// Field
	let odateArray = [];
	let opriceArray = [];  

// 초기 화면에 barChart를 생성
  $.ajax({
	    type: "POST",
	    url: "Salesstatus_Servlet",
	    success: function(data) {
			for(i=0; i<data.length; i++){
				odateArray.push(data[i].omonth + "월");
			};
			for(i=0; i<data.length; i++){
				opriceArray.push(data[i].omonthsum * 1);
			};
			console.log(odateArray);
			console.log(opriceArray);
			
		  const ctx = document.getElementById('myChart');
		  ctx.width = 1350;
		  ctx.height = 485;
		
		  new Chart(ctx, {
		    type: 'bar',
		    data: {
		      labels: odateArray,
		      datasets: [
		    	{
			        label: '전년도',
			        data: opriceArray,
			        backgroundColor: 'rgba(54, 162, 235, 0.7)',
			        borderColor: 'rgba(54, 162, 235, 1)',
			        borderWidth: 1
		    	},
		        {
			        label: '이번년도',  // 두 번째 데이터셋의 이름
					data: opriceArray,  // 두 번째 데이터셋의 데이터
					backgroundColor: 'rgba(153, 255, 153, 0.7)',  // 두 번째 데이터셋의 배경색
					borderColor: 'rgba(153, 255, 153, 1)',  // 두 번째 데이터셋의 테두리 색
					borderWidth: 1
		        }
		      ]
		    },
		    options: {
			  responsive: false,
		      scales: {
		        y: {
		          beginAtZero: true
		        }
		      }
		    }
		  });
	    }
	});
	

}); // document End