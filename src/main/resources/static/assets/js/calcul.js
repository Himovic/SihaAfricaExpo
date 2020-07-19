var registrationPrice = 10000;
var oneFacade = 9900;
var twoFacade = 11900;

var lunchBoxPrice = 2000;
var pubMiniPagePrice = 10000;
var pubOnePagePrice = 20000;
var pubDoublePagePrice = 40000;
var chairPrice = 1000;
var tablePrice = 1500;
var deskPrice = 2000;

var totalSupp = 0;
var totalPrice = 0;
var numberStands = 0;

var totalLunchbox = 0;
var totalPubOnePage = 0;
var totalPubDoublePage = 0;
var totalChairs = 0;
var totalTables = 0;
var totalDesks = 0;

$(document).ready(function(){
	$("#submit").attr("disabled", "disabled");
	$("#optionPayment").hide();
	$("#calcul").click(function(){
		var nbrLunchbox = $("#nbrLunchbox").val();
		var nbrPubMiniPage = $("#nbrPubMiniPage").val();
		var nbrPubOnePage = $("#nbrPubOnePage").val();
		var nbrPubDoublePage = $("#nbrPubDoublePage").val();
		var nbrChair = $("#nbrChair").val();
		var nbrTable = $("#nbrTable").val();
		var nbrDesk = $("#nbrDesk").val();
		if(nbrLunchbox < 0 || nbrLunchbox == null){
			alert("Le nombre des lunch boxes supplémentaires ne doit pas étre négative oû sans valeur - Valeur par défaut 0");
		}else if(nbrPubMiniPage < 0 || nbrPubMiniPage == null){
			alert("Le nombre de(s) la(les) publicité(s) sur 1/2 page en couleur a ajouter ne doit pas étre négative oû sans valeur - Valeur par défaut 0");
		}else if(nbrPubOnePage < 0 || nbrPubOnePage == null){
			alert("Le nombre de(s) la(les) publicité(s) sur une page en couleur ne doit pas étre négative oû sans valeur - Valeur par défaut 0");
		}else if(nbrPubDoublePage < 0 || nbrPubDoublePage == null){
			alert("Le nombre de(s) la(les) publicité(s) sur une double page en couleur ne doit pas étre négative oû sans valeur - Valeur par défaut 0");
		}else if(nbrChair < 0 || nbrChair == null){
			alert("Le nombre des chaises supplémentaires ne doit pas étre négative oû sans valeur - Valeur par défaut 0");
		}else if(nbrTable < 0 || nbrTable == null){
			alert("Le nombre des tables supplémentaires ne doit pas étre négative oû sans valeur - Valeur par défaut 0");
		}else if(nbrDesk < 0 || nbrDesk == null){
			alert("Le nombre des desks supplémentaires ne doit pas étre négative oû sans valeur - Valeur par défaut 0");
		}else{
			totalSupp = ((lunchBoxPrice * nbrLunchbox) + (pubMiniPagePrice * nbrPubMiniPage)+ (pubOnePagePrice * nbrPubOnePage) + 
					(pubDoublePagePrice * nbrPubDoublePage) + (chairPrice * nbrChair) + (tablePrice * nbrTable) +
					(deskPrice * nbrDesk));
					
					var stands = $("#stands").val();
					numberStands = stands.split(",").length;
					var typeStand = $("#typeStand").val();
					if(typeStand === "Une seule façade"){
						totalPrice = (((oneFacade * 9)* numberStands) + (registrationPrice * numberStands)+totalSupp);
					}else if(typeStand === "Double façades"){
						totalPrice = (((twoFacade * 9)* numberStands) + (registrationPrice * numberStands)+totalSupp);
					}else if((typeStand === "Double façades")&&(numberStands > 1)){
						var numberOneFacadeStand = getOneFacadeStandNumber(stands.split(","));
						var numberTwoFacadeStand = getTwoFacadeStandNumber(stands.split(","));
						var oneFacadeMetters = numberOneFacadeStand * 9;
						var twoFacadeMetters = numberTwoFacadeStand * 9;
						var priceOneFacade = oneFacade * oneFacadeMetters;
						var priceTwoFacade = twoFacade * twoFacadeMetters;
						var regPrice = registrationPrice * numberStands;
						totalPrice = priceOneFacade + priceTwoFacade + regPrice + totalSupp;
					}else if(typeStand === "Une seule façade + double façades"){
						var numberOneFacadeStand = getOneFacadeStandNumber(stands.split(","));
						var numberTwoFacadeStand = getTwoFacadeStandNumber(stands.split(","));
						var oneFacadeMetters = numberOneFacadeStand * 9;
						var twoFacadeMetters = numberTwoFacadeStand * 9;
						var priceOneFacade = oneFacade * oneFacadeMetters;
						var priceTwoFacade = twoFacade * twoFacadeMetters;
						var regPrice = registrationPrice * numberStands;
						totalPrice = priceOneFacade + priceTwoFacade + regPrice + totalSupp;
					}else if(typeStand === "02 fois doubles façades"){
						var numberOneFacadeStand = getOneFacadeStandNumber(stands.split(","));
						var numberTwoFacadeStand = getTwoFacadeStandNumber(stands.split(","))
						var oneFacadeMetters = numberOneFacadeStand * 9;
						var twoFacadeMetters = numberTwoFacadeStand * 9;
						var priceOneFacade = oneFacade * oneFacadeMetters;
						var priceTwoFacade = twoFacade * twoFacadeMetters;
						var regPrice = registrationPrice * numberStands;
						totalPrice = priceOneFacade + priceTwoFacade + regPrice + totalSupp;
					}else{
						
					}
					$("#totalPrice").text(totalPrice+" DA en T.T.C.");
					$("#montant").val(totalPrice);
					$("#submit").removeAttr('disabled');
					$("#optionPayment").show();
					$("#calcul").attr("disabled", "disabled");
					$('html, body').animate({
			            scrollTop: $("#scrollToPrice").offset().top
			        }, 1000);
		}
	});
});


