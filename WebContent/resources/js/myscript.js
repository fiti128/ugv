var heyho = function() {
	alert("heyho");
};
var builtInAjaxRequestFunction = Primefaces.ajax.AjaxRequest;
Primefaces.ajax.AjaxRequestt = function(cfg) {
	alert("hello");
	builtInAjaxRequestFunction(cfg);
	alert("bye");
};
jsf.ajax.addOnEvent(function(data) {
	var ajaxstatus = data.status;
	var ajaxloader = document.getElementById("loading");
	alert("Hey");
	
    switch (ajaxstatus) {
    case "begin": 
    	alert("begin");
        break;

    case "complete": // This is called right after ajax response is received.

        break;

    case "success": // This is called when ajax response is successfully processed.
        // NOOP.
        break;
}
});