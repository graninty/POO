package zakaz;

import java.util.*;
import java.sql.Date;
public class ListaPlanillas 
{
	private ArrayList<Planilla> planillas;
	
	public ListaPlanillas()
	{
		planillas=new ArrayList<Planilla>();
	}
	public Planilla buscarPlanilla(int codigo)
	{
		for(int i=0;i<planillas.size();i++)
		{
			if((planillas.get(i).getCodigo())==codigo)
				return planillas.get(i);
		}
		return null;
	}
	public boolean agregarPlanilla(int codigo,Date fechaInicio,Date fechaFin)
	{
		if(buscarPlanilla(codigo)==null)
		{
			Planilla newPlanilla=new Planilla(codigo,fechaInicio,fechaFin);
			planillas.add(newPlanilla);
			if(buscarPlanilla(codigo)!=null)
				return true;
		}
		return false;
	}
	public boolean eliminarPlanilla(int codigo)
	{
		for(int i=0;i<planillas.size();i++)
		{
			if(buscarPlanilla(codigo)!=null)
			{
				if((planillas.get(i).getCodigo())==codigo)
					planillas.remove(i);
				if(buscarPlanilla(codigo)==null)
					return true;
			}
		}
		return false;
	}
	public boolean modificarFechaInicio(int codigo,Date fechaInicio) 
	{
		if(!planillas.isEmpty())
		{
			for(int i=0;i<planillas.size();i++)
			{
				if(buscarPlanilla(codigo)!=null)
				{
					planillas.get(i).setFechaInicio(fechaInicio);
					return true;
				}
			}
		}
		return false;
	}
	@SuppressWarnings("unused")
	public boolean modificarFechaFin(int codigo,Date fechaFin)
	{
		if(!planillas.isEmpty())
		{
			for(int i=0;i<planillas.size();i++)
			{
				planillas.get(i).setFechaFin(fechaFin);
				return true;
			}
		}
		return false;
	}
	public Vehiculo vehiculoMasUtilizado()
	{
		int mayor=0;
		String mayorVehiculo = null;
		Vehiculo vehiculos;
		for(int i=0;i<planillas.size();i++)
		{
			vehiculos=((Vehiculo)(planillas.get(i).getTransporte()));
			if(contarVehiculo(vehiculos.getPatente())>mayor)
			{
				mayorVehiculo=vehiculos.getPatente();
			}
		}
		if(mayorVehiculo!=null)
			return buscarVehiculo(mayorVehiculo);
		else
			return null;
	}
	public Vehiculo buscarVehiculo(String patente)
	{
		Vehiculo vehiculos;
		for(int i=0;i<planillas.size();i++)
		{
			vehiculos=((Vehiculo)(planillas.get(i).getTransporte()));
			if(vehiculos.getPatente()==patente)
			{
				return vehiculos;
			}
		}
		return null;
	}
	public int contarVehiculo(String patenteVehi)
	{
		int cont=0;
		for(int i=0;i<planillas.size();i++)
		{
			if(((Vehiculo)(planillas.get(i).getTransporte())).getPatente()==patenteVehi)
			{
				cont++;
			}
		}
		return cont;
	}
	public int productoMasPedido(int idProducto)
	{
		int suma=0;
		for(int i=0;i<planillas.size();i++)
		{
			suma=suma+planillas.get(i).productoMasPedido(idProducto);
		}
		return suma;
	}     
	public Planilla mostrarPlanilla(int i)
	{
            return planillas.get(i);
	}
        public int cantidadPlanillas(){
            return planillas.size();
        }
	public int cantidadProductos(int idPlanilla)
	{
		for(int i=0;i<planillas.size();i++)
		{
                    if (planillas.get(i).getCodigo()==idPlanilla)
                        return planillas.get(i).cantidadProductos();
		}
		return 0;
        }
	public boolean agregarPlanilla(Planilla p)
	{
		if(buscarPlanilla(p.getCodigo())==null)
		{
			planillas.add(p);
			if(buscarPlanilla(p.getCodigo())!=null)
				return true;
		}
		return false;
	}
	public Planilla retornarPlanilla(int pos)
	{
            return planillas.get(pos);
	}
	public String mostrarPlanillas()
	{
            String listado="";
            if(!planillas.isEmpty())
            {
                for(int i=0; i<planillas.size(); i++)
                {
                    listado+=("\n"+ String.valueOf(planillas.get(i).getFechaInicio())+"\t"
                                        +planillas.get(i).getFechaFin()+"\t"
                                        +planillas.get(i).getCodigo()+"\t"
                                        +planillas.get(i).getConductor().getRut()+"\t"
                                        +planillas.get(i).getDespacho().getId()+"\t"
                                        +planillas.get(i).getTransporte().getPatente()+"\t");
                }
            }
            return listado;
        }
}
