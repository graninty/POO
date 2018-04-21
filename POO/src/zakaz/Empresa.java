package zakaz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.Date;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
public class Empresa
{
    private String nombre;
    private String direccion;
    private String rutEmpresa;
    private String telefonoEmpresa;
    private Persona encargado;

    ListaProducto productos;
    ListaLocales locales;
    ListaVehiculo vehiculos;
    ListaEmpleados empleados;
    ListaPlanillas planillas;
    

    public Empresa(String nombre,
                   String direccion,
                   String rutEmpresa,
                   String telefonoEmpresa) {
	    
	this.nombre= nombre;
        this.direccion= direccion;
        this.rutEmpresa= rutEmpresa;
        this.telefonoEmpresa= telefonoEmpresa;
	    
        productos = new ListaProducto();
        locales = new ListaLocales();
        vehiculos = new ListaVehiculo();
        empleados = new ListaEmpleados();
        planillas = new ListaPlanillas();
    }
	
    public void cargar() throws SQLException, ParseException{
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
    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getRutEmpresa(){
        return rutEmpresa;
    }
    public String getTelefonoEmpresa(){
        return telefonoEmpresa;
    }
    public boolean agregarEncargado(String nombre,
                                    Date fechNac,
                                    String rut){
        if (encargado==null){
            encargado = new Persona(nombre,fechNac,rut);
            return true;
        }
        return false;
    }
    public boolean cambiarEncargado(String nombre,
                                    Date fechNac,
                                    String rut){
        if (encargado!=null){
            encargado.setNombre(nombre);
            encargado.setFechNac(fechNac);
            encargado.setRut(rut);
            return true;
        }
        return false;
    }
    public boolean agregarProducto(String nombre,
                                   Integer id,
                                   Integer valor){      
        if (productos.agregarProducto(nombre,id,valor)==true){//agregarProducto de la clase ListaProductos debe agregar el producto solo si la id del producto no existe.
            return true;
        }
        return false;
    }
    public boolean agregarVehiculo(String marca,
                                   String tipoVehiculo,
                                   String modelo,
                                   String patente){      
        if (productos.agregarVehiculo(marca,tipoVehiculo,modelo, patente)==true){//agregarVehiculo de la clase ListaVehiculos debe agregar el vehiculo solo si la patente no existe.
            return true;
        }
        return false;
    }
    public boolean agregarPlanilla(String nombre,
                                   Integer id,
                                   Integer valor){      
        if (productos.agregarProducto(nombre,id,valor)==true){//agregarProducto de la clase ListaProductos debe agregar el producto solo si la id del producto no existe.
            return true;
        }
        return false;
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
        String query = "select id,nombre,direccion,ciudad,rutEncargado,nombreEncargado from Locales";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        while (rs.next())
        {   
            Persona encargado = new Persona(rs.getString(6),java.sql.Date.valueOf("2000-01-01"),rs.getString(5));
            Local l = new Local(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),encargado);
            locales.agregarLocal(l);
        }
        conexion.cerrarConexion();
    };
    private void cargarPlanillas() throws SQLException, ParseException {
        String query = "select fechaInicio,fechaFin,codigo,vehiculo,conductor,despacho from Planillas";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        while (rs.next())
        {   
            if (vehiculos.existeVehiculo(rs.getString(4)) && 
                    (locales.existeLocal(Integer.parseInt(rs.getString(6)))!=null) && 
                    (empleados.existeEmpleado(rs.getString(5))!=null))
            {
                Persona conductor = empleados.existeEmpleado(rs.getString(5));
                //Persona encargado = new Persona(rs.getString(6),"",rs.getString(5));
                Local despacho = locales.existeLocal(Integer.parseInt(rs.getString(6)));
                Vehiculo vehiculo = vehiculos.buscarVehiculo(rs.getString(4));

                Planilla p = new Planilla(Integer.parseInt(rs.getString(3)), java.sql.Date.valueOf(rs.getString(1)), java.sql.Date.valueOf(rs.getString(2)));

                p.setConductor(conductor);
                p.setDespacho(despacho);
                p.setTransporte(vehiculo);
                                
                planillas.agregarPlanilla(p);
            }
        }
        conexion.cerrarConexion();
    }
    private void cargarEncargos() throws SQLException {        
        
        String query = "select idPlanilla,producto,cantidad from Encargos";
        Conexion conexion = new Conexion();
        conexion.hacerConexion();

        //cargarDatos
        ResultSet rs = conexion.consulta(query);
        while (rs.next())
        {
            if (planillas.buscarPlanilla(Integer.parseInt(rs.getString(1)))!=null &&
                    productos.existeProducto(Integer.parseInt(rs.getString(2)))!=null &&
                    Integer.parseInt(rs.getString(2))>0)
            {
                Planilla p = planillas.buscarPlanilla(Integer.parseInt(rs.getString(1)));
                Producto pro = productos.existeProducto(Integer.parseInt(rs.getString(2)));
                Integer cantidad = Integer.parseInt(rs.getString(2));
                
                Encargo e = new Encargo(pro,cantidad,p.getDespacho());//Producto producto, int cantidad, Local destino
                p.agregarEncargo(e);
            }
        }
        conexion.cerrarConexion();
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
                //System.out.println(query);
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
        if (locales.cantidadLocales()>0)
        {
            int filas=0;
            for (int i=0;i<locales.cantidadLocales();i++)
            {
                query = " INSERT INTO Locales (id,nombre,direccion,ciudad,rutEncargado,nombreEncargado) VALUES("
                        +locales.buscarLocal(i).getId()+",'"+locales.buscarLocal(i).getNombre()+"','"+locales.buscarLocal(i).getCiudad()+"','"+locales.buscarLocal(i).getDireccion()+"','"+locales.buscarLocal(i).getEncargado().getRut()+"','"+locales.buscarLocal(i).getEncargado().getNombre()+"');";
                //System.out.println(query);
                filas+=conexion.updating(query);
            }
        }
        //System.out.println(filas);
        conexion.cerrarConexion();       
    } 
    private void guardarPlanillas() throws SQLException {
        Conexion conexion = new Conexion();
        conexion.hacerConexion();
        
        String query;
        query = "DELETE FROM Planillas" ;
        conexion.updating(query);
        if (planillas.cantidadPlanillas()>0)
        {
            int filas=0;
            for (int i=0;i<planillas.cantidadPlanillas();i++)
            {
                query = " INSERT INTO Planillas (fechaInicio,fechaFin,codigo,vehiculo,conductor,despacho) VALUES('"
                        +planillas.retornarPlanilla(i).getFechaInicio()+"','"
                        +planillas.retornarPlanilla(i).getFechaFin()+"','"
                        +planillas.retornarPlanilla(i).getCodigo()+"','"
                        +planillas.retornarPlanilla(i).getTransporte().getPatente()+"','"
                        +planillas.retornarPlanilla(i).getConductor().getRut()+"','"
                        +planillas.retornarPlanilla(i).getDespacho().getId()+"');";
                //System.out.println(query);
                filas+=conexion.updating(query);
            }
        }
        //System.out.println(filas);
        conexion.cerrarConexion();
    }
    private void guardarEncargos() throws SQLException {}
	
	public Producto productoMasVendido()
  	{
   		return productos.productoMasVendido(planillas);
	}
    
    public void informePlanillas(String nombreHoja,String nombreArchivo,String tituloPlanilla) throws IOException{
        //planillas;
        
        String[] encabezados = new String[]{
            "Codigo",
            "Fecha Recepción",
            "Fecha Envio",
            "Vehiculo",
            "Conductor",
            "Cantidad Productos",
            "Ciudad",
            "Direccion"
        };
        Object[][] tabla= new Object[planillas.cantidadPlanillas()][encabezados.length];
        for (int j = 0; j < planillas.cantidadPlanillas(); j++) {

            tabla[j][0]=planillas.mostrarPlanilla(j).getCodigo();
            tabla[j][1]=planillas.mostrarPlanilla(j).getFechaInicio();
            tabla[j][2]=planillas.mostrarPlanilla(j).getFechaFin();
            tabla[j][3]=planillas.mostrarPlanilla(j).getTransporte().getPatente();
            tabla[j][4]=planillas.mostrarPlanilla(j).getConductor().getRut();
            tabla[j][5]=planillas.mostrarPlanilla(j).cantidadProductos();
            tabla[j][6]=planillas.mostrarPlanilla(j).getDespacho().getCiudad();
            tabla[j][7]=planillas.mostrarPlanilla(j).getDespacho().getDireccion();
        }
        informeExcel(nombreHoja,nombreArchivo,tituloPlanilla,encabezados,tabla);        
    }
    public void informeProductos(String nombreHoja,String nombreArchivo,String tituloPlanilla) throws IOException{
        //planillas;
        
        String[] encabezados = new String[]{
            "ID",
            "NOMBRE",
            "valor"
        };
        Object[][] tabla= new Object[productos.cantidadProductos()][encabezados.length];
        for (int j = 0; j < productos.cantidadProductos(); j++) {

            tabla[j][0]=productos.mostrarProducto(j).getId();
            tabla[j][1]=productos.mostrarProducto(j).getNombre();
            tabla[j][2]=productos.mostrarProducto(j).getValor();
        }
        informeExcel(nombreHoja,nombreArchivo,tituloPlanilla,encabezados,tabla);        
    }
    public void informeVehiculos(String nombreHoja,String nombreArchivo,String tituloPlanilla) throws IOException{
        //planillas;
        
        String[] encabezados = new String[]{
            "PATENTE",
            "MARCA",
            "MODELO",
            "TIPO vehiculo"
        };
        Object[][] tabla= new Object[vehiculos.cantidadVehiculos()][encabezados.length];
        for (int j = 0; j < vehiculos.cantidadVehiculos(); j++) {

            tabla[j][0]=vehiculos.mostrarVehiculo(j).getPatente();
            tabla[j][1]=vehiculos.mostrarVehiculo(j).getMarca();
            tabla[j][2]=vehiculos.mostrarVehiculo(j).getModelo();
            tabla[j][3]=vehiculos.mostrarVehiculo(j).getTipo();
        }
        informeExcel(nombreHoja,nombreArchivo,tituloPlanilla,encabezados,tabla);        
    }
            
