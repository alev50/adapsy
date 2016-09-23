$(document).ready(function(){
	$('#nav-aside .nav>ul>li').on('click',function(){

			if (!$(this).hasClass('open')) {
				$('#nav-aside .nav>ul>li.open').each(function(){
					$(this).animate({height: 50}, 200, function(){
						$(this).removeClass('open');
					});
				})
				realheight = $(this).find('ul').outerHeight();
				if(realheight>0){
					realheight = realheight-10;
				}
				$(this).animate({height: realheight+50}, 300, function(){
				});
				$(this).addClass('open');
			}
	});
});