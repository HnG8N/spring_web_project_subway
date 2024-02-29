<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>옵션 선택</title>
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
	<link rel="stylesheet" type="text/css" href="/css/ui.popup.css?v=2023051202" />
<!-- 	<script type="text/javascript" src="/js/order/common/selectIngredients.js?v=2023051202"></script> -->
</head>
<body>
	<%@ include file="../../include/header.jsp"%>
	<!-- container s -->
	<div id="container">
		<!-- sub content s -->
		<div class="order fast_sub" id="content">
			<!-- index -->
			<div class="menu_view">
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
						<li data-cate-cd="ITEM_SANDWICH" class="active"><a
							data-cate-cd="ITEM_SANDWICH" href="javascript:;" name="itemMenu">샌드위치</a></li>
						<li data-cate-cd="ITEM_SALAD"><a data-cate-cd="ITEM_SALAD"
							href="javascript:void(0);" name="itemMenu">샐러드</a></li>
						<li data-cate-cd="ITEM_UNIT"><a data-cate-cd="ITEM_UNIT"
							href="javascript:;" name="itemMenu">랩ㆍ기타</a></li>
					</ul>
				</div>
				<div class="order_con">
					<div class="menu_info">
						<div class="menu_info">
							<div class="order_popup" id="popup_wrap">
								<form action="addcart" method="post" onsubmit="return validateForm();">
									<table>
										<tr>
											<td>
												<div class="option_display">
													<dl>
														<dt>빵 길이 선택</dt>
													</dl>
												</div>
												<div class="popup_content bread_leng">
													<ul>
														<li><label class="form_circle"> 
														<input	name="breadLength" type="radio" soldout="N"checked="checked" value="15" /> 
														<span class="icon"></span> <em>15cm</em>

														</label></li>


														<li><label class="form_circle"> 
														<input	name="breadLength" type="radio" soldout="N" value="30" />
														 <span class="icon"></span>
																<em>30cm</em>
														</label></li>
													</ul>
												</div>
											</td>
										</tr>
										<tr><td><br><br></td></tr>
										<tr>
											<td>
												<div class="option_display">
													<dl>
														<dt>빵 선택</dt>
													</dl>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="popup_content bread meterial">
													<div class="scroll_wrap">
														<ul>
															<c:forEach items="${breadDtos}" var="breadDto"
																varStatus="status">
																<li><label class="select_recipe"> <input
																		name="bread" type="radio"
																		data-ingredientsCode="${breadDto.icode}"
																		data-ingredientsName="${breadDto.iname}"
																		value="${breadDto.iname}" /> <span class="shape"></span>
																		<div class="info">
																			<img alt="${breadDto.iname}"
																				src="/images/menu/${breadDto.iimg}" /> <em>${breadDto.iname}</em>
																		</div>
																</label></li>
															</c:forEach>
														</ul>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="option_display">
													<dl>
														<dt>빵 토스팅 선택</dt>
													</dl>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="popup_content bread_leng">
													<ul>
														<li><label class="form_circle"> <input
																name="warm" type="radio" data-ingredientsCode="H0001"
																data-ingredientsName="토스팅" checked="checked" value="토스팅" />
																<span class="icon"></span> <em>토스팅</em>
														</label></li>
														<li><label class="form_circle"> <input
																name="warm" type="radio" data-ingredientsCode="H0002"
																data-ingredientsName="토스팅 안 함" value="토스팅 안 함" /> <span
																class="icon"></span> <em>토스팅 안 함</em>
														</label></li>
													</ul>
												</div>
											</td>
										</tr>
										<tr><td><br><br></td></tr>
										<tr>
											<td>
												<div class="option_display">
													<dl>
														<dt>치즈 선택</dt>
													</dl>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="popup_content cheese meterial">
													<div class="scroll_wrap">
														<ul>
															<c:forEach items="${cheeseDtos}" var="cheeseDto"
																varStatus="status">
																<li><label class="select_recipe"> <input
																		name="cheese" type="radio"
																		data-ingredientsCode="${cheeseDto.icode}"
																		data-ingredientsName="${cheeseDto.iname}"
																		value="${cheeseDto.iname}" /> <span class="shape"></span>
																		<div class="info">
																			<img class="" alt="${cheeseDto.iname}"
																				src="/images/menu/${cheeseDto.iimg}" /> <em>${cheeseDto.iname}</em>
																		</div>
																</label></li>
															</c:forEach>
														</ul>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="option_display">
													<dl>
														<dt>야채 선택 (여러개 선택 가능)</dt>
													</dl>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="popup_content vegetable meterial">
													<div class="scroll_wrap">
														<ul>
															<c:forEach items="${vegitableDtos}" var="vegitableDto"
																varStatus="status">
																<li><label class="select_recipe"> <input
																		data-ingredientsCode="${vegitableDto.icode}"
																		data-ingredientsName="${vegitableDto.iname}"
																		name="vegetable${status.count}" type="checkbox"
																		value="${vegitableDto.iname}" /> <span class="shape"></span>
																		<div class="info">
																			<img class="" src="/images/menu/${vegitableDto.iimg}" />
																			<em>${vegitableDto.iname}</em>
																			<!-- #210906 문구 변경 요청 -->
																		</div>
																</label></li>
															</c:forEach>
														</ul>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td><div class="option_display">
													<dl>
														<dt>소스 선택</dt>
													</dl>
												</div></td>
										</tr>
										<tr>
											<td>
												<div class="popup_content cheese meterial">
													<div class="scroll_wrap">
														<ul>
															<c:forEach items="${sauceDtos}" var="sauceDto"
																varStatus="status">
																<li><label class="select_recipe"> <input
																		name="sauce" type="radio"
																		data-ingredientsCode="${sauceDto.icode}"
																		data-ingredientsName="${sauceDto.iname}"
																		value="${sauceDto.iname}" /> <span class="shape"></span>
																		<div class="info">
																			<img alt="${sauceDto.iname}"
																				src="/images/menu/${sauceDto.iimg}" /> <strong></strong>
																			<em>${sauceDto.iname}</em>
																		</div>
																</label></li>
															</c:forEach>
														</ul>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="btn_area">
													<input class="btn bgc_point i_reg" type="submit"
														value="장바구니담기">
												</div>
											</td>
										</tr>

									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--// sub content e -->
		</div>
	</div>
	<!--// container -->
	<%@ include file="../../include/footer.jsp"%>
</body>
</html>