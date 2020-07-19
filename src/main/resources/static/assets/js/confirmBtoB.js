var BtoBIDs = [];
$("document").ready(function(){
	$("#confirmbtob").click(function(){
		$("#listBtoB").find("tr").each(function(){
			var row = $(this);
			var check= row.find('input[type="checkbox"]').is(':checked');
			if(check){
				var id = row.find('input[type="checkbox"]').val();
				BtoBIDs.push(id);
			}
		});
		if(BtoBIDs.length !== 0){
			confirmBtoB(BtoBIDs.toString());
		}else{
			alert("Vous devez sélectionner des entreprises avant de les confirmées");
		}
	});
});

function confirmBtoB(id){
	var r = confirm("Vous étes sûr de vouloir confirmer cette(ces) entreprise(s) ?");
	if(r === true){
		$.ajax({
			url: '/confirmBtoB',
			contentType: "application/json",
			method: 'POST',
			dataType: 'json',
			data :JSON.stringify(id),
			success: function (result) {
                if(result === "error"){
                    getMsg("Une érreur est apparue, refaire a nouveau.");
                }else if(result === "errorall"){
                	getMsg("Une érreur est apparue lors de la confirmation des entreprises. La confirmation a été éfféctuée partielement");
                }else{
                    getMsg("Confirmation éfféctuée avec succées.");
                	location.reload(true);
                }
            },
            error : function(jqXHR, exception){
                var msg = '';
            if (jqXHR.status === 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status === 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status === 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = "Confirmation éfféctuée avec succées.";
                location.reload(true);
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            getMsg(msg);
            }
		});
		return false;
	}else{
		
	}
}

function getMsg(message){
    alert(message);
}