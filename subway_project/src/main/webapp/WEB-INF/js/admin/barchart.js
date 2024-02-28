$(document).ready(function() {
	
	// Field
	let previousOpriceArray = []; 
	let thisOpriceArray = []; 

// 초기 화면에 barChart를 생성
  $.ajax({
	    type: "POST",
	    url: "monthlyBarChart",
	    success: function(data) {
			console.log(data)
			for(j=1; j<=12; j++) {
				let sumprice = 0;
				for(i=0; i<data.pre.length; i++) {
					if(j == data.pre[i].omonth * 1)
					sumprice += data.pre[i].omonthsum * 1;
				};
				previousOpriceArray.push(sumprice)
			};
			for(j=1; j<=12; j++) {
				let sumprice = 0;
				for(i=0; i<data.this.length; i++) {
					if(j == data.this[i].omonth * 1)
					sumprice += data.this[i].omonthsum * 1;
				};
				thisOpriceArray.push(sumprice)
			};
			
			
		  const ctx = document.getElementById('myChart');
		  ctx.width = 1350;
		  ctx.height = 485;
		
		  new Chart(ctx, {
		    type: 'bar',
		    data: {
		      labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		      datasets: [
		    	{
			        label: '전년도',
			        data: previousOpriceArray,
			        backgroundColor: 'rgba(54, 162, 235, 0.7)',
			        borderColor: 'rgba(54, 162, 235, 1)',
			        borderWidth: 1
		    	},
		        {
			        label: '이번년도',  // 두 번째 데이터셋의 이름
					data: thisOpriceArray,  // 두 번째 데이터셋의 데이터
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