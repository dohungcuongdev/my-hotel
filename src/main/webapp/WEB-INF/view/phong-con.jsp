<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="vn/common/sub-content.jspf"%>
<div class="row">
    <div class="col-xs-12">
        <div class="panel">
            <header class="panel-heading">Danh sách phòng</header>
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
				         <th class="tr-p" onclick="sortAlpha(2,'table-rooms')">Thể loại</th>
				         <th class="tr-p" onclick="sortNum(3,'table-rooms')">Diện tích</th>
				         <th class="tr-p" onclick="sortNum(4,'table-rooms')">Giá Phòng</th>
				         <th class="tr-p" onclick="sortAlpha(5,'table-rooms')">Trạng thái</th>
				         <th class="tr-p" onclick="sortNum(6,'table-rooms')">Số người</th>
				         <th class="tr-p" onclick="sortNum(7,'table-rooms')">Độ Tiện nghi</th>
				         <th>Đặt</th>
				         <th>Edit</th>
				         <th>Del</th>
				     </tr>
				     </thead>
				     <tbody>
				     <c:forEach var="room" items="${listrooms}" varStatus="loop">
				         <tr>
				             <td>${loop.index + 1}</td>
				             <td>${room.name}</td>
				             <c:if test="${room.type.equalsIgnoreCase('deluxe')}">  
				                 <td><span style="font-size: 14px" class="label label-danger">${room.type}</span></td>
				                 </c:if>   
				                 <c:if test="${room.type.equalsIgnoreCase('family')}">  
				                 <td><span style="font-size: 14px" class="label label-success">${room.type}</span></td>
				                 </c:if> 
				                 <c:if test="${room.type.equalsIgnoreCase('couple')}">  
				                 <td><span style="font-size: 14px" class="label label-primary">${room.type}</span></td>
				                 </c:if>
				                 <c:if test="${room.type.equalsIgnoreCase('single')}">  
				                 <td><span style="font-size: 14px" class="label label-warning">${room.type}</span></td>
				                 </c:if>  
				             <td>${room.size}</td>
				             <td>${room.price}</td>
				             <td>${room.status}</td>
				             <td align="center">${room.numpeople}</td>
				             <td>${room.avgAminities}</td>
				             <td><button onclick="location.href = '${pageContext.request.contextPath}/room/${room.name}.html'" class="btn btn-default btn-xs"><i class="fa fa-check"></i></button></td>
				             <td><button onclick="location.href = '${pageContext.request.contextPath}/edit-room/${room.name}.html'" class="btn btn-default btn-xs"><i class="fa fa-pencil"></i></button></td>
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
<%@ include file="vn/common/footer.jspf"%>
<script>
    window.onload = function () { //first load page
    	
    };
    
    function responsiveFn() {
        responsiveGeneral('#manage-rooms-box', 500);
    }

     // load() event and resize() event are combined 
    $(window).ready(responsiveFn).resize(responsiveFn); 
</script>