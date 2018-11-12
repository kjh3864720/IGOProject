
////////// html 로딩후 실행구역 ////////////////
window.addEventListener("load",function(){	
	
	$(document).ready(function(){
		$("#searchBox ul.sub").hide();
		$("#searchBox ul.active li").click(function(){
			$("ul",this).slideToggle("fast");
		});
	});		
			
			
	
		
		});///////////// load구역 ////////////////////////////////






