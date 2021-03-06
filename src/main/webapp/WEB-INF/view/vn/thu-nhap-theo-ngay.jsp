<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/sub-content.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-xs-12">
        <div class="panel">
            <header class="panel-heading">Đơn đặt phòng hôm này - ngày ${today }</header>
            <div class="box-tools m-b-15">
                <div class="input-group">
                    <input type="text" name="table_search" class="form-control input-sm pull-right"  style="width: 150px;" id="input-room" onkeyup="searchInputTable('input-room', 'table-rooms')"  placeholder="Search for rooms.." title="Type in a room"/>
                    <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </div>
            <div class="panel-body table-responsive">    
				 <table id="table-rooms"  class="table-responsive" border="1">
				 	 <thead>
				     <tr id="tableHeader">
				         <th class="tr-p" onclick="sortNum(0,'table-rooms')">STT</th>
				         <th class="tr-p" onclick="sortAlpha(1,'table-rooms')">Khách Hàng</th>
				         <th class="tr-p" onclick="sortAlpha(2,'table-rooms')">Phòng</th>
				         <th class="tr-p" onclick="sortNum(6,'table-rooms')">Thuê</th>
				         <th class="tr-p" onclick="sortNum(6,'table-rooms')">Giờ vào</th>
				         <th class="tr-p" onclick="sortNum(7,'table-rooms')">Giờ ra</th>
				         <th class="tr-p" onclick="sortNum(7,'table-rooms')">Thời gian ở</th>
				         <th class="tr-p" onclick="sortAlpha(2,'table-rooms')">Tiền Phòng</th>
				         <th class="tr-p" onclick="sortNum(3,'table-rooms')">Tiền Dịch Vụ</th>
				         <th class="tr-p" onclick="sortNum(4,'table-rooms')">Phụ Thu</th>
				         <th class="tr-p" onclick="sortNum(7,'table-rooms')">Thành tiền</th>
				         <th>Sửa</th>
				         <th>Trả</th>
				         <th>Xóa</th>
				     </tr>
				     </thead>
				     <tbody>
				     <c:forEach var="reservation" items="${listReservationToday}" varStatus="loop">
				         <tr>
				             <td>${loop.index + 1}</td>
				             <td>${reservation.guest}</td>
				             <td><span style="font-size: 14px" class="${reservation.getAutoGenColorClassRoom()}">${reservation.room}</span></td>
				             <td>${reservation.rental}</td>
				             <td>${reservation.checkin}</td>
				             <td>${reservation.checkout}</td>
				             <td>${reservation.totalStayDuration}</td>
				             <td>${reservation.roomPrice}</td>
				             <td>${reservation.servicePayment}</td>
				             <td>${reservation.additionPayment}</td>
				             <td>${reservation.totalPayment}</td>
				             <td><button onclick="location.href = '${pageContext.request.contextPath}/vn/sua-lich-dat-phong/${reservation.id}.html'" class="btn btn-default btn-xs"><i class="fa fa-pencil"></i></button></td>
				             <td><button onclick="location.href = '${pageContext.request.contextPath}/vn/tra-phong/${reservation.id}.html'" class="btn btn-default btn-xs"><i class="fa fa-check"></i></button></td>
				             <td><button onclick="deleteRoom('${pageContext.request.contextPath}/remove-room/${reservation.id}.html')" class="btn btn-default btn-xs"><i class="fa fa-times"></i></button></td>
				         </tr>
				     </c:forEach>
				     </tbody>
				 </table>
            </div>
            <div class="panel-body">
                 <center><b>Tổng thu nhập <pre style="color: red">1000000000</pre> (VNĐ)</b></center>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
<script>
    window.onload = function () { //first load page
    };
    
    function responsiveFn() {
        responsiveGeneral('#manage-rooms-box', 500);
    }

     // load() event and resize() event are combined 
    $(window).ready(responsiveFn).resize(responsiveFn); 
</script>