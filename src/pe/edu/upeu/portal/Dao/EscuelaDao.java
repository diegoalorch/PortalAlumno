package pe.edu.upeu.portal.Dao;

import java.util.List;

import pe.edu.upeu.portal.entity.Escuela;

public interface EscuelaDao {

	int createschool(Escuela escuela);
	List<Escuela> listarescuelas();
}
