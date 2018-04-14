package zakaz;

public class Planilla
{
    private Date fechaInicio;
	private Date fechaFin;
	private int codigo;
	private Vehiculo transporte;
	private Persona conductor;
	private ArrayList<Encargo> encargos;
	private Local despacho;
	
	public Planilla(int codigo)
	{
		this.codigo=codigo;
		transporte=new Vehiculo();
		encargos=new ArrayList<Encargo>();
		conductor=new Persona();
		despacho=new Local();
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

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
