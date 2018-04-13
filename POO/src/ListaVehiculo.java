import java.util.ArrayList;

public class ListaVehiculo 
{

	private ArrayList<Vehiculo> listaVehiculos;
	
	public ListaVehiculo()
	{
		listaVehiculos = new ArrayList<Vehiculo>();
	}
	
	
	
	
	
	/* M�todos */
	
	public boolean agregarVehiculo(Vehiculo v)
	{
		if(listaVehiculos.contains(v))
		{
			return false;
		}
		
		else
		{
			listaVehiculos.add(v);
			return true;
		}
	}
	
	public boolean eliminarVehiculo(Vehiculo v)
	{
		if(listaVehiculos.contains(v))
		{
			for(int i=0; i<listaVehiculos.size(); i++)
			{
				if(listaVehiculos.get(i).equals(v))
				{
					listaVehiculos.remove(i);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean editarVehiculo(String marca, String tipo, String modelo, String patente, Vehiculo v)
	{
		if(listaVehiculos.contains(v))
		{
			for(int i=0; i<listaVehiculos.size(); i++)
			{
				if(listaVehiculos.get(i).equals(v))
				{
					listaVehiculos.get(i).setMarca(marca);
					listaVehiculos.get(i).setTipo(tipo);
					listaVehiculos.get(i).setModelo(modelo);
					listaVehiculos.get(i).setPatente(patente);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void mostrarVehiculos()
	{
		if(listaVehiculos.isEmpty())
		{
			return;
		}
		
		else
		{
			for(int i=0; i<listaVehiculos.size(); i++)
			{
				System.out.println(i+1+"-. "+listaVehiculos.get(i).getTipo()+" "+listaVehiculos.get(i).getMarca()+" "+listaVehiculos.get(i).getModelo()+" PATENTE:"+listaVehiculos.get(i).getPatente());
			}
		}
		
	}
	
	public void mostrarVehiculosPorTipo(String tipo)
	{
		int contador=1;
		
		if(listaVehiculos.isEmpty())
		{
			return;
		}
		
		else
		{
			for(int i=0; i<listaVehiculos.size(); i++)
			{
				if(listaVehiculos.get(i).getTipo().equalsIgnoreCase(tipo))
				{
					System.out.println(contador+"-. "+listaVehiculos.get(i).getTipo()+" "+listaVehiculos.get(i).getModelo()+" PATENTE:"+listaVehiculos.get(i).getPatente());
					contador++;
				}
			}
		}
	}
	
	public boolean existeVehiculo(Vehiculo v)
	{
		if(!listaVehiculos.isEmpty())
		{
			if(listaVehiculos.contains(v))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean existeVehiculo(String patente)
	{
		if(!listaVehiculos.isEmpty())
		{
			for(int i=0; i<listaVehiculos.size();i++)
			{
				if(listaVehiculos.get(i) != null)
				{
					if(listaVehiculos.get(i).getPatente().equalsIgnoreCase(patente))
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public int cantidadVehiculos()
	{
		int contador=0;
		
		for(int i=0; i<listaVehiculos.size(); i++)
		{
			if(listaVehiculos.get(i) != null)
			{
				contador++;
			}
		}
		
		return contador;
	}
	
}
