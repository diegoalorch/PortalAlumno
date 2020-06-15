package pe.edu.upeu.portal.Dao;

import java.util.List;

import pe.edu.upeu.portal.entity.Alumno;

public interface AlumnoDao {
	
	int createstudent(Alumno alumno);
	Alumno findstudent(int idalumno);
	List<Alumno> readstudent();
	int updatestudent(Alumno alumno);
	int deletestudent(int idalumno);
}
