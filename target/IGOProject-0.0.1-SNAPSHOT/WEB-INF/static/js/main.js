//  메인페이지 JS

$(function(){
	
   var swiper = new Swiper('.swiper-container', {
      slidesPerView: 1,
//      spaceBetween: 30,
//      loop: true,
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });	
	
	
 
	
	
	
	
	$(".bulletBox>a").click(function(){
		var idx=$(this).index();
		swiper.slideTo(idx);
		
		$(".bulletBox>a").removeClass("active").css("color", "#fff");
		$(this).addClass("active").css("color", "#1eb4cf");
		
		
		
		
	});////// click ////////////////
	
	$(".abtn").click(function(){
		var idx=$(this).index(".abtn");

		if(idx===0){
			swiper.slidePrev();
		}
		else{
			swiper.slideNext();
		}

	});////// click ////////////////	
	

 
	
});//////// jQB //////////////////////////////








//// html 로딩 후 실행구역 ///////
window.addEventListener("load",function(){
	
///////// search Tab  /////////////	
	$(function () {
	$(".tab_content").hide();
	$(".tab_content:first").show();

	$("ul.tabs li").click(function () {
		$("ul.tabs li").removeClass("active").css("color", "#333");
		$(this).addClass("active").css("color", "#7accc8");
		
		$(".tab_content").hide()
		var activeTab = $(this).attr("data-link");
		$("#" + activeTab).fadeIn()
	});
});
	
	
	
	
		
});//////// click /////////////////















