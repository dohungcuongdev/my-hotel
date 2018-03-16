<%@ include file="common/sub-content.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading"> Phụ Thu Hôm Nay - ${today}</header>
						<div class="panel-body">
				<br>
				<center><b><h1 style="color:#AC75F0" id="titleAD">Phụ Thu: ${additionDetails}</h1></b></center>
			    <br>
				<br>
				<div id="result">
					<div class="col-md-4">
						<div class="row">
							<b>Áp Dụng Phụ Thu: ${additionDetails}</b>
						</div>
						<br>
						<div class="row">
							<b>Hình Thức Phụ Thu: <element style="color: #00a65a">Thêm Tiền Phòng</element></b></b>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
						    <b style="margin-left: 30%; color:#4697ce">Phòng Thường</b>
							<div class="stat-icon" style="color: #4697ce">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionalNormalRoomPrice}</h5>
							<h5 class="stat-info">${additionalNormalRoomPriceStr}</h5>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
							<b style="margin-left: 35%; color: #F05050">Phòng VIP</b>
							<div class="stat-icon" style="color: #F05050">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionalVIPRoomPrice}</h5>
							<h5 class="stat-info">${additionalVIPRoomPriceStr}</h5>
						</div>
					</div>
				</div>
				<br>
				<hr>
				<br>
				<div id="result">
					<div class="col-md-4">
						<div class="row">
							<b>Áp Dụng Phụ Thu: ${additionDetails}</b>
						</div>
						<br>
						<div class="row">
							<b>Hình Thức Phụ Thu: <element style="color: #f39c12">Tiền Giờ Phụ Thu</element></b>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
						    <b style="margin-left: 30%; color:#4697ce">Phòng Thường</b>
							<div class="stat-icon" style="color: #4697ce">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionalNormalHourPrice}</h5>
							<h5 class="stat-info">${additionalNormalHourPriceStr}</h5>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
							<b style="margin-left: 35%; color: #F05050">Phòng VIP</b>
							<div class="stat-icon" style="color: #F05050">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionalVIPHourPrice}</h5>
							<h5 class="stat-info">${additionalVIPHourPriceStr}</h5>
						</div>
					</div>
				</div>
				<br>
				<hr>
				<br>
				<div id="result">
					<div class="col-md-4">
						<div class="row">
							<b>Áp Dụng Phụ Thu: ${additionDetails}</b>
						</div>
						<br>
						<div class="row">
							<b>Hình Thức Phụ Thu: <element style="color: #f56954">Qua Đêm Phụ Thu</element></b></b>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
						    <b style="margin-left: 30%; color:#4697ce">Phòng Thường</b>
							<div class="stat-icon" style="color: #4697ce">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionalNormalNightPrice}</h5>
							<h5 class="stat-info">${additionalNormalNightPriceStr}</h5>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
							<b style="margin-left: 35%; color: #F05050">Phòng VIP</b>
							<div class="stat-icon" style="color: #F05050">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionalVIPNightPrice}</h5>
							<h5 class="stat-info">${additionalVIPNightPriceStr}</h5>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<br>
			<center><h4><b style="color:#4697ce">Phòng Thường</b></h4></center>
			<div class="panel-body">
				<form class="form-horizontal tasi-form" method="get">
					<div class="form-group has-success">
						<label class="col-sm-2 control-label col-lg-2" for="inputSuccess">Thêm Tiền Phòng</label>
						<div class="col-lg-10">
							<input type="text" class="form-control"
								id="additionalNormalRoomPriceInput" oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-warning">
						<label class="col-sm-2 control-label col-lg-2" for="inputWarning">Tiền Giờ Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="additionalNormalHourPriceInput"
								oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-error">
						<label class="col-sm-2 control-label col-lg-2" for="inputError">Qua Đêm Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="additionalNormalNightPriceInput"
								oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
				</form>
			</div>
			<center><h4><b style="color: #F05050">Phòng VIP</b></h4></center>
			<div class="panel-body">
				<form class="form-horizontal tasi-form" method="get">
					<div class="form-group has-success">
						<label class="col-sm-2 control-label col-lg-2" for="inputSuccess">Thêm Tiền Phòng</label>
						<div class="col-lg-10">
							<input type="text" class="form-control"
								id="additionalVIPRoomPriceInput" oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-warning">
						<label class="col-sm-2 control-label col-lg-2" for="inputWarning">Tiền Giờ Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="additionalVIPHourPriceInput"
								oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-error">
						<label class="col-sm-2 control-label col-lg-2" for="inputError">Qua Đêm Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="additionalVIPNightPriceInput"
								oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
				</form>
			<br>
			Thêm tên để áp dụng loại phụ thu này: <input type="text" class="form-control" id="additionDetailsInput">
			<div class="panel-body">
                 <center><button type="button" onclick="addNewAdditionPayment()" class="btn btn-success">Áp Dụng Phụ Thu Này <i class="fa fa-paperclip "></i></button></center>
            </div>
			<br>
			<hr>
			</div>
			<div class="panel-body">
			<center><h4><b style="color:#fa8564">Áp dụng phụ thu có sẵn</b></h4></center>
			<br>
				<table>
					<thead>
						<th class="tr-p" onclick="sortAlpha(0,'table-rooms')">STT</th>
						<th class="tr-p" onclick="sortAlpha(0,'table-rooms')">Ngày</th>
						<th class="tr-p">Đã Áp Dụng</th>
						<th class="tr-p">Áp Dụng Cho Hôm Nay</th>
					</thead>
					<tbody>
					<c:forEach var="additionalPayment" items="${allAdditionalPayments}" varStatus="loop">
						<c:if test="${additionalPayment.id==1}">  
							<tr>
								<td>${loop.index + 1}</td>
								<td style="color: #27c24c"><b>${additionalPayment.additionDetails}</b></td>
								<td>
								<c:if test="${additionalPayment.selected == true}">
									<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            	</div>
								</c:if>
								</td>
								<td><button type="button" class="btn btn-success"
										onclick="selectAdditionPayment('${additionalPayment.id}', '${selectedID}')">Chọn</button></td>
							</tr>
						</c:if>
						<c:if test="${additionalPayment.id==2}">  
							<tr>
								<td>${loop.index + 1}</td>
								<td style="color: #f39c12"><b>${additionalPayment.additionDetails}</b></td>
								<td>
								<c:if test="${additionalPayment.selected == true}">
									<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            	</div>
								</c:if>
								</td>
								<td><button type="button" class="btn btn-warning"
										onclick="selectAdditionPayment('${additionalPayment.id}', '${selectedID}')">Chọn</button></td>
							</tr>
						</c:if>
						<c:if test="${additionalPayment.id==3}">  
							<tr>
								<td>${loop.index + 1}</td>
								<td style="color: #f05050"><b>${additionalPayment.additionDetails}</b></td>
								<td>
								<c:if test="${additionalPayment.selected == true}">
									<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            	</div>
								</c:if>
								</td>
								<td><button type="button" class="btn btn-danger"
										onclick="selectAdditionPayment('${additionalPayment.id}', '${selectedID}')">Chọn</button></td>
							</tr>
						</c:if>
						<c:if test="${additionalPayment.id==4}">  
							<tr>
								<td>${loop.index + 1}</td>
								<td style="color: #4697ce"><b>${additionalPayment.additionDetails}</b></td>
								<td>
								<c:if test="${additionalPayment.selected == true}">
									<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            	</div>
								</c:if>
								</td>
								<td><button type="button" class="btn btn-primary"
										onclick="selectAdditionPayment('${additionalPayment.id}', '${selectedID}')">Chọn</button></td>
							</tr>
						</c:if>  
						<c:if test="${additionalPayment.id==5}">  
							<tr>
								<td>${loop.index + 1}</td>
								<td style="color:#343a40"><b>${additionalPayment.additionDetails}</b></td>
								<td>
								<c:if test="${additionalPayment.selected == true}">
									<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            	</div>
								</c:if>
								</td>
								<td><button type="button" class="btn btn-dark"
										onclick="selectAdditionPayment('${additionalPayment.id}', '${selectedID}')">Chọn</button></td>
							</tr>
						</c:if>
						<c:if test="${additionalPayment.id==6}">  
							<tr>
								<td>${loop.index + 1}</td>
								<td style="color:gray"><b>${additionalPayment.additionDetails}</b></td>
								<td>
								<c:if test="${additionalPayment.selected == true}">
									<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            	</div>
								</c:if>
								</td>
								<td><button type="button" class="btn"
										onclick="selectAdditionPayment('${additionalPayment.id}', '${selectedID}')">Chọn</button></td>
							</tr>
						</c:if>
						<c:if test="${additionalPayment.id>6}">  
							<tr>
								<td>${loop.index + 1}</td>
								<td><b>${additionalPayment.additionDetails}</b></td>
								<td>
								<c:if test="${additionalPayment.selected == true}">
									<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            	</div>
								</c:if>
								</td>
								<td><button type="button" class="btn btn-black-white"
										onclick="selectAdditionPayment('${additionalPayment.id}', '${selectedID}')">Chọn</button></td>
							</tr>
						</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
