package pe.edu.upeu.portal.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.portal.Dao.AlumnoDao;
import pe.edu.upeu.portal.entity.Alumno;
import pe.edu.upeu.portal.utils.Conexion;

public class AlumnoDaoImp implements AlumnoDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexion;
	
	@Override
	public int createstudent(Alumno alumno) {
		// TODO Auto-generated method stub
		
		int x = 0;
		try {
			conexion = Conexion.getConex();
			ps = conexion.prepareStatement("INSERT INTO alumno (idescuela, apellidonombres, correo, telefono) VALUES (?, ?, ?, ?);");
			ps.setInt(1, alumno.getIdescuela());
			ps.setString(2, alumno.getApellidonombres());
			ps.setString(3, alumno.getCorreo());
			ps.setString(4, alumno.getTelefono());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Alumno findstudent(int idalumno) {
		// TODO Auto-generated method stub
		
		Alumno alumno = new Alumno();
		try {
			conexion = Conexion.getConex();
			ps = conexion.prepareStatement("SELECT * FROM alumno where idalumno = ?");
			ps.setInt(1, idalumno);
			rs = ps.executeQuery();
			rs.next();
			alumno.setIdalumno(rs.getInt("idalumno"));
			alumno.setIdescuela(rs.getInt("idescuela"));
			alumno.setApellidonombres(rs.getString("apellidonombres"));
			alumno.setCorreo(rs.getString("correo"));
			alumno.setTelefono(rs.getString("telefono"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return alumno;
	}

	@Override
	public List<Alumno> readstudent() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			conexion = Conexion.getConex();
			ps = conexion.prepareStatement("SELECT e.idescuela, nombreescuela, idalumno, apellidonombres, correo, telefono FROM escuela e, alumno a where e.idescuela = a.idescuela;");
			rs = ps.executeQuery();
			while (rs.next()) {
				
				Alumno alumno = new Alumno();
				
				alumno.setIdalumno(rs.getInt("idalumno"));
				alumno.setIdescuela(rs.getInt("idescuela"));
				alumno.setApellidonombres(rs.getString("apellidonombres"));
				alumno.setCorreo(rs.getString("correo"));
				alumno.setTelefono(rs.getString("telefono"));
				alumno.setNombreescuela(rs.getString("nombreescuela"));
				alumnos.add(alumno);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return alumnos;
	}

	@Override
	public int updatestudent(Alumno alumno) {
		// TODO Auto-generated method stub
		
		int a = 0;
		try {
			conexion = Conexion.getConex();
			ps = conexion.prepareStatement("UPDATE alumno SET idescuela = ?, apellidonombres = ?, correo = ?, telefono = ? WHERE (idalumno = ?)");
			ps.setInt(1, alumno.getIdescuela());
			ps.setString(2, alumno.getApellidonombres());
			ps.setString(3, alumno.getCorreo());
			ps.setString(4, alumno.getTelefono());
			ps.setInt(5, alumno.getIdalumno());
			a = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return a;
	}

	@Override
	public int deletestudent(int idalumno) {
		// TODO Auto-generated method stub
		int d = 0;
		try {
			conexion = Conexion.getConex();
			ps = conexion.prepareStatement("DELETE FROM alumno WHERE (idalumno = ?);");
			ps.setInt(1, idalumno);
			d = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return d;
	}

}
