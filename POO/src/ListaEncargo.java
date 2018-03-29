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
		if(listaEncargos.contains(e))
		{
			return false;
		}
		else
		{
			listaEncargos.add(e);
			return true;
		}
	}
	
	public boolean modificarProductoEncargo(Producto p, Encargo e)
	{
		if(listaEncargos.contains(e))
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
		if(listaEncargos.contains(e))
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
		if(listaEncargos.contains(e))
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
		if(listaEncargos.contains(e))
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

}
