package zakaz;

public class Vehiculo 
{
	private String marca;
	private String tipo;
	private String modelo;
	private String patente;
	
	public Vehiculo(String marca, String tipo, String modelo, String patente) 
	{
		super();
		this.marca = marca;
		this.tipo = tipo;
		this.modelo = modelo;
		this.patente = patente;
	}

	
	public String getMarca()
	{
		return marca;
	}
	
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public String getModelo() 
	{
		return modelo;
	}

	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}

	public String getPatente() 
	{
		return patente;
	}

	public void setPatente(String patente) 
	{
		this.patente = patente;
	}
	
	
	
	
}