//linking the key-value-pairs is optional
//if no argument is provided, linkItems === undefined, i.e. !== false
//--> linking will be enabled
function Map(linkItems) {
 this.current = undefined;
 this.size = 0;

 if(linkItems === false)
     this.disableLinking();
}

Map.noop = function() {
 return this;
};

Map.illegal = function() {
 throw new Error("illegal operation for maps without linking");
};

//map initialisation from existing object
//doesn't add inherited properties if not explicitly instructed to:
//omitting foreignKeys means foreignKeys === undefined, i.e. == false
//--> inherited properties won't be added
Map.from = function(obj, foreignKeys) {
 var map = new Map;

 for(var prop in obj) {
     if(foreignKeys || obj.hasOwnProperty(prop))
         map.put(prop, obj[prop]);
 }

 return map;
};

Map.prototype.disableLinking = function() {
 this.link = Map.noop;
 this.unlink = Map.noop;
 this.disableLinking = Map.noop;
 this.next = Map.illegal;
 this.key = Map.illegal;
 this.value = Map.illegal;
 this.removeAll = Map.illegal;

 return this;
};

//overwrite in Map instance if necessary
Map.prototype.hash = function(value) {
 return (typeof value) + ' ' + (value instanceof Object ?
     (value.__hash || (value.__hash = ++arguments.callee.current)) :
     value.toString());
};

Map.prototype.hash.current = 0;

//--- mapping functions

Map.prototype.get = function(key) {
 var item = this[this.hash(key)];
 return item === undefined ? undefined : item.value;
};

Map.prototype.put = function(key, value) {
 var hash = this.hash(key);

 if(this[hash] === undefined) {
     var item = { key : key, value : value };
     this[hash] = item;

     this.link(item);
     ++this.size;
 }
 else this[hash].value = value;

 return this;
};

Map.prototype.remove = function(key) {
 var hash = this.hash(key);
 var item = this[hash];

 if(item !== undefined) {
     --this.size;
     this.unlink(item);

     delete this[hash];
 }

 return this;
};

//only works if linked
Map.prototype.removeAll = function() {
 while(this.size)
     this.remove(this.key());

 return this;
};

//--- linked list helper functions

Map.prototype.link = function(item) {
 if(this.size == 0) {
     item.prev = item;
     item.next = item;
     this.current = item;
 }
 else {
     item.prev = this.current.prev;
     item.prev.next = item;
     item.next = this.current;
     this.current.prev = item;
 }
};

Map.prototype.unlink = function(item) {
 if(this.size == 0)
     this.current = undefined;
 else {
     item.prev.next = item.next;
     item.next.prev = item.prev;
     if(item === this.current)
         this.current = item.next;
 }
};

//--- iterator functions - only work if map is linked

Map.prototype.next = function() {
 this.current = this.current.next;
};

Map.prototype.key = function() {
 return this.current.key;
};

Map.prototype.value = function() {
 return this.current.value;
};

var map = new Map(); 
map.put('01','1');map.put('11','1');map.put('21','0');map.put('31','1');map.put('41','2');map.put('51','2');map.put('61','1');map.put('71','1');
map.put('02','2');map.put('12','1');map.put('22','0');map.put('32','2');map.put('42','2');map.put('52','1');map.put('62','2');map.put('72','1');
map.put('03','1');map.put('13','1');map.put('23','2');map.put('33','2');map.put('43','1');map.put('53','2');map.put('63','1');map.put('73','2');
map.put('04','1');map.put('14','1');map.put('24','1');map.put('34','1');map.put('44','2');map.put('54','2');map.put('64','1');map.put('74','1');
map.put('05','1');map.put('15','1');map.put('25','1');map.put('35','2');map.put('45','2');map.put('55','1');map.put('65','1');
map.put('06','1');map.put('16','2');map.put('26','1');map.put('36','2');map.put('46','1');map.put('56','2');map.put('66','2');
map.put('07','1');map.put('17','2');map.put('27','2');map.put('37','1');map.put('47','2');map.put('57','2');map.put('67','2');
map.put('08','2');map.put('18','1');map.put('28','1');map.put('38','2');map.put('48','2');map.put('58','1');map.put('68','1');
map.put('09','2');map.put('19','2');map.put('29','2');map.put('39','2');map.put('49','1');map.put('59','2');map.put('69','1');
map.put('10','1');map.put('20','0');map.put('30','2');map.put('40','1');map.put('50','2');map.put('60','2');map.put('70','1');


function getOneFacadeStandNumber(stand){
	var numberOneFacade = 0; 
	for(var i=0;i<stand.length;i++){
		if(map.get(stand[i]) === "1"){
			numberOneFacade = numberOneFacade + 1;
		}
	}
	return numberOneFacade;
}

function getTwoFacadeStandNumber(stand){
	var numberTwoFacade = 0;
	for(var i=0;i<stand.length;i++){
		if(map.get(stand[i]) === "2"){
			numberTwoFacade = numberTwoFacade + 1;
		}
	}
	return numberTwoFacade;
}