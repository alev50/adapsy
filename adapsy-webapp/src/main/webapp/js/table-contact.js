$(document).ready(function(){
	contactIndex = $('.table-contact .select-contact li.selected').index();
	showContact(contactIndex, 0);

	$('.table-contact .select-contact li').on('click', function(){
		if(!$(this).hasClass('selected')){
			$(this).parent().find('.selected').removeClass('selected');
			$(this).addClass('selected');
			contactIndex = $('.table-contact .select-contact li.selected').index();
			showContact(contactIndex, 500);
		}
	});
});

function showContact(indexEl, speed){
	if(indexEl === 1){
		$('.table-contact .array .annonceur').addClass('open');
		$('.table-contact .array .agence').removeClass('open').attr('style','');
		$('.table-contact .array .other').removeClass('open').attr('style','');
		$('.table-contact .array .annonceur').animate({opacity:1},speed);
	}else if(indexEl === 2){
		$('.table-contact .array .agence').addClass('open');
		$('.table-contact .array .annonceur').removeClass('open').attr('style','');
		$('.table-contact .array .other').removeClass('open').attr('style','');
		$('.table-contact .array .open').animate({opacity:1},speed);
	}else if(indexEl === 3){
		$('.table-contact .array .other').addClass('open');
		$('.table-contact .array .annonceur').removeClass('open').attr('style','');
		$('.table-contact .array .agence').removeClass('open').attr('style','');
		$('.table-contact .array .other').animate({opacity:1},speed);
	}else{
		$('.table-contact .array .annonceur, .table-contact .array .agence, .table-contact .array .other').addClass('open');
		$('.table-contact .array .annonceur, .table-contact .array .agence, .table-contact .array .other').animate({opacity:1},speed);
	}

	var lengthOpen = $('.table-contact .array .annonceur.open, .table-contact .array .agence.open, .table-contact .array .other.open').length;

	$('.table-contact .array tr.if-empty').removeClass('open')
	if (lengthOpen < 5) {
		nbrEmpty = 5 - lengthOpen;
		for (var i = 0; i<=nbrEmpty ; i++ ){
			$('.table-contact .array tr.if-empty').eq(i).addClass('open');
		};
	}
}