var exhibiterIDs = [];
$("document").ready(function(){
	$("#deleteExhibiter").click(function(){
		$("#listExhibiter").find("tr").each(function(){
			var row = $(this);
			var check= row.find('input[type="checkbox"]').is(':checked');
			if(check){
				var id = row.find('input[type="checkbox"]').val();
				exhibiterIDs.push(id);
			}
		});
		if(exhibiterIDs.length !== 0){
			deleteExhibiter(exhibiterIDs.toString());
		}else{
			alert("Vous devez sélectionner des entreprises avant de les supprimés");
		}
	});
});

function deleteExhibiter(id){
	var r = confirm("Vous étes sûr de vouloir supprimer cet(s) éxposant(s) ?");
	if(r === true){
		$.ajax({
			url: '/deleteExhibiter',
			contentType: "application/json",
			method: 'POST',
			dataType: 'json',
			data :JSON.stringify(id),
			success: function (result) {
                if(result === "error"){
                    getMsg("Une érreur est apparue, refaire a nouveau.");
                }else{s
                    getMsg("Suppréssion éfféctuée avec succées.");
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
                msg = "Suppréssion éfféctuée avec succées.";
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