package zakaz;

public class Producto {
	int id;
	String nombre;
	int valor;
	/**
	 * @param id
	 * @param nombre
	 * @param valor
	 */
	public Producto() {
		super();
		this.id = 0;
		this.nombre = null;
		this.valor = 0;
	}
	public Producto(int id, String nombre, int valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	

}