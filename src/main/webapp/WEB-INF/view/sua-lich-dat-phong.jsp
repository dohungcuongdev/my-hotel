<%@ include file="vn/common/sub-content.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading" style="font-weight: bold; color:red">Lịch đặt phòng</header>
            <div class="panel-body">
                <form:form method="post" onsubmit="return checkReservationForm()" commandName="reservation" action="${pageContext.request.contextPath}/vn/sua.html">
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
                            <form:option value="hour">Thuê tiếng</form:option>
                            <form:option value="night">Qua đêm</form:option>
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
                            <form:option value="101">101 (VIP)</form:option>
                            <form:option value="102">102</form:option>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label>Tổng Gía phòng</label>
                    </div>
                    <div class="form-group">
                        <form:input type="number" class="form-control" placeholder="Giá phòng" path="roomPrice" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <div class="form-group">
                        <label>Giờ vào</label>
                    </div>
                    <div class="form-group">
                        <form:input type="datetime-local" required="true" class="form-control" id="checkin" path="checkin"/>
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
                    <p class="help-block">Điền thông tin để tiếp tục quá trình</p>
                    <button style="margin-top: 3.5px" type="submit" class="btn btn-info">Submit</button>
                    <button style="margin-top: 3.5px" onclick="location.href = '${pageContext.request.contextPath}/vn/sua-lich-dat-phong/${reservation.id}.html'" type="reset" class="btn btn-danger">Cancel</button>
                </form:form>
            </div>
        </section>
    </div>
</div>
<%@ include file="vn/common/footer.jspf"%>
<script type="text/javascript">
function checkReservationForm() {
/* 	$('#guest').css("border", "2px solid red");
	return false; */
}

window.onload = function () { //first load page
	$("#rental").val('${reservation.rental}');
};
</script>