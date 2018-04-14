/*Rurikk94 2018.03.29*/

import java.util.ArrayList;

public class ListaLocales
{
    private ArrayList<Local> listaLocales;

    public ListaLocales(){
        locales = new ArrayList<>();
    }
    
    public boolean agregarLocal(Local local)
    {
        if (!locales.isEmpty())
        {
            Iterator<Local> iteradorL = locales.iterator();        
            while(iteradorL.hasNext())
            {
                Local dato= iteradorL.next();
                if (dato.getId()==local.getId())
                    return false;
            } 
        }
        locales.add(local);
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
    
    public void mostrarLocal()
    {
        if(listaLocales.isEmpty())
        {
            return;
        }
        else
        {
            for(int i=0; i<listaLocales.size(); i++)
            {
                System.out.println(listaLocales.get(i).getId()+"\t"
                                    +listaLocales.get(i).getNombre()+"\t"
                                    +listaLocales.get(i).getDireccion()+"\t"
                                    +listaLocales.get(i).getEncargado().getNombre()+"\t");
            }
        }
    }
	
    public void mostrarLocal(int id)
    {
        if(listaLocales.isEmpty())
        {
            return;
        }
        else
        {
            for(int i=0; i<listaLocales.size(); i++)
            {
                if(listaLocales.get(i).getId()==id)
		{
                    System.out.println(
                        listaLocales.get(i).getId()+"\t"
                        +listaLocales.get(i).getNombre()+"\t"
                        +listaLocales.get(i).getDireccion()+"\t"
                        +listaLocales.get(i).getEncargado().getNombre()+"\t");
                }
            }
        }
    }
}
