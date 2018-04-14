import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
public class Empresa
{

    ListaProducto productos;
    ListaLocales locales;
    ListaVehiculo vehiculos;
    ListaEmpleados empleados;
    

    public Empresa() {
        this.productos = new ListaProducto();
        this.locales = new ListaLocales();
        this.vehiculos = new ListaVehiculo();
        this.empleados = new ListaEmpleados();
    }
	
    public void cargar() throws SQLException{
        cargarProductos();
        cargarVehiculos();
        cargarPersonas();
        cargarLocales();
        cargarPlanillas();
        cargarEncargos();        
    }
    public void guardar() throws SQLException{
        guardarProductos();
        guardarVehiculos();
        guardarPersonas();
        guardarLocales();
        guardarPlanillas();
        guardarEncargos();            
    }
        
    private void cargarProductos() throws SQLException {
        String query = "select id,nombre,valor from Productos;";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        while (rs.next())
        {
            //Producto p = new Producto(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3));
            //System.out.println("Se agrega "+rs.getString(2)+ " " +Integer.parseInt(rs.getString(1))+ " " +Integer.parseInt(rs.getString(3)));
            productos.agregarProducto(rs.getString(2),Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(3)));
        }
        conexion.cerrarConexion();        
    }
    private void cargarVehiculos() throws SQLException {
        String query = "select marca,tipovehiculo,modelo,patente from Vehiculos;";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        while (rs.next())
        {
            Vehiculo v = new Vehiculo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            //System.out.println("Se agrega "+rs.getString(2)+ " " +Integer.parseInt(rs.getString(1))+ " " +Integer.parseInt(rs.getString(3)));
            if (!vehiculos.existeVehiculo(v.getPatente()))
                vehiculos.agregarVehiculo(v);
                
        }
        conexion.cerrarConexion();        
    }
    private void cargarPersonas() throws SQLException {
        
        String query = "select nombre,rut,fechaNac from Empleados;";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        
        while (rs.next())
        {
            Persona p = new Persona(rs.getString(1),java.sql.Date.valueOf(rs.getString(3)),rs.getString(2));
            empleados.agregarEmpleado(p);
                
        }
        conexion.cerrarConexion();  
    }
    private void cargarLocales() throws SQLException{
        String query = "select id,nombre,direccion,ciudad,encargado from Locales";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        while (rs.next())
        {   
            if (empleados.existeEmpleado(rs.getString(5))!=null)
            {
                Local l = new Local(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),empleados.existeEmpleado(rs.getString(5)));
                locales.agregarLocal(l);                
            }
        }
        conexion.cerrarConexion();
    };
    private void cargarPlanillas() {
    }
    private void cargarEncargos() {
    }
    
    private void guardarProductos() throws SQLException {        
        Conexion conexion = new Conexion();
        conexion.hacerConexion();
        
        String query;
        query = "DELETE FROM Productos" ;
        conexion.updating(query);
        if (productos.cantidadProductos()>0)
        {
            int filas=0;
            for (int i=0;i<productos.cantidadProductos();i++)
            {
                
                //System.out.println(productos.mostrarProducto(i).getId() + "\t\t"+ productos.mostrarProducto(i).getNombre() + "\t\t"+ productos.mostrarProducto(i).getValor());
                //productos.mostrarProducto(i);
                query = "INSERT INTO Productos (id,nombre,valor) VALUES("+ productos.mostrarProducto(i).getId() +",'"+ productos.mostrarProducto(i).getNombre() + "'," + productos.mostrarProducto(i).getValor() + ");";
                //System.out.println(query);
                filas+=conexion.updating(query);                
            }
        //System.out.println("Se agregaron "+filas+" filas");
        }
        conexion.cerrarConexion();
    }
    private void guardarVehiculos() throws SQLException {        
        Conexion conexion = new Conexion();
        conexion.hacerConexion();
        
        String query;
        query = "DELETE FROM Vehiculos;" ;
        conexion.updating(query);
        if (vehiculos.cantidadVehiculos()>0)
        {
            int filas=0;
            for (int i=0;i<vehiculos.cantidadVehiculos();i++)
            {
                
                //System.out.println(productos.mostrarProducto(i).getId() + "\t\t"+ productos.mostrarProducto(i).getNombre() + "\t\t"+ productos.mostrarProducto(i).getValor());
                //productos.mostrarProducto(i);
                query = "INSERT INTO Vehiculos (marca,tipovehiculo,modelo,patente) VALUES('"+ vehiculos.mostrarVehiculo(i).getMarca()+"','"+ vehiculos.mostrarVehiculo(i).getTipo()+ "','" + vehiculos.mostrarVehiculo(i).getModelo()+ "','" + vehiculos.mostrarVehiculo(i).getPatente()+ "');";
                //System.out.println(query);
                filas+=conexion.updating(query);                
            }
        //System.out.println("Se agregaron "+filas+" filas");
        }
        conexion.cerrarConexion();
    }
    private void guardarPersonas() throws SQLException {       
        Conexion conexion = new Conexion();
        conexion.hacerConexion();
        
        String query;
        query = "DELETE FROM Empleados;" ;
        conexion.updating(query);
        if (empleados.cantidadEmpleados()>0)
        {
            int filas=0;
            for (int i=0;i<empleados.cantidadEmpleados();i++)
            {
                query = "INSERT INTO Empleados (nombre,rut,fechaNac) VALUES('"+ empleados.mostrarEmpleado(i).getNombre()+"','"+ empleados.mostrarEmpleado(i).getRut()+ "','" + empleados.mostrarEmpleado(i).getFechaNac()+ "');";
                System.out.println(query);
                filas+=conexion.updating(query);                
            }
        System.out.println("Se agregaron "+filas+" filas");
        }
        conexion.cerrarConexion();
    }   
    private void guardarLocales() throws SQLException {        
        Conexion conexion = new Conexion();
        conexion.hacerConexion();
        
        String query;
        query = "DELETE FROM Locales" ;
        conexion.updating(query);
        int filas=0;
        if (!locales.locales.isEmpty())
        {
            Iterator<Local> iteradorL = locales.locales.iterator();        
            while(iteradorL.hasNext())
            {
                Local dato= iteradorL.next();
                query = " INSERT INTO Locales (id,nombre,direccion,ciudad,encargado) VALUES("
                        +dato.getId()+",'"+dato.getNombre()+"','"+dato.getCiudad()+"','"+dato.getDireccion()+"','"+dato.getEncargado().getRut()+"');";
                //System.out.println(query);
                filas+=conexion.updating(query);
            }
        }
        //System.out.println(filas);
        conexion.cerrarConexion();       
    } 
    private void guardarPlanillas() throws SQLException {}
    private void guardarEncargos() throws SQLException {}
 
}
