package zakaz;
import java.util.ArrayList;

public class ListaEncargo 
{
	
	private ArrayList<Encargo> listaEncargos;
	
	public ListaEncargo()
	{
		listaEncargos = new ArrayList<Encargo>();
	}
		
	/* Métodos */
	
	public boolean agregarEncargo(Encargo e)
	{
		if(this.existeEncargo(e.getDestino(), e.getProducto()) != null)
		{
			return false;
		}
		else
		{
			listaEncargos.add(e);
			return true;
		}
	}
	
	public boolean agregarEncargo(Producto p, int cant, Local loc)
	{
		if(this.existeEncargo(loc, p) != null)
		{
			return false;
		}
		else
		{
			Encargo e = new Encargo(p, cant, loc);
			listaEncargos.add(e);
			return true;
		}
	}
	
	public boolean modificarProductoEncargo(Producto p, Encargo e)
	{
		if(this.existeEncargo(e.getDestino(), e.getProducto()) != null)
		{
			for(int i=0; i<listaEncargos.size(); i++)
			{
				if(listaEncargos.get(i).equals(e))
				{
					listaEncargos.get(i).setProducto(p);
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean modificarCantidadEncargo(int n, Encargo e)
	{
		if(this.existeEncargo(e.getDestino(), e.getProducto()) != null)
		{
			for(int i=0; i<listaEncargos.size(); i++)
			{
				if(listaEncargos.get(i).equals(e))
				{
					listaEncargos.get(i).setCantidad(n);;
					return true;
				}
			}
		}
		
		
		return false;
		
	}
	
	public boolean modificarDestinoEncargo(Local destino, Encargo e)
	{
		if(this.existeEncargo(e.getDestino(), e.getProducto()) != null)
		{
			for(int i=0; i<listaEncargos.size(); i++)
			{
				if(listaEncargos.get(i).equals(e))
				{
					listaEncargos.get(i).setDestino(destino);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean eliminarEncargo(Encargo e)
	{
		if(this.existeEncargo(e.getDestino(), e.getProducto()) != null)
		{
			for(int i=0; i< listaEncargos.size(); i++)
			{
				if(listaEncargos.get(i).equals(e))
				{
					listaEncargos.remove(i);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int calcularTotalEncargo(Encargo e)
	{
		int total=0;
		
		for(int i=0; i<listaEncargos.size(); i++)
		{
			total += listaEncargos.get(i).calcularPrecioEncargo();
		}
		
		return total;
	}
	
	private Encargo existeEncargo(Local destino, Producto producto)
	{
		for(int i=0; i<listaEncargos.size();i++)
		{
			if((listaEncargos.get(i).getDestino() != null)&&(listaEncargos.get(i).getProducto() != null))
			{
				if((listaEncargos.get(i).getDestino().equals(destino))&&(listaEncargos.get(i).getProducto().equals(producto)))
				{
					return (Encargo)listaEncargos.get(i);
				}
			}
		}
		return null;
	}
	
	
	
	public int productoMasPedido(int idProducto)
	{
		int suma=0;
		for(int i=0;i<listaEncargos.size();i++)
		{
			if(listaEncargos.get(i).getProducto().getId()==idProducto)
			{
				suma=suma+listaEncargos.get(i).getCantidad();
			}
		}
		return suma;
	}

    public int cantidadProductos() {
        return listaEncargos.size();
    }

}