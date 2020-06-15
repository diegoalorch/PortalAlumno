var contador = 0;
$(document).ready(function() {
	listaralumnos();
	listarescuelas();
});

$("#enviar").click(function() {
	var escuela = $("#school").val();
	var nombre = $("#name").val();
	var correo = $("#correo").val();
	var telefono = $("#telefono").val();
	$.get("ac", {op:4, "idescuela":escuela, "apellidonombres":nombre, "correo": correo, "telefono":telefono}, function() {
		$("#school").val("");
		$("#name").val("");
		$("#correo").val("");
		$("#telefono").val("");
		listaralumnos();
		
	})
});

function listaralumnos() {
	$.get("ac", {"op": 2}, function(data) {
		alumnos = JSON.parse(data);
		for (var i = 0; i < alumnos.length; i++) {
			contador++;
			var array = alumnos[i];
			console.log(array);
			$("#tabla").append('<tr id="fila1"><th scope="row">' + contador + 
					'</th><td>' + array["nombreescuela"] + '</td><td>' + array["apellidonombres"] + 
					'</td><td>' + array["correo"] + '</td><td>' + array["telefono"] + 
					'<td><button class="btn btn-primary" onclick="update('+ array["idalumno"] +')" id="update"><i class="fas fa-pencil-alt"></i></button><button class="btn btn-danger" onclick="remove('+ array["idalumno"] +')" id="remove"><i class="fas fa-user-times"></i></button></td>');
		}
	});
}

function remove(id) {
	console.log(id)
	$.post("ac", {"op":3, "idalumno": id}, function() {
		$("#fila1").remove();
	});
}

function update(idalumno) {
	$.get("ac", {"op":1, "idalumno":idalumno}, function(data) {
		alumno = JSON.parse(data);
		$("#school").val("1");
		$("#name").val(alumno["apellidonombres"]);
		$("#correo").val(alumno["correo"]);
		$("#telefono").val(alumno["telefono"]);
	});
}

function listarescuelas() {
	$.get("ac", {"op":3}, function(data) {
		escuelas = JSON.parse(data);
		for (var i = 0; i < escuelas.length; i++) {
			var element = escuelas[i];
			$("#school").append('<option value="' + element["idescuela"] + '">'
			+ element["nombreescuela"] + '</option>');
			
		}
	});
}