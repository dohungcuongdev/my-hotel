<%@ include file="common/sub-content.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading"> Phụ Thu Hôm Nay </header>
			<center><h4><b style="color:#4697ce">Phòng Thường</b></h4></center>
			<div class="panel-body">
				<form class="form-horizontal tasi-form" method="get">
					<div class="form-group has-success">
						<label class="col-sm-2 control-label col-lg-2" for="inputSuccess">Thêm Tiền Phòng</label>
						<div class="col-lg-10">
							<input type="text" value="" class="form-control"
								id="inputHoliday" oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-warning">
						<label class="col-sm-2 control-label col-lg-2" for="inputWarning">Tiền Giờ Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputSaturday"
								oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-error">
						<label class="col-sm-2 control-label col-lg-2" for="inputError">Qua Đêm Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputSunday"
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
							<input type="text" value="" class="form-control"
								id="inputHoliday" oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-warning">
						<label class="col-sm-2 control-label col-lg-2" for="inputWarning">Tiền Giờ Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputSaturday"
								oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
					<div class="form-group has-error">
						<label class="col-sm-2 control-label col-lg-2" for="inputError">Qua Đêm Phụ Thu</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputSunday"
								oninput="evtInput()" value="0"
								onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
						</div>
					</div>
				</form>
			<br>
			<hr>
			</div>
			<div class="panel-body">
				<table>
					<thead>
						<th class="tr-p" onclick="sortAlpha(0,'table-rooms')">Ngày</th>
						<th class="tr-p">Áp Dụng Cho Hôm Nay</th>
						<th class="tr-p">Áp Dụng</th>
					</thead>
					<tbody>
						<tr>
							<td style="color: #27c24c"><b>Ngày Lễ</b></td>
							<td><button type="button" class="btn btn-success"
									onclick="selectAdditionPayment0()">Chọn</button></td>
							<td></td>
						</tr>
						<tr>
							<td style="color: #f39c12"><b>Thứ Bảy</b></td>
							<td><button type="button" class="btn btn-warning"
									onclick="selectAdditionPayment1()">Chọn</button>
							<td></td>
						</tr>
						<tr>
							<td style="color: #f05050"><b>Chủ nhật</b></td>
							<td><button type="button" class="btn btn-danger"
									onclick="selectAdditionPayment2()">Chọn</button></td>
							<td>
								<div style="color:#45cf95;">
	                                    <b><i class="fa fa-check"></i>Đã Chọn</b>
	                            </div>
                            </td>
						</tr>
						<tr>
							<td style="color: #4697ce"><b>Ngày Lễ + Thứ Bảy</b>
							</td>
							<td><button type="button" class="btn btn-primary"
									onclick="selectAdditionPayment01()">Chọn</button></td>
							<td></td>
						</tr>
						<tr>
							<td style="color: #343a40"><b>Ngày Lễ + Chủ nhật</b>
							<td><button type="button" class="btn btn-dark"
									onclick="selectAdditionPayment02()">Chọn</button></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<br>
				<hr>
				<br>
			    <br>
				<table>
					<thead>
						<th class="tr-p" onclick="sortAlpha(0,'table-rooms')">Ngày</th>
						<th class="tr-p" onclick="sortNum(1,'table-rooms')">Tiền Phụ
							Thu Phòng Thường</th>
						<th class="tr-p" onclick="sortNum(2,'table-rooms')">Tiền Phụ
							Thu Phòng VIP</th>
						<th class="tr-p">Áp Dụng Cho Hôm Nay</th>
					</thead>
					<tbody>
						<tr>
							<td style="color: #27c24c"><b>Ngày Lễ</b></td>
							<td><b id="holiday">0</b></td>
							<td><b id="holidayVIP">0</b></td>
							<td><button type="button" class="btn btn-success"
									onclick="selectAdditionPayment0()">Chọn</button></td>
						</tr>
						<tr>
							<td style="color: #f39c12"><b>Thứ Bảy</b></td>
							<td><b id="saturday">0</b></td>
							<td><b id="saturdayVIP">0</b></td>
							<td><button type="button" class="btn btn-warning"
									onclick="selectAdditionPayment1()">Chọn</button>
						</tr>
						<tr>
							<td style="color: #f05050"><b>Chủ nhật</b></td>
							<td><b id="sunday">0</b></td>
							<td><b id="sundayVIP">0</b></td>
							<td><button type="button" class="btn btn-danger"
									onclick="selectAdditionPayment2()">Chọn</button></td>
						</tr>
						<tr>
							<td style="color: #4697ce"><b>Ngày Lễ + Thứ Bảy</b>
							<td><b id="holiday7">0</b></td>
							<td><b id="holiday7VIP">0</b></td>
							</td>
							<td><button type="button" class="btn btn-primary"
									onclick="selectAdditionPayment01()">Chọn</button></td>
						</tr>
						<tr>
							<td style="color: #343a40"><b>Ngày Lễ + Chủ nhật</b>
							<td><b id="holiday8">0</b></td>
							<td><b id="holiday8VIP">0</b></td>
							</td>
							<td><button type="button" class="btn btn-dark"
									onclick="selectAdditionPayment02()">Chọn</button></td>
						</tr>
					</tbody>
				</table>
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
							<b>Hình Thức Phụ Thu: <element style="color: #00a65a">Thêm Tiền Phòng</element></b></b>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
						    <b style="margin-left: 30%; color:#4697ce">Phòng Thường</b>
							<div class="stat-icon" style="color: #4697ce">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionPayment}</h5>
							<h5 class="stat-info">${additionPaymentAlpha}</h5>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
							<b style="margin-left: 35%; color: #F05050">Phòng VIP</b>
							<div class="stat-icon" style="color: #F05050">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionPayment}</h5>
							<h5 class="stat-info">${additionPaymentAlpha}</h5>
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
							<h5 class="stat-info">${additionPayment}</h5>
							<h5 class="stat-info">${additionPaymentAlpha}</h5>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
							<b style="margin-left: 35%; color: #F05050">Phòng VIP</b>
							<div class="stat-icon" style="color: #F05050">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionPayment}</h5>
							<h5 class="stat-info">${additionPaymentAlpha}</h5>
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
							<h5 class="stat-info">${additionPayment}</h5>
							<h5 class="stat-info">${additionPaymentAlpha}</h5>
						</div>
					</div>
					<div class="col-md-4">
						<div class="stat">
							<b style="margin-left: 35%; color: #F05050">Phòng VIP</b>
							<div class="stat-icon" style="color: #F05050">
								<i class="fa fa-dollar fa-3x stat-elem"></i>
							</div>
							<h5 class="stat-info">${additionPayment}</h5>
							<h5 class="stat-info">${additionPaymentAlpha}</h5>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
