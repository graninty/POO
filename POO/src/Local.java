package zakaz;
public class Local
{
    private int id;
    private String nombre;
    private String ciudad;
    private String direccion;
    private Persona encargado;

    public String getCiudad()
    {
        return ciudad;
    }

    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    public Local(int id, String nombre, String ciudad, String direccion, Persona encargado)
    {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.encargado = encargado;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
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

    public String toString()
    {
        return("ID: "+ id +" nombre: "+ nombre +" ciudad: "+ ciudad +" direccion: "+ direccion +" encargado: "+ encargado.getNombre());
    }


}
