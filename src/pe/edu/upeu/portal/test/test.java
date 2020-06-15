package pe.edu.upeu.portal.test;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.portal.Dao.AlumnoDao;
import pe.edu.upeu.portal.Dao.EscuelaDao;
import pe.edu.upeu.portal.DaoImp.AlumnoDaoImp;
import pe.edu.upeu.portal.DaoImp.EscuelaDaoImp;
import pe.edu.upeu.portal.entity.Alumno;
import pe.edu.upeu.portal.entity.Escuela;
import pe.edu.upeu.portal.utils.Conexion;

public class test {
	
	static EscuelaDao escuelaDao = new EscuelaDaoImp();
	static AlumnoDao alumnoDao = new AlumnoDaoImp();
	
	static void crearescuela() {
		
		Escuela escuela = new Escuela(3, "Civil");
		int e = escuelaDao.createschool(escuela);
		if (e > 0) {
			System.out.println("Escuela Creada");
		} else {
			System.out.println("Creación de Escuela Fallida");
		}
		
	}
	
	static void conex() {
		  if(Conexion.getConex()!=null) {
			  System.out.println("Conectado");
		  }else {
			 System.out.println("Desconectado"); 
		  }	  
	  }
	
	static void crearalumno() {
		
		Alumno alumno = new Alumno(0, 1, "Nick Meza", "nickmeza@upeu.edu.pe", "987654321");
		int x = alumnoDao.createstudent(alumno);
		if (x > 0) {
			System.out.println("Alumno Creado");
		} else {
			System.out.println("Alumno No Creado");
		}
	}
	
	static void listaralumno() {
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = alumnoDao.readstudent();
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getApellidonombres());
		}
	}
	
	static void buscaralumno() {
		
		Alumno alumno = new Alumno();
		alumno= alumnoDao.findstudent(3);
		System.out.println(alumno.getApellidonombres());
	}
	
	static void eliminaralumno() {
		
		int i = alumnoDao.deletestudent(25);
		if (i > 0) {
			System.out.println("Alumno Eliminado");
		} else {
			System.out.println("Alumno No Eliminado");
		}
	}
	
	static void modificaralumno() {
		
		Alumno alumno = new Alumno(3, 1, "Carlos Meza", "nickmeza@upeu.edu.pe", "987654321");
		int x = alumnoDao.updatestudent(alumno);
		if (x > 0) {
			System.out.println("Alumno Modificado");
		} else {
			System.out.println("Alumno No Modificado");
		}
	}
	
	public static void main(String[] args) {
		
		//crearescuela();
		//conex();
		//crearalumno();
		//listaralumno();
		//modificaralumno();
		//buscaralumno();
		eliminaralumno();
	}	
}
