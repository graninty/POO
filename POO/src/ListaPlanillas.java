package zakaz;

public class ListaPlanillas
{
    private ArrayList<Planilla> planillas;
	
	public ListaPlanillas()
	{
		planillas=new ArrayList<Planilla>();
	}
	public Planilla existePlanilla(int codigo)
	{
		for(int i=0;i<planillas.size();i++)
		{
			if((planillas.get(i).getCodigo())==codigo)
				return planillas.get(i);
		}
		return null;
	}
	public boolean agregarPlanilla(int codigo)
	{
		if(existePlanilla(codigo)==null)
		{
			Planilla newPlanilla=new Planilla(codigo);
			planillas.add(newPlanilla);
			if(existePlanilla(codigo)!=null)
				return true;
		}
		return false;
	}
	public boolean eliminarPlanilla(int codigo)
	{
		for(int i=0;i<planillas.size();i++)
		{
			if(existePlanilla(codigo)!=null)
			{
				if((planillas.get(i).getCodigo())==codigo)
					planillas.remove(i);
				if(existePlanilla(codigo)==null)
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
}
