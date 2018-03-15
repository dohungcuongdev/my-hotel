<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/sub-content.jspf"%>
<div class="row">
    <div class="col-xs-12">
        <div class="panel">
            <header class="panel-heading">Phòng đang ở</header>
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
				         <th class="tr-p" onclick="sortAlpha(1,'table-rooms')">Phòng</th>
				         <th class="tr-p" onclick="sortAlpha(2,'table-rooms')">Khách đang ở</th>
				         <th class="tr-p" onclick="sortNum(3,'table-rooms')">Giấy Tờ</th>
				         <th class="tr-p" onclick="sortNum(4,'table-rooms')">Thuê</th>
				         <th class="tr-p" onclick="sortAlpha(5,'table-rooms')">Giờ vào</th>
				         <th class="tr-p" onclick="sortNum(6,'table-rooms')">Dịch vụ</th>
				         <th class="tr-p" onclick="sortNum(7,'table-rooms')">Ghi chú</th>
				         <th>Trả</th>
				         <th>Edit</th>
				         <th>Del</th>
				     </tr>
				     </thead>
				     <tbody>
				     <c:forEach var="room" items="${roomsBooked}" varStatus="loop">
				         <tr>
				             <td>${loop.index + 1}</td>
				             <td><span style="font-size: 14px" class="${room.getAutoGenColorClassRoom()}">${room.room}</span></td>
				             <td>${room.guest}</td>
				             <td>${room.cMND}</td>
				             <td>${room.rental}</td>
				             <td>${room.checkin}</td>
				             <td>${room.service}</td>
				             <td>${room.note}</td>
				             <td><button onclick="location.href = '${pageContext.request.contextPath}/vn/tra-phong/${room.id}.html'" class="btn btn-default btn-xs"><i class="fa fa-check"></i></button></td>
				             <td><button onclick="location.href = '${pageContext.request.contextPath}/vn/sua-lich-dat-phong-phong/${room.id}.html'" class="btn btn-default btn-xs"><i class="fa fa-pencil"></i></button></td>
				             <td><button onclick="deleteRoom('${pageContext.request.contextPath}/remove-room/${room.id}.html')" class="btn btn-default btn-xs"><i class="fa fa-times"></i></button></td>
				         </tr>
				     </c:forEach>
				     </tbody>
				 </table>
            </div>
            <div class="panel-body">
                 <center><button type="button" onclick="location.href='${pageContext.request.contextPath}/add-room.html'" class="btn btn-success">Add New Room <i class="fa fa-bed"></i></button></center>
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