<style>
.btn-dark {
	color: #fff;
	background-color: #343a40;
	border-color: #343a40;
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
	function notAcceptNull(data) {
		if (data == null || typeof data == "undefined" || isNaN(data)
				|| data == "") {
			return 0;
		}
		return data;
	}

	function changeData() {
		var inputHoliday = notAcceptNull(parseInt($('#inputHoliday').val()));
		var inputSaturday = notAcceptNull(parseInt($('#inputSaturday').val()));
		var inputSunday = notAcceptNull(parseInt($('#inputSunday').val()));
		$('#holiday').html(inputHoliday);
		$('#saturday').html(inputSaturday);
		$('#sunday').html(inputSunday);
		$('#holiday7').html(inputHoliday + inputSaturday);
		$('#holiday8').html(inputHoliday + inputSunday);
	}

	function evtInput() {
		changeData();
		$('#result').hide();
	}

	function selectAdditionPayment0() {
		var inputHoliday = notAcceptNull(parseInt($('#inputHoliday').val()));
		location.href = '${pageContext.request.contextPath}/vn/phu-thu/ngay-le/'
				+ inputHoliday + '/' + 0 + '.html';
	}

	function selectAdditionPayment1() {
		var inputSaturday = notAcceptNull(parseInt($('#inputSaturday').val()));
		location.href = '${pageContext.request.contextPath}/vn/phu-thu/thu-7/'
				+ 0 + '/' + inputSaturday + '.html';
	}

	function selectAdditionPayment2() {
		var inputSunday = notAcceptNull(parseInt($('#inputSunday').val()));
		location.href = '${pageContext.request.contextPath}/vn/phu-thu/CN/'
				+ 0 + '/' + inputSunday + '.html';
	}

	function selectAdditionPayment01() {
		var inputHoliday = notAcceptNull(parseInt($('#inputHoliday').val()));
		var inputSaturday = notAcceptNull(parseInt($('#inputSaturday').val()));
		location.href = '${pageContext.request.contextPath}/vn/phu-thu/ngay-le7/'
				+ inputHoliday + '/' + inputSaturday + '.html';
	}

	function selectAdditionPayment02() {
		var inputHoliday = notAcceptNull(parseInt($('#inputHoliday').val()));
		var inputSunday = notAcceptNull(parseInt($('#inputSunday').val()));
		location.href = '${pageContext.request.contextPath}/vn/phu-thu/ngay-leCN/'
				+ inputHoliday + '/' + inputSunday + '.html';
	}

	window.onload = function() { //first load page
		var additionDetails = '${additionDetails}';
		switch (additionDetails) {
		case 'Ngày Lễ':
			var additionPayment1 = '${additionPayment1}';
			$('#inputHoliday').val(additionPayment1);
			changeData();
			break;
		case 'Thứ Bảy':
			var additionPayment2 = '${additionPayment2}';
			$('#inputSaturday').val(additionPayment2);
			changeData();
			break;
		case 'Chủ Nhật':
			var additionPayment2 = '${additionPayment2}';
			$('#inputSunday').val(additionPayment2);
			changeData();
			break;
		case 'Ngày Lễ + Thứ Bảy':
			var additionPayment1 = '${additionPayment1}';
			var additionPayment2 = '${additionPayment2}';
			$('#inputHoliday').val(additionPayment1);
			$('#inputSaturday').val(additionPayment2);
			changeData();
			break;
		case 'Ngày Lễ + Chủ Nhật':
			var additionPayment1 = '${additionPayment1}';
			var additionPayment2 = '${additionPayment2}';
			$('#inputHoliday').val(additionPayment1);
			$('#inputSunday').val(additionPayment2);
			changeData();
			break;
		default:
			$('#inputHoliday').val(0);
			$('#inputSaturday').val(0);
			$('#inputSunday').val(0);
			changeData();
		}
	};
</script>