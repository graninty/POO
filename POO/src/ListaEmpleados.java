package zakaz;

import java.util.ArrayList;

public class ListaEmpleados {
	
	private ArrayList<Persona> empleados;

	/**
	 * @param empleados
	 */
	public ListaEmpleados(ArrayList<Persona> empleados) {
		super();
		this.empleados = empleados;
	}
	public ListaEmpleados() {
		this.empleados = new ArrayList<>();
	}

	public ArrayList<Persona> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Persona> empleados) {
		this.empleados = empleados;
	}
	/**
	 * 
	 * @param nuevo
	 * @return
	 */
	public boolean agregarEmpleado(Persona nuevo){
		if(empleados.isEmpty()){
			empleados.add(nuevo);
			return true;
		}
		else{
			for(int i=0; i<empleados.size();i++){
				if(empleados.get(i).getRut().equals(nuevo.getRut()))
					return false;
			}
			empleados.add(nuevo);
			return true;
		}
	}
	/**
	 * 
	 * @param rut
	 * @param mod
	 * @return
	 */
	public boolean modificarEmpleado(String rut, Persona mod){
		if(empleados.isEmpty())
			return false;
		else{
			for(int i=0; i<empleados.size();i++){
				Persona empleado = new Persona();
				empleado = empleados.get(i);
				if(empleado.getRut().equals(rut)){
					empleado.setRut(mod.getRut());
					empleado.setNombre(mod.getNombre());
					empleado.setFechaNac(mod.getFechaNac());
					return true;
				}
			}
			return false;
		}
	}
	/**
	 * 
	 * @param rut
	 * @return
	 */
	public boolean eliminarEmpleado(String rut){
		if(empleados.isEmpty())
			return false;
		else{
			for(int i=0; i<empleados.size();i++){
				if(empleados.get(i).getRut().equals(rut)){
					empleados.remove(i);
					return true;
				}
			}
			return false;
		}	
	}
	/**
	 * 
	 * @param rut
	 * @return
	 */
	public Persona existeEmpleado(String rut){
		if(empleados.isEmpty())
			return null;
		else{
			for(int i=0;i<empleados.size();i++ ){
				if(empleados.get(i).getRut().equals(rut)){
					return empleados.get(i);
				}
			}
			return null;
		}
	}
	/**
	 * @return
	 */
	public int cantidadEmpleados(){
		if(empleados.isEmpty())
			return 0;
		else
			return empleados.size();
	}
        
        public void mostrarEmpleados(){
		if(!empleados.isEmpty())
		{
			for(int i=0; i<empleados.size();i++){
                            System.out.println(""+empleados.get(i).getRut()+" "+empleados.get(i).getNombre()+" "+empleados.get(i).getFechaNac());
			}
		}	
	}
        public Persona mostrarEmpleado(int i){
		if(!empleados.isEmpty())
		{
                    return empleados.get(i);
		}
                return null;
	}

}
