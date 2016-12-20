var employees ;
	$.getJSON("http://localhost:8080/CASESTUDY/json/electronics", function(json){
		employees = json;
	});
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
			      for(i=0;i<employees.length;i++)
			      {
			      var a="#id"+employees[i].productId;
			      $(a).css("display", "none");
			      
			      if($("#h1").prop("checked") == true &&  employees[i].price<500)
			      {
			        $(a).css("display", "inline-block");
			       }
			      if($("#h2").prop("checked") == true &&  employees[i].price>500 &&  employees[i].price < 1000 )
			      {
			        $(a).css("display", "inline-block");
			       }
			      if($("#h3").prop("checked") == true &&  employees[i].price<2999 && employees[i].price>999)
			      {
			        $(a).css("display", "inline-block");
			       }
			      if($("#h4").prop("checked") == true &&  employees[i].price>3000)
			      {
			        $(a).css("display", "inline-block");
			       }
			      }

			      if($("#h1").prop("checked") == false && $("#h2").prop("checked") == false)
			       {
			       if($("#h3").prop("checked") == false && $("#h4").prop("checked") == false)
			        {
			            for(i=0;i<employees.length;i++)
			            {
			               var b="#id"+employees[i].productId;
			              $(b).css("display", "inline-block");  
			            }
			         }
			       }
			     }
			    );
			});
	  });
