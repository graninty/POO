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
	public boolean modificarFechaFin(int codigo,Date fechaFin)
	{
		if(!planillas.isEmpty())
		{
			for(int i=0;i<planillas.size();i++)
			{
				if(buscarPlanilla(codigo)!=null)
				{
					planillas.get(i).setFechaFin(fechaFin);
					return true;
				}
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
	public Persona conductorConMasViajes()
	{

		int mayor=0;
		String mayorConductor = null;
		Persona conductor;
		if(!planillas.isEmpty())
		for(int i=0;i<planillas.size();i++)
		{
			conductor=((Persona)(planillas.get(i).getConductor()));
			if(contarConductor(conductor.getRut())>mayor)
			{
				mayorConductor=conductor.getRut();
			}
		}
		if(mayorConductor!=null)
			return buscarConductor(mayorConductor);
		else
			return null;
	}
	public int contarConductor(String rut)
	{

		int cont=0;
		for(int i=0;i<planillas.size();i++)
		{
			if(((Persona)(planillas.get(i).getConductor())).getRut()==rut)
			{
				cont++;
			}
		}
		return cont;
	}
	public Persona buscarConductor(String rut)
	{
		Persona conductor;
		for(int i=0;i<planillas.size();i++)
		{
			conductor=((Persona)(planillas.get(i).getConductor()));
			if(conductor.getRut()==rut)
				return conductor;
		}
		return null;
	}
	public boolean modificarVehiculo(int codigo,String marca,String tipo,String patente,String modelo)
	{
		Vehiculo transporte=new Vehiculo(marca,tipo,modelo,patente);
		if(!planillas.isEmpty())
		{
			for(int i=0;i<planillas.size();i++)
			{
				if(buscarVehiculo(patente,codigo)!=null)
				{
					planillas.get(i).setTransporte(transporte);
					if(buscarVehiculo(patente,codigo).getPatente()==transporte.getPatente())
						return true;
				}	
			}
		}
		return false;
	}
	public Vehiculo buscarVehiculo(String patente,int codigo)
	{
		Vehiculo transporte;
		for(int i=0;i<planillas.size();i++)
		{
			if(planillas.get(i).getCodigo()==codigo)
			{
				transporte=((Vehiculo)(planillas.get(i).getTransporte()));
				if(transporte.getPatente()==patente)
					return transporte;
			}
		}
		return null;
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
