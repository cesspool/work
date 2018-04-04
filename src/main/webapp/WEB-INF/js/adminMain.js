 var js = {
		 
	addCity: function(){
		var allSel = js.getAllCitiesSelector();
		var chosenSel = js.getChosenCitiesSelector();
		var selOption = allSel.item(allSel.selectedIndex);
		if(selOption) {
			allSel.removeChild(selOption);
			chosenSel.appendChild(selOption.cloneNode(true));
		}
	},
	
	removeCity: function() {
		var allSel = js.getAllCitiesSelector();
		var chosenSel = js.getChosenCitiesSelector();
		var selOption = chosenSel.item(chosenSel.selectedIndex);
		if(selOption) {
			chosenSel.removeChild(selOption);
			allSel.appendChild(selOption.cloneNode(true));
		}
	},

	getAllCitiesSelector: function(){
		return document.getElementById('allCities');
	},
	
	getChosenCitiesSelector: function() {
		return document.getElementById('chosenCities');
	},
	
	doSubmit: function() {
		var ids = '';
		var form = document.getElementById('newNodeForm');
		var hdnFld = document.getElementById('selectedCities');
		var selr = document.getElementById('chosenCities');
		if(selr.options.length == 0) {
			alert("No one city was selected");
			return false;
		}
		for(i = 0; i < selr.options.length; i++) {
			ids = ids + (ids.length == 0 ? '':',') + selr.options[i].value;
		}
		hdnFld.value = ids;
		form.submit();
	},
	
	
	init: function() {
		var btnAdd = document.getElementById('btnAdd');
		var btnRemove = document.getElementById('btnRemove');
		var form = document.getElementById('newNodeForm');
		btnAdd.onclick = this.addCity;
		btnRemove.onclick = this.removeCity;
		form.onsubmit = this.doSubmit;
	}
 };
 
 window.onload=js.init();