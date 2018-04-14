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
}