<style>
.btn-black-white {
    background-color: white;
    color: black;
    border: 2px solid #555555;
}

.btn-black-white:hover {
    background-color: white;
    color: black;
}

.btn-dark {
	color: #fff;
	background-color: #343a40;
	border-color: #343a40;
}

.btn-dark:hover {
    background-color: #555555;
    color: white;
}

hr {
	border: 0;
	clear: both;
	display: block;
	width: 96%;
	background-color: black;
	height: 1px;
}
</style>
<script>
	function notAcceptNullNumber(data) {
		if (data == null || typeof data == "undefined" || isNaN(data)
				|| data == "") {
			return 0;
		}
		return data;
	}
	
	function isNotNullNumbers(data) {
		if (data == null || typeof data == "undefined" || isNaN(data)
				|| data == "") {
			return false;
		}
		return true;
	}
	
	function notAcceptNullString(data) {
		if (data == null || typeof data == "undefined" || data == "") {
			return "";
		}
		return data;
	}

	function selectAdditionPayment(newId, selectedID) {
		location.href = '${pageContext.request.contextPath}/vn/phu-thu/' + newId + '/' + selectedID + '.html';
	}
	
	function addNewAdditionPayment() {
		let selectID = '${selectedID}';
		let additionDetails = $('#additionDetailsInput').val();
		let additionalVIPRoomPrice = notAcceptNullNumber($('#additionalVIPRoomPriceInput').val());
		let additionalVIPHourPrice = notAcceptNullNumber($('#additionalVIPHourPriceInput').val());
		let additionalVIPNightPrice = notAcceptNullNumber($('#additionalVIPNightPriceInput').val());
		let additionalNormalRoomPrice = notAcceptNullNumber($('#additionalNormalRoomPriceInput').val());
		let additionalNormalHourPrice = notAcceptNullNumber($('#additionalNormalHourPriceInput').val());
		let additionalNormalNightPrice = notAcceptNullNumber($('#additionalNormalNightPriceInput').val());	
		
		if(notAcceptNullString(additionDetails) != "" ) {
			additionDetails = additionDetails.replace('/', "-");
			location.href='${pageContext.request.contextPath}/vn/ap-dung-moi/' + additionDetails + '/' + additionalVIPRoomPrice + '/' + additionalVIPHourPrice + '/' + additionalVIPNightPrice + '/' + additionalNormalRoomPrice + '/' + additionalNormalHourPrice + '/' + additionalNormalNightPrice + '/' + selectID + '.html';
		}
		
	}

	window.onload = function() { //first load page
	};
</script>