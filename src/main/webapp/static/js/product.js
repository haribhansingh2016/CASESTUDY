var employees ;
var path = window.location.search.substring(1);
var num = path.split("=");

$.getJSON("http://localhost:8080/CASESTUDY/json/product/"+num[1], function(json){
		employees = json;
});
$(document).ajaxStop(function () {
	$(document).ready(function(){
		$("#img1").html("<img style='width:100%;height:300px' src=../images/"+employees.imageSrc+" >");
		$("#img0").append("<span class='color1'>Name:   </span>"+employees.name+
							"<br><span class='color1'>Price:  </span>"+employees.price);
		$( "#myButton" ).click(function() {
			  window.location.assign("http://localhost:8080/CASESTUDY/user/cart/"+employees.productId);
			});
	});
});
