//Animations
// new WOW().init();

//Preload Animations
$(window).load(function() {
  $("body").removeClass("preload");
});


//Popover
$(function () {
  $('[data-popover="popover"]').popover({ trigger: "hover", html: "true" });
});

//Outdated Browsers
$(function() {
  outdatedBrowser({
    bgColor: '#f25648',
    color: '#ffffff',
    lowerThan: 'borderImage' //IE11
  });
});

//Nav Dropdown
$(function () {
  $(".nav-dropdown-toggle").on("click", function(e) {
    e.preventDefault();
    $(this).siblings('.nav-dropdown-menu').slideToggle(100);
    $(this).toggleClass('nav-show');
    $(this).closest('.nav-dropdown').toggleClass('nav-show');
  }); 
});

//Nav toggle
$(function () {
  $("#nav-toggle").on("click", function(e) {
    e.preventDefault();
    $('#sidenav, #nav-toggle, #header, #main-content').toggleClass('open');
  }); 
});

//RWD Table
$(function() {
  $(".table-wrap").each(function() {
    var nmtTable = $(this);
    var nmtHeadRow = nmtTable.find("thead tr");
    nmtTable.find("tbody tr").each(function() {
      var curRow = $(this);
      for (var i = 0; i < curRow.find("td").length; i++) {
        var rowSelector = "td:eq(" + i + ")";
        var headSelector = "th:eq(" + i + ")";
        curRow.find(rowSelector).attr('data-title', nmtHeadRow.find(headSelector).text());
      }
    });
  });
});

//Tooltip
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
});

//Search Form
$(function(){
  $('.search-form .form-control').focusout(function(){
    var text_val = $(this).val();
    if(text_val === "") {
      $(this).removeClass('has-value');
    } else {
      $(this).addClass('has-value');
    }
  });
});

//Address Edit
(function($) {
  $.fn.toggleDisabled = function() {
    return this.each(function() {
      var $this = $(this);
      if ($this.attr('disabled')) $this.removeAttr('disabled');
      else $this.attr('disabled', 'disabled');
    });
  };
})(jQuery);
$(function(){
  $('.address-item .action-btns .edit').on('click', function(e) {
    e.preventDefault();
    $(this).closest('.address-item').find('.address-form').toggleClass('active');
    $(this).closest('.address-item').find('.form-stripped').toggleDisabled();
    $(this).closest('.address-item').find('.select-stripped select').toggleDisabled();
    $(this).closest('.address-item').find('.save-cancel-btns').fadeToggle();
  });
  $('.address-item .btn-cancel').on('click', function(e) {
    e.preventDefault();
    $(this).closest('.address-item').find('.address-form').toggleClass('active');
    $(this).closest('.address-item').find('.form-stripped').toggleDisabled();
    $(this).closest('.address-item').find('.select-stripped select').toggleDisabled();
    $(this).closest('.address-item').find('.save-cancel-btns').fadeToggle();
  });
});
//New address
$(function(){
  $('.new-address-btn').on('click', function(e) {
    e.preventDefault();
    $(this).closest('.new-address').addClass('active');
    $(this).hide();
    $(this).closest('.new-address').find('.btn-cancel').on('click', function(e) {
      e.preventDefault();
      $(this).closest('.new-address').removeClass('active');
      $(this).closest('.new-address').find('.new-address-btn').show();
    });
  });
});


/*
 * Replace all SVG images with inline SVG
 */
jQuery('img.svg').each(function(){
  var $img = jQuery(this);
  var imgID = $img.attr('id');
  var imgClass = $img.attr('class');
  var imgURL = $img.attr('src');

  jQuery.get(imgURL, function(data) {
      // Get the SVG tag, ignore the rest
      var $svg = jQuery(data).find('svg');

      // Add replaced image's ID to the new SVG
      if(typeof imgID !== 'undefined') {
          $svg = $svg.attr('id', imgID);
      }
      // Add replaced image's classes to the new SVG
      if(typeof imgClass !== 'undefined') {
          $svg = $svg.attr('class', imgClass+' replaced-svg');
      }

      // Remove any invalid XML tags as per http://validator.w3.org
      $svg = $svg.removeAttr('xmlns:a');

      // Check if the viewport is set, if the viewport is not set the SVG wont't scale.
      if(!$svg.attr('viewBox') && $svg.attr('height') && $svg.attr('width')) {
          $svg.attr('viewBox', '0 0 ' + $svg.attr('height') + ' ' + $svg.attr('width'))
      }

      // Replace image with new SVG
      $img.replaceWith($svg);

  }, 'xml');
});