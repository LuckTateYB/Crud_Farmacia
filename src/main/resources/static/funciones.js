function eliminar(id) {
	swal({
		title: "¿Estas seguro de eliminar?",
		text: "¡Una vez eliminado, no podrás recuperar este registro!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	}).then((OK) => {
			if (OK) {
				
				//funcion de Jquery
				$.ajax({
					url:"/eliminar/"+id,
					success: function(res){
						console.log(res);
					}
				});
				
				swal("¡El registro fue eliminado, correctamente", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/listar";
					}
				});
				
			} else {
				swal("¡El registro está a salvo!");
			}
		});
}