package zakaz;

public class Encargo 
{
	
	private Producto producto;
	private int cantidad;
	private Local destino;
	
	public Encargo(Producto producto, int cantidad, Local destino) 
	{
		
		this.producto = producto;
		this.cantidad = cantidad;
		this.destino = destino;
	}

	public Producto getProducto() 
	{
		return producto;
	}

	public void setProducto(Producto producto) 
	{
		this.producto = producto;
	}

	public int getCantidad() 
	{
		return cantidad;
	}

	public void setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
	}

	public Local getDestino() 
	{
		return destino;
	}

	public void setDestino(Local destino) 
	{
		this.destino = destino;
	}
	
	
	public int calcularPrecioEncargo()
	{
		int precio=0;
		
		precio = (producto.getValor()) * cantidad;
		
		return precio;
	}
	
	

}