    public void informeEmpleados(String nombreHoja,String nombreArchivo,String tituloPlanilla) throws IOException{
        //planillas;
        
        String[] encabezados = new String[]{
            "RUT",
            "NOMBRE",
            "Fecha Nacimiento"
        };
        Object[][] tabla= new Object[empleados.cantidadEmpleados()][encabezados.length];
        for (int j = 0; j < empleados.cantidadEmpleados(); j++) {

            tabla[j][0]=empleados.mostrarEmpleado(j).getRut();
            tabla[j][1]=empleados.mostrarEmpleado(j).getNombre();
            tabla[j][2]=empleados.mostrarEmpleado(j).getFechaNac();
        }
        informeExcel(nombreHoja,nombreArchivo,tituloPlanilla,encabezados,tabla);        
    }
    public void informeLocales(String nombreHoja,String nombreArchivo,String tituloPlanilla) throws IOException{
        //planillas;
        String[] encabezados = new String[]{
            "ID",
            "NOMBRE",
            "DIRECCIÓN",
            "CIUDAD",
            "ENCARGADO"
        };
        Object[][] tabla= new Object[locales.cantidadLocales()][encabezados.length];
        for (int j = 0; j < locales.cantidadLocales(); j++) {

            tabla[j][0]=locales.buscarLocal(j).getId();
            tabla[j][1]=locales.buscarLocal(j).getNombre();
            tabla[j][2]=locales.buscarLocal(j).getDireccion();
            tabla[j][3]=locales.buscarLocal(j).getCiudad();
            tabla[j][4]=locales.buscarLocal(j).getEncargado().getNombre();
        }
        informeExcel(nombreHoja,nombreArchivo,tituloPlanilla,encabezados,tabla);        
    }
    
    private void informeExcel(String nombreHoja,String nombreArchivo,String tituloPlanilla,String[] encabezados,Object[][] tabla) throws FileNotFoundException, IOException{
        
        java.util.Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Integer tituloPos=0,encabezadoPos=1,tablaPos,totalTablaPos,piePos;
        
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, nombreHoja); //nombre Hoja
        
        Object[][] pie = new Object[][] {
            new Object[] { "EMPRESA DE TRANSPORTES ROLANDO NAVARRO E.I.R.L."},
            new Object[] { "DIRECCION REINA SUR SITIO 16 LOTE 1 COLINA"},
            new Object[] { "RUT 76.591.612-7"},
            new Object[] { "FONO +569 68408221"},
            new Object[] { ""},
            new Object[] { "Hoja de Calculo creada por ZakaZ"},
            new Object[] { "http://zakaz.rurikk.com/"}
        };
        //Titulo
        CellStyle tituloStyle = workbook.createCellStyle();
        Font tituloFont = workbook.createFont();
        tituloFont.setBold(true);
	tituloFont.setFontHeightInPoints((short) 18);
        tituloStyle.setFont(tituloFont);
        HSSFRow tituloRow = sheet.createRow(tituloPos);
        HSSFCell tituloCell = tituloRow.createCell(0);
        tituloCell.setCellStyle(tituloStyle);
        tituloCell.setCellValue(tituloPlanilla);
        

        //Encabezado
        CellStyle encabezadoStyle = workbook.createCellStyle();
        encabezadoStyle.setAlignment(HorizontalAlignment.CENTER);
        Font encabezadoFont = workbook.createFont();
        //font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        encabezadoStyle.setFont(encabezadoFont);
        encabezadoFont.setBold(true);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        //style.setFillPattern(CellStyle.SOLID_FOREGROUND);

        HSSFRow encabezadoRow = sheet.createRow(encabezadoPos);
        for (int i = 0; i < encabezados.length; ++i) {
            String encabezado = encabezados[i].toUpperCase();
            HSSFCell encabezadoCell = encabezadoRow.createCell(i);
            encabezadoCell.setCellStyle(encabezadoStyle);
            encabezadoCell.setCellValue(encabezado);
        }
        
        //Tabla
        tablaPos=encabezadoPos + 1;
        for (int i = 0; i < tabla.length; ++i) {
            HSSFRow tablaRow = sheet.createRow(i + tablaPos);

            Object[] d = tabla[i];
            
            for (int j = 0; j < tabla[i].length; j++) {
                tablaRow.createCell(j).setCellValue((String) String.valueOf(d[j]));                
            }
        }
        
        //Acomoda el ancho de las columnas
        for (int x = 0; x < sheet.getRow(1).getPhysicalNumberOfCells(); x++) {
            sheet.autoSizeColumn(x);
        }
        
        piePos=tablaPos + tabla.length+2;
        
        for (int i = 0; i < pie.length; ++i) {
            HSSFRow pieRow = sheet.createRow(piePos + i);

            Object[] d = pie[i];
            String informacion = (String) d[0];

            pieRow.createCell(0).setCellValue(informacion);
        }
        
        //Inserta fecha actual
        HSSFCell fechaCell = tituloRow.createCell(8);
        fechaCell.setCellStyle(encabezadoStyle);
        fechaCell.setCellValue(hourdateFormat.format(date));
        
        
        FileOutputStream file = new FileOutputStream(nombreArchivo+".xls");
        workbook.write(file);
        file.close();
    }
 
}
