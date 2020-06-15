package pe.edu.upeu.portal.entity;

public class Alumno {
	
	private int idalumno;
	private int idescuela;
	private String apellidonombres;
	private String correo;
	private String telefono;
	private String nombreescuela;
	
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumno(int idalumno, int idescuela, String apellidonombres, String correo, String telefono) {
		super();
		this.idalumno = idalumno;
		this.idescuela = idescuela;
		this.apellidonombres = apellidonombres;
		this.correo = correo;
		this.telefono = telefono;
	}

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public int getIdescuela() {
		return idescuela;
	}

	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}

	public String getApellidonombres() {
		return apellidonombres;
	}

	public void setApellidonombres(String apellidonombres) {
		this.apellidonombres = apellidonombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreescuela() {
		return nombreescuela;
	}

	public void setNombreescuela(String nombreescuela) {
		this.nombreescuela = nombreescuela;
	}
	
}
