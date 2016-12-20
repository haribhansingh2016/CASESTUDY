var employees ;
	$.getJSON("http://localhost:8080/CASESTUDY/json/sports", function(json){
		employees = json;
	});
	  $(document).ajaxStop(function () {
		  $(document).ready(function(){
				var txt="";
				var sb=[];
				var sp=[];
				for(i=0;i<employees.length;i++){
				txt+="<div class=\"img\" id=id"+employees[i].productId+">\
				      <a  href= 'http://localhost:8080/CASESTUDY/product/"+employees[i].productId+"\'><img src=../images/"+employees[i].imageSrc+"><div class=\"desc\">"+employees[i].name+"</div></a>\
				       <div class=\"price\"> Rs "+employees[i].price+"</div></div>";
					sp[i]=1;
				 sb[i]=1;
				}
			    $("#body").prepend(txt);
			    $("#sp1,#sp2,#sp3,#sp4").click(
			    	     function()
			    	     {
			    	      for(i=0;i<employees.length;i++)
			    	      {
			    	        sp[i]=0;
			    	      var a="#id"+employees[i].productId;

			    	      $(a).css("display", "none");
			    	      
			    	      if($("#sp1").prop("checked") == true &&  employees[i].price<500)
			    	      {
			    	             sp[i]=1;
			    	       }
			    	      if($("#sp2").prop("checked") == true &&  employees[i].price>500 &&  employees[i].price < 1000 )
			    	      {
			    	              sp[i]=1;
			    	       }
			    	      if($("#sp3").prop("checked") == true &&  employees[i].price<2999 && employees[i].price>999)
			    	      {
			    	              sp[i]=1;
			    	       }
			    	      if($("#sp4").prop("checked") == true &&  employees[i].price>3000)
			    	      {
			    	              sp[i]=1;
			    	       }
			    	      }

			    	      if($("#sp1").prop("checked") == false && $("#sp2").prop("checked") == false)
			    	       {
			    	       if($("#sp3").prop("checked") == false && $("#sp4").prop("checked") == false)
			    	        {
			    	            for(i=0;i<employees.length;i++)
			    	            {
			    	              sp[i]=1; 
			    	            }
			    	         }
			    	       }
			    	       myfunc();
			    	     });


			    	$("#sb1,#sb2,#sb3,#sb4").click(
			    	     function()
			    	     {
			    	      for(i=0;i<employees.length;i++)
			    	      {
			    	      var a="#id"+employees[i].productId;
			    	       $(a).css("display", "none");
			    	        sb[i]=0;
			    	      
			    	      if($("#sb1").prop("checked") == true &&  employees[i].brand=="Adidas")
			    	      {
			    	        sb[i]=1;
			    	       }
			    	      if($("#sb2").prop("checked") == true &&  employees[i].brand=="Nike")
			    	      {
			    	        sb[i]=1;
			    	       }
			    	      if($("#sb3").prop("checked") == true &&  employees[i].brand=="Wilson")
			    	      {
			    	        sb[i]=1;
			    	       }
			    	      if($("#sb4").prop("checked") == true &&  employees[i].brand=="Puma")
			    	      {
			    	        sb[i]=1;
			    	       }
			    	      }

			    	      if($("#sb1").prop("checked") == false && $("#sb2").prop("checked") == false)
			    	       {
			    	       if($("#sb3").prop("checked") == false && $("#sb4").prop("checked") == false)
			    	        {
			    	            for(i=0;i<employees.length;i++)
			    	            {
			    	                sb[i]=1; 
			    	            }
			    	         }
			    	       }
			    	      
			    	    myfunc();
			    	  });
			    	function myfunc() {
			    	    for(i=0;i<employees.length;i++)
			    	    {
			    	      if (sp[i]+sb[i]==2) {
			    	        var a="#id"+employees[i].productId;
			    	        $(a).css("display", "inline-block");
			    	         }


			    	    }
			    	}
			});
	  });
