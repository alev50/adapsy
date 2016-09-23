$(document).ready(function(){
	$('.help-top').parent().each(function(){
		var helpEl = $(this).find('.help-top');
		var margin = helpEl.outerWidth()/2;
		helpEl.css('margin-left', -margin+"px");
	})
	$('.help-right').parent().each(function(){
		var helpEl = $(this).find('.help-top');
		var margin = helpEl.outerWidth()/2;
		helpEl.css('margin-left', -margin+"px");
	})
});