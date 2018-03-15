<%@ include file="common/sub-content.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading" style="font-weight: bold; color:red">Trả phòng</header>
            <div class="panel-body">
                <form:form method="post" onsubmit="return checkReservationForm()" commandName="newReservation" action="${pageContext.request.contextPath}/room-added.html">
                    <div class="form-group">
                        <label>Tên Khách Hàng</label>
                    </div>
                    <div class="form-group">
                        <form:input required="true" type="text" class="form-control" id="guest" path="guest" placeholder="Điền tên khách hàng"/>
                    </div>
                    <div class="form-group">
                        <label>Hình thức thuê</label>
                    </div>
                    <div class="form-group">
                        <form:select class="form-control m-b-10" path="rental" id="rental">
                            <form:option value="Thuê tiếng">Thuê tiếng</form:option>
                            <form:option value="Qua đêm">Qua đêm</form:option>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label>Giấy tờ tùy thân</label>
                    </div>
                    <div class="form-group">
                        <form:input required="true" type="number" class="form-control" placeholder="Ví dụ: Số CMND ..." path="cMND" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <div class="form-group">
                        <label>Phòng</label>
                    </div>
                    <div class="form-group">
						<form:select class="form-control m-b-10" path="room" id="room">
							<c:forEach var="entry" items="${roomsWithType}">
								<form:option value="${entry.key}">${entry.key} (${entry.value})</form:option>
							</c:forEach>
						</form:select>
					</div>
                    <div class="form-group">
                        <label>Giờ vào</label>
                    </div>
                    <div class="form-group">
                        <form:input type="datetime-local" required="true" class="form-control" id="checkin" path="checkin"/>
                    </div>
                    <div class="form-group">
                        <label>Giờ ra</label>
                    </div>
                    <div class="form-group">
                        <form:input type="datetime-local" required="true" class="form-control" id="checkout" path="checkout"/>
                    </div>
                    <div class="form-group">
                        <label>Thời gian ở</label>
                    </div>
                    <div class="form-group">
                        <form:input required="true" type="text" class="form-control" placeholder="Thời gian ở" path="totalStayDuration"/>
                    </div>
                    <div class="form-group">
                        <label>Tổng Gía phòng</label>
                    </div>
                    <div class="form-group">
                        <form:textarea type="text" class="form-control" path="note" placeholder="Ghi chú" rows="4"/>
                    </div>
                    <div class="form-group">
                        <label>Ghi Chú</label>
                    </div>
                    <div class="form-group">
                        <form:textarea type="text" class="form-control" path="note" placeholder="Ghi chú" rows="4"/>
                    </div>
                    <div class="form-group">
                        <label>Dịch vụ</label>
                    </div>
                    <div class="form-group">
                        <form:textarea type="text" class="form-control" path="service" placeholder="Dịch vụ" rows="4"/>
                    </div>
                    <div class="form-group">
                        <label>Tổng tiền dịch vụ</label>
                    </div>
                    <div class="form-group">
                        <form:input type="number" class="form-control" placeholder="Tổng tiền dịch vụ" path="servicePayment" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <div class="form-group">
                        <label>Phụ thu</label>
                    </div>
                    <div class="form-group">
                        <form:input type="text" class="form-control" placeholder="Phụ thu" path="additionDetails"/>
                    </div>
                    <div class="form-group">
                        <label>Tiền phụ thu</label>
                    </div>
                    <div class="form-group">
                        <form:input type="number" class="form-control" placeholder="Tiền phụ thu thêm" path="additionPayment" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <div class="form-group">
                        <label>Tổng tiền phải thanh toán</label>
                    </div>
                    <div class="form-group">
                        <form:input type="number" class="form-control" placeholder="Tổng tiền phải thanh toán" path="totalPayment" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <p class="help-block">Điền thông tin để tiếp tục quá trình</p>
                    <button style="margin-top: 3.5px" type="submit" class="btn btn-info">Submit</button>
                    <button style="margin-top: 3.5px" onclick="location.href = '${pageContext.request.contextPath}/edit-room/${room.name}.html'" type="reset" class="btn btn-danger">Cancel</button>
                </form:form>
            </div>
        </section>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
<script type="text/javascript">
function checkReservationForm() {
/* 	$('#guest').css("border", "2px solid red");
	return false; */
}

window.onload = function () { //first load page
	var isoStr = new Date().addHours(7).toISOString();
	$('#checkout').val(isoStr.substring(0, isoStr.length - 8));
	$("#rental").val('${newReservation.rental}');
	$("#room").val('${newReservation.room}');
	
	let room = $('#room').val();
	
	//ngày thường
	if(rental == 'hour') {
		if(room == '101') { //vip
			$('#roomPrice').val('100')
		} else {            //thường
			$('#roomPrice').val('')
		}
		//tiếng tiếp theo 30
	}
	
	if(rental == 'night') {
		// 9 tối - 9 sáng 200k
		// 
		if(room == '101') {
			$('#roomPrice').val('')
		}
	}
	
	// vip 220
	

	
	
};

Date.prototype.addHours = function(h) {
	this.setTime(this.getTime() + (h * 60 * 60 * 1000));
	return this;
}
</script>