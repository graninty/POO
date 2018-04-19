
package zakaz;

/*Rurikk94 2018.03.29*/

import java.util.ArrayList;
import java.util.Iterator;

public class ListaLocales
{
    private ArrayList<Local> listaLocales;

    public ListaLocales(){
        listaLocales = new ArrayList<>();
    }
    
    public boolean agregarLocal(Local local)
    {
        if (!listaLocales.isEmpty())
        {
            Iterator<Local> iteradorL = listaLocales.iterator();        
            while(iteradorL.hasNext())
            {
                Local dato= iteradorL.next();
                if (dato.getId()==local.getId())
                    return false;
            } 
        }
        listaLocales.add(local);
        return true;  
    }
    
    public boolean modificarIdLocal(Persona encargado, Local local)
    {
        if(listaLocales.contains(local))
        {
            for(int i=0; i<listaLocales.size(); i++)
            {
                if(listaLocales.get(i).equals(local))
                {
                    listaLocales.get(i).setEncargado(encargado);;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean modificarIdLocal(Integer id, Local local)
    {
        if(listaLocales.contains(local))
        {
            for(int i=0; i<listaLocales.size(); i++)
            {
                if(listaLocales.get(i).equals(local))
                {
                    listaLocales.get(i).setId(id);;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean modificarDireccionLocal(String direccion, Local local)
    {
        if(listaLocales.contains(local))
        {
            for(int i=0; i<listaLocales.size(); i++)
            {
                if(listaLocales.get(i).equals(local))
                {
                    listaLocales.get(i).setDireccion(direccion);;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean modificarEncargadoLocal(Persona encargado, Local local)
    {
        if(listaLocales.contains(local))
        {
            for(int i=0; i<listaLocales.size(); i++)
            {
                if(listaLocales.get(i).equals(local))
                {
                    listaLocales.get(i).setEncargado(encargado);;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean eliminarLocal(Local local)
    {
        if(listaLocales.contains(local))
        {
            for(int i=0; i< listaLocales.size(); i++)
            {
                if(listaLocales.get(i).equals(local))
                {
                    listaLocales.remove(i);
                    return true;
                }
            }
        }

        return false;
    }
    
    public String mostrarLocales()
    {
        String locales="";
        if(!listaLocales.isEmpty())
        {
            for(int i=0; i<listaLocales.size(); i++)
            {
                locales+=("\n"+listaLocales.get(i).getId()+"\t"
                                    +listaLocales.get(i).getNombre()+"\t"
                                    +listaLocales.get(i).getDireccion()+"\t"
                                    +listaLocales.get(i).getCiudad()+"\t"
                                    +listaLocales.get(i).getEncargado().getNombre()+"\t");
            }
        }
        return locales;
    }
	
    public Local buscarLocal(int i)
    {
        if(!listaLocales.isEmpty())
        {
            return listaLocales.get(i);
        }
            return null;
    }
    
	public Local existeLocal(int id){
		if(listaLocales.isEmpty())
			return null;
		else{
			for(int i=0;i<listaLocales.size();i++ ){
				if(id==listaLocales.get(i).getId()){
					return listaLocales.get(i);
				}
			}
			return null;
		}
	}
	/**
	 * @return
	 */
	public int cantidadLocales(){
		if(listaLocales.isEmpty())
			return 0;
		else
			return listaLocales.size();
	}
}
