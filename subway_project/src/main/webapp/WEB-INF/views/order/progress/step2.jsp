<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fast-Sub Step2</title>
	<link href="http://subway.co.kr/" rel="canonical" /><!-- 20180221 -->
	<meta content="신선하고 건강한 글로벌 NO.1 샌드위치 브랜드, 써브웨이" name="description" /><!-- 20181212 -->
	<link rel="shortcut icon" type="image/x-icon" href="/images/common/subway_favicon.ico?v=2023051202" />
	    <!-- 20180131 -->
	<link rel="stylesheet" type="text/css" href="/css/ui.common.css?v=2023051202" />
	<link rel="stylesheet" type="text/css" href="/css/jquery.mCustomScrollbar.min.css?v=2023051202" />
	
	
	
	<script type="text/javascript" src="/js/jquery/jquery-1.12.4.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/jquery/jquery-ui-1.12.0.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/jquery/jquery.easing.1.3.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/jquery/jquery.bxslider.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/jquery/jquery.mCustomScrollbar.concat.min.js?v=2023051202"></script>
	<!-- block ui -->
	<script type="text/javascript" src="/js/jquery/jquery.blockUI.min.js?v=2023051202"></script>
	
	<script type="text/javascript" src="/js/jquery/TweenMax.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/jquery/jquery.cookie.js?v=2023051202"></script>
	<!--<script type="text/javascript" th:src="'/js/lottie.js?v=' + ${cacheParam}"></script>-->
	<script type="text/javascript" src="/js/ui.common.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/subway.common.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/util/jsrender.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/jquery/jquery.tmpl.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/waffle/waffle.utils.js?v=2023051202"></script>
	
	<link rel="stylesheet" type="text/css" href="/css/ui.order.css?v=2023051202" />
	<script>
		var imagePath = null
	</script>
	
</head>
<body>
<%@ include file="../../include/header.jsp" %>
	<!-- container s -->
	<div id="container">
		<input id="menuType" name="menuType" type="hidden" value="" /> 
		<input id="itemIdx" name="itemIdx" type="hidden" value="" /> 
		<input id="groupCd" name="groupCd" type="hidden" value="" /> 
		<input id="storCd" name="storCd" type="hidden" value="64444" /> 
		<input id="ordType" name="ordType" type="hidden" value="ORD_TYPE.FAST_SUB" />
		<input id="paveFg" name="paveFg" type="hidden" value="Y" />
		<!-- sub content s -->
		<div id="content" class="order  fast_sub">
			<!-- fast_sub / home_sub -->
			<!-- index -->
			<div class="menu_list">
				<div class="order_title">
					<h3>Fast-Sub</h3>
					<p>
						<th:object>온라인 주문 후 매장에서 픽업/시식하는 서비스 입니다.</th:object>

					</p>
				</div>
				<ol class="order_step">
					<li class="step_shop"><strong>STEP 1</strong> 매장선택</li>
					<li class="step_menu on"><strong>STEP 2</strong> 메뉴선택</li>
					<li class="step_order"><strong>STEP 3</strong> 주문하기</li>
					<li class="step_payment"><strong>STEP 4</strong> 결제하기</li>
				</ol>
				<div class="tab02">
					<ul>
						<li><a href="javascript:;" name="itemMenu"
							data-category-code="ITEM_FAVORITE">즐겨찾는 메뉴</a></li>
						<li><a href="step2?item=sandwich" name="itemMenu" data-category-code="ITEM_SANDWICH">샌드위치</a></li>
						<li><a href="step2?item=salad" name="itemMenu" data-category-code="ITEM_SALAD">샐러드</a></li>
						<li><a href="step2?item=wrap" name="itemMenu" data-category-code="ITEM_UNIT" data-grilled-sale-yn="N">랩ㆍ기타</a></li>
						
					</ul>
				</div>
				<!-- 컨텐츠 리스트 -->
				<div class="order_con" id="itemListMst">
					<ul class="list">
						<c:forEach items="${MenuList}" var="dto" varStatus="status">
							<li>
								<a href="menuView?mncode=${dto.mncode}" name="itemDetailBtn" data-item-idx="${dto.mncode}" data-category-code="ITEM_SANDWICH" data-group-cd="104" data-menu-type="ITEM_SANDWICH">
									<img src="/views/upload/menu/${dto.mnimg}" alt="${dto.mnname}" onerror="this.src='/images/common/noneImage.jpg'">
										<p>
												<strong>${dto.mnname}</strong>
												<span class="eng_name ">${dto.mnengname}</span>
												<span class="kcal ">${dto.mnprice}</span>
										</p>
										<div class="label">
											
										</div>
								</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--// index -->
		</div>
		<!--// sub content e -->
		<!-- 메뉴리스트 -->
	</div>
	<%@ include file="../../include/footer.jsp" %>
</body>
</html>