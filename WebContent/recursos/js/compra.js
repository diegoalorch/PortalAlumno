var producto;
var contador = 0;
$("#new").click(function() {
	alert("HOLA")
});

$("#add").click(function() {
	contador++;
	$("#aumentartabla").append('<tr id="fila1"><th scope="row">' + contador + 
			'</th><td>' + producto['descripcion'] + '</td><td>' + 
			producto['presentacion'] + '</td><td><input type="text" class="form-control cantidad" id="cantidad' + contador + '"></td><td>' + 
			producto['precio'] + '</td><td id="importe">' + producto['precio']*$("#cantidad") + 
			'</td><td><button class="btn btn-danger" onclick="eliminar()" id="delete" style="text-aling: center"><i class="far fa-trash-alt"></i></button></td></tr>');

});

function eliminar() {
	$("#fila1").remove();
}

/*$(".cantidad").keyup(function() {
	$(".cantidad").each(function(index) {
		console.log(index);
		$("#importe").replace(' ' + $(this).val())
	});
});*/

$("#register").click(function() {
	alert("HOLA")
});

$("#producto").keyup(function() {
	var op = 1;
	var codigo = $("#producto").val();
	$.get("/SistemaDeVentas/con",{"op":op, "codigo":codigo}, function(data) {
		//No debo olvidarme parsear "parse" el json
		producto =JSON.parse(data);
		$("#presentacion2").val(producto['presentacion']);
		$("#descripcion").val(producto['descripcion']);
		$("#precio").val(producto['precio']);
	});
});