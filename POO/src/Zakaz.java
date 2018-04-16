package zakaz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Zakaz
{
    public static void main(String[] args) throws SQLException, IOException, ParseException
    {
        Empresa empresa = new Empresa();
        
        empresa.cargar();
        
        //Menu
        empresa.empleados.mostrarEmpleados();
        System.out.println(empresa.locales.mostrarLocales());
        empresa.productos.mostrarProductos();
        empresa.vehiculos.mostrarVehiculos();
        System.out.println(empresa.planillas.mostrarPlanillas());
        //Fin Menu
        empresa.informeLocales("Listado de Locales","Reporte de  Locales","Reporte de  Locales");
        empresa.informeEmpleados("Listado de Empleados","Reporte de  Empleados","Reporte de  Empleados");
        empresa.informeVehiculos("Listado de Vehiculos","Reporte de  Vehiculos","Reporte de  Empleados");
        empresa.informeProductos("Listado de Productos","Reporte de  Productos","Reporte de  Productos");
        empresa.informePlanillas("Listado de Planillas","Reporte de  Planillas","Reporte de  Planillas");
        
        empresa.guardar();
    }
    
}