/*Rurikk94 2018.03.29*/

public class Local
{
    private int id;
    private String nombre;
    private String direccion;
    private Persona encargado;

    public Local(String nombre, int id, String direccion, Persona encargado)
    {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.encargado = encargado;
    }
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public Persona getEncargado()
    {
        return encargado;
    }

    public void setEncargado(Persona encargado)
    {
        this.encargado = encargado;
    }
}
