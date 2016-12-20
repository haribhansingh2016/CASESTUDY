var employees ;
var path = window.location.pathname;
var num = path.split("=").pop();
console.log( num );

$.getJSON("http://localhost:8080/CASESTUDY/json/product/"+num, function(json){
		employees = json;
});
$(document).ready(function(){
	$("#img1").html("<img style='width:100%;height:300px' src="+employees.imageSrc+" >");
	$("#img0").append("<span class='color1'>Name:   </span>"+employees.name+
						"<br><span class='color1'>Price:  </span>"+employees.price);
});