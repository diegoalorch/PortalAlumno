package pe.edu.upeu.portal.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.portal.Dao.EscuelaDao;
import pe.edu.upeu.portal.entity.Escuela;
import pe.edu.upeu.portal.utils.Conexion;

public class EscuelaDaoImp implements EscuelaDao {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexion;
	
	@Override
	public int createschool(Escuela escuela) {
		// TODO Auto-generated method stub
		int x = 0;
		try {
			conexion = Conexion.getConex();
			ps = conexion.prepareStatement("INSERT INTO escuela (nombreescuela) VALUES (?);");
			ps.setString(1, escuela.getNombreescuela());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return x;
	}

	@Override
	public List<Escuela> listarescuelas() {
		// TODO Auto-generated method stub
		List<Escuela> escuelas = new ArrayList<Escuela>();
		try {
			conexion = Conexion.getConex();
			ps = conexion.prepareStatement("SELECT * FROM escuela");
			rs = ps.executeQuery();
			while (rs.next()) {
				Escuela escuela = new Escuela();
				escuela.setNombreescuela(rs.getString("nombreescuela"));
				escuelas.add(escuela);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return escuelas;
	}
}