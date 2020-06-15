package pe.edu.upeu.portal.entity;

public class Escuela {
	
	private int idescuela;
	private String nombreescuela;
	
	public Escuela() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Escuela(int idescuela, String nombreescuela) {
		super();
		this.idescuela = idescuela;
		this.nombreescuela = nombreescuela;
	}

	public int getIdescuela() {
		return idescuela;
	}

	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}

	public String getNombreescuela() {
		return nombreescuela;
	}

	public void setNombreescuela(String nombreescuela) {
		this.nombreescuela = nombreescuela;
	}
}
