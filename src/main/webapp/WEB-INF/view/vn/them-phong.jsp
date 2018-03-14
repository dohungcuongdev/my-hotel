<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/sub-content.jspf"%>
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading" style="font-weight: bold; color:red">Thêm Phòng mới</header>
            <div class="panel-body">
                <form:form method="post" commandName="newRoom" action="${pageContext.request.contextPath}/vn/xu-ly-them-phong.html">
                    <div class="form-group">
                        <label>Tên Phòng</label>
                    </div>
                    <div class="form-group">
                        <form:input required="true" type="text" class="form-control" path="name" placeholder="Tên Phòng"/>
                    </div>
                    <div class="form-group">
                        <label>Thể loại</label>
                    </div>
                    <div class="form-group">
                        <form:select class="form-control m-b-10" path="type" id="type">
                            <form:option value="VIP">VIP</form:option>
                            <form:option value="Thường">Thường</form:option>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label>Diện tích (mét vuông)</label>
                    </div>
                    <div class="form-group">
                        <form:input type="number" class="form-control" placeholder="Size" path="size" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <div class="form-group">
                        <label>Gía (nghìn VNĐ)</label>
                    </div>
                    <div class="form-group">
                        <form:input type="number" class="form-control" placeholder="Price" path="price" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <div class="form-group">
                        <label>Số người</label>
                    </div>
                    <div class="form-group">
                        <form:input type="number" class="form-control" placeholder="Number of Adults" path="numpeople" onkeypress='return event.charCode >= 48 && event.charCode <= 57'/>
                    </div>
                    <div class="form-group">
                        <label style="margin-top: 13px">Tiện nghi</label>
                    </div>
                    <div class="form-group">
                        <form:textarea id="amenities" class="form-control" path="amenities" placeholder="Write the amenities for this room..." rows="6"/>
                    </div>
                    <div class="form-group">
                        <label style="margin-top: 20px">Chi tiết</label>
                    </div>
                    <div class="form-group">
                        <form:textarea id="details" class="form-control" path="details" placeholder="Write the details for this room..." rows="4"/>
                    </div>
                    <p class="help-block">Điền đủ thông tin để thêm phòng mới.</p>
                    <button style="margin-top: 3.5px" type="submit" class="btn btn-info">Xác nhận</button>
                    <button style="margin-top: 3.5px" onclick="location.href = '${pageContext.request.contextPath}/edit-room/${room.name}.html'" type="reset" class="btn btn-danger">Hủy</button>
                </form:form>
            </div>
        </section>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
<script type="text/javascript">
    window.onload = function () { //first load page
        var addResult = '${addResult}';
        checkAddResult(addResult);
    };
</script>