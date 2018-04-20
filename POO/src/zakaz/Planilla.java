package zakaz;

import java.sql.Date;
import java.util.*;

public class Planilla 
{
	private Date fechaInicio;
	private Date fechaFin;
	private int codigo;
	private Vehiculo transporte;
	private Persona conductor;
	private ListaEncargo encargos;
	private Local despacho;
	
	public Planilla(int codigo,Date fechaInicio,Date fechaFin)
	{
		this.codigo=codigo;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		setTransporte(new Vehiculo(null, null, null, null));
		encargos=new ListaEncargo();
		setConductor(new Persona());
		despacho=new Local(0,null,null,null,null);
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin)
	{
		this.fechaFin = fechaFin;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}
	public Vehiculo getTransporte() 
	{
		return transporte;
	}
	public void setTransporte(Vehiculo transporte)
	{
		this.transporte = transporte;
	}
	public Persona getConductor()
	{
		return conductor;
	}
	public void setConductor(Persona conductor) {
		this.conductor = conductor;
	}
	public int productoMasPedido(int idProducto)
	{
		return encargos.productoMasPedido(idProducto);
	}
	public void setDespacho(Local despacho)
	{
		this.despacho = despacho;
	}
	public Local getDespacho()
	{
		return despacho;
	}
	public int cantidadProductos()
	{
		return encargos.cantidadProductos();
	}
	public boolean agregarEncargo(Encargo e){
		encargos.agregarEncargo(e);
		return false;
	}
}
