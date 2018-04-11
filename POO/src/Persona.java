import java.sql.Date;

public class Persona {
	private String nombre;
	private Date fechaNac;
	private String rut;
	
	/**
	 * @param nombre
	 * @param fechaNac
	 * @param rut
	 */
	public Persona(String nombre, Date fechaNac, String rut) {
		super();
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
	
	
}
