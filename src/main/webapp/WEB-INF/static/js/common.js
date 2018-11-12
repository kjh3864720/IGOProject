//  공통 JS
/////////// search Ico  /////////////
 function searchToggle(obj, evt){
            var container = $(obj).closest('.search-wrapper');

            if(!container.hasClass('active')){
                  container.addClass('active');
                  evt.preventDefault();
            }
            else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
                  container.removeClass('active');
                  // clear input
                  container.find('.search-input').val('');
                  // clear and hide result container when we press close
                  container.find('.result-container').fadeOut(100, function(){$(this).empty();});
            }
        }

       


////////////////////////////////////////////////////////////////////////







///////////// 전역 변수 구역	/////////////////////////////////


var snum=0;

	$().ready(function() {
		var tsts=0;			
		$('#ham').on('click', function() {
			var navi=$("#navM");		
			if(tsts===0){					
				navi.show(300);		
				
				$(this).removeClass('ion-ios-menu').html("<span class='mClose'></span>");				
				$('.mClose').css("transform", "rotate(45deg)");
				$('.mClose').css("transition", "all .6s cubic-bezier(0.000, 0.105, 0.035, 1.570)");
				$('.mClose').css("transition-delay", "0.5s");				
					
				tsts=1;
			}
			else if(tsts===1){		
				navi.hide(300);
				$(this).html("").addClass("ion-ios-menu");
				tsts=0;
			}
		});
		
		$("#navM ul.sub").hide();
		$("#navM ul.active li").click(function(){
			$("ul",this).slideToggle("fast");
		});
		
        
        $(function() {
            $("#top_btn").on("click", function() {
                $("html, body").animate({scrollTop:0}, '500');
                return false;
            });
        });
        	
	})
		
	
	



	