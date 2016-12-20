var path = window.location.search.substring(1);
var num = path.split("=");
var employees ;
	if(num[1]==null){
		$.getJSON("http://localhost:8080/CASESTUDY/json/home/", function(json){
			employees = json;
		});
	}
	else{
		$.getJSON("http://localhost:8080/CASESTUDY/json/home/"+num[1], function(json){
			employees = json;
		});
		var filterValue = parseInt(num[1]) ;
		if(filterValue>=8){
			filterValue-=8;
			document.getElementById("h4").checked = true;
			
		}
		if(filterValue>=4){
			filterValue-=4;
			document.getElementById("h3").checked = true;
		}
		if(filterValue>=2){
			filterValue-=2;
			document.getElementById("h2").checked = true;
		}
		if(filterValue>=1){
			filterValue-=1;
			document.getElementById("h1").checked = true;
		}
	}
	
	
	  $(document).ajaxStop(function () {
		  $(document).ready(function(){
				var txt="";
				for(i=0;i<employees.length;i++){
				txt+="<div class=\"img\" id=id"+employees[i].productId+">\
				      <a  href=  'http://localhost:8080/CASESTUDY/product/"+employees[i].productId+"\'><img src=../images/"+employees[i].imageSrc+"><div class=\"desc\">"+employees[i].name+"</div></a>\
				       <div class=\"price\"> Rs "+employees[i].price+"</div></div>";
				}
			    $("#boy").prepend(txt);
			    $("#h1,#h2,#h3,#h4").click(
			     function()
			     {
			      
			      var num = 0;
			      
			      if($("#h1").prop("checked"))
			      {
			        num+=1;
			       }
			      if($("#h2").prop("checked"))
			      {
			    	  num+=2;
			       }
			      if($("#h3").prop("checked"))
			      {
			    	  num+=4;
			       }
			      if($("#h4").prop("checked"))
			      {
			    	  num+=8;
			       }
			      window.location.assign("http://localhost:8080/CASESTUDY/home/filter?filterValue="+num);
			     }
			    );
			});
	  });
