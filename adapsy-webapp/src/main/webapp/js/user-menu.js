$(document).ready(function(){
	$('li .user').on('click', function(){

		if($(this).parent().hasClass('open')){
			$(this).parent().removeClass('open');
		}
		else{
			$(this).parent().addClass('open');
		}
	});
})