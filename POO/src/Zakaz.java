package zakaz;

import java.sql.SQLException;

public class Zakaz
{
    public static void main(String[] args) throws SQLException
    {
        Empresa empresa = new Empresa();
        
        empresa.cargar();
        
        //Menu
        empresa.empleados.mostrarEmpleados();
        empresa.locales.mostrarLocales();
        empresa.productos.mostrarProductos();
        empresa.vehiculos.mostrarVehiculos();
        //Fin Menu
        
        empresa.guardar();
    }
    
}
