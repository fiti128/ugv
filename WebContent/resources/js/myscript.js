
jQuery(document).ready(function() {
	 jQuery("#loading").hide();
	 jQuery("#loading").bind("ajaxSend", function() {
		    jQuery(this).show();
	    }).bind("ajaxComplete", function() {
	    	jQuery(this).hide();
	    });
 });


//jQuery("#loading").ajaxStart(function(){
//	jQuery(this).show();
// })
// .ajaxStop(function(){
//	 jQuery(this).hide(); })
	 ;

var heyho = function() {
	alert("heyho");
};
