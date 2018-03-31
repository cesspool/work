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
	
	init: function() {
		var btnAdd = document.getElementById('btnAdd');
		var btnRemove = document.getElementById('btnRemove');
		btnAdd.onclick = this.addCity;
		btnRemove.onclick = this.removeCity;
	}
 };
 
 window.onload=js.init();