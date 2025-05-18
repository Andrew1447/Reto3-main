package model;

public class Rol {
	private int rol_id;
	private String rol;
	private String descripcion;

	public Rol(int rol_id, String rol, String descripcion) {
		super();
		this.rol_id = rol_id;
		this.rol = rol;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Rol [rol_id=" + rol_id + ", rol=" + rol + ", descripcion=" + descripcion + "]";
	}

	public int getRol_id() {
		return rol_id;
	}

	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
