var js = {
		
		changeLang: function() {
			 var sel = document.getElementById('selLangID');
			 var currentUrl = window.location.href;
			 var lang = sel.options[sel.selectedIndex].value;
			 var langPos = currentUrl.indexOf("lang=");
			 if (langPos > 0) {
			   	var urlPart = currentUrl.substring(0, langPos);
			   	window.location=urlPart + "lang=" + lang;
			 } else {
		       window.location=window.location.href + "?lang=" + lang;
			 }
		},
		
		
		readCookie: function(name) {
		    var reExp = new RegExp(name + "=([^;]+)");
		    var value = reExp.exec(document.cookie);
		    return (value != null) ? unescape(value[1]) : null;
		},
		
		
		init: function() {
			var sel = document.getElementById('selLangID');
			var currentLocale = this.readCookie("locale");
			sel.value = currentLocale;
			sel.onchange=this.changeLang;
		}
};

window.onload = js.init();