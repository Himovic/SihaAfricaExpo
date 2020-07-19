var valuesStands = [];

$('td').click(function() {
	if($(this).text() === "00"){
	   alert("Vous ne pouvez pas réserver cette espace.");
   }else if($(this).text()==="18" || $(this).text()==="21"){
	   $("#samea").css('backgroundColor', '#FFAB40');
	   $("#sameb").css('backgroundColor', '#FFAB40');
	   valuesStands.push("18");
	   valuesStands.push("21");
   }else if($(this).text()==="17" || $(this).text()==="20"){
	   $("#samec").css('backgroundColor', '#FFAB40');
	   $("#samed").css('backgroundColor', '#FFAB40');
	   valuesStands.push("17");
	   valuesStands.push("20");
   }else if($(this).text()==="19" || $(this).text()==="22"){
	   $("#samee").css('backgroundColor', '#FFAB40');
	   $("#samef").css('backgroundColor', '#FFAB40');
	   valuesStands.push("19");
	   valuesStands.push("22");
   }else{
	 if ($(this).css('background-color')=="rgb(221, 44, 0)") {
		alert("Ce stand est déja résérvé");
	 }else{
		$(this).css('backgroundColor', '#FFAB40');
		valuesStands.push($(this).text());
	 }
   }
});
$('td').dblclick(function(){
	if($(this).text()==18 || $(this).text()==21){
		valuesStands = arrayRemove(valuesStands,"18");
		valuesStands = arrayRemove(valuesStands,"21");
		$("#samea").css('backgroundColor', '#fff');
		$("#sameb").css('backgroundColor', '#fff');
	}else if($(this).text()==17 || $(this).text()==20){
		valuesStands = arrayRemove(valuesStands,"17");
		valuesStands = arrayRemove(valuesStands,"20");
		$("#samec").css('backgroundColor', '#fff');
		$("#samed").css('backgroundColor', '#fff');
	}else if($(this).text()==19 || $(this).text()==22){
		valuesStands = arrayRemove(valuesStands,"19");
		valuesStands = arrayRemove(valuesStands,"22");
		$("#samee").css('backgroundColor', '#fff');
		$("#samef").css('backgroundColor', '#fff');
	}else{
		$(this).css('backgroundColor', '#fff');
		valuesStands = arrayRemove(valuesStands,$(this).text());
	}
});
$('#confirmStand').click(function(){
	if(valuesStands.toString().length === 0){
		alert("Aucun stand n'a été choisi. Vous devez choisir le(s) numéro(s) de(s) stand(s) avant de confirmer");
	}else{
		var r = confirm("Vous étes sûr de vouloir choisir ce(s) stand(s) ?");
		if(r === true){
			window.location = '/exhibitorRegistration/stand='+valuesStands.toString();
		}else{
			
		}
	}
});

function arrayRemove(arr, value) {

	   return arr.filter(function(ele){
	       return ele != value;
	   });
}