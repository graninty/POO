package zakaz;

import java.util.ArrayList;

public class ListaProducto {
	private ArrayList<Producto> listaProducto;

	/**
	 * @param listaProducto
	 */
	public ListaProducto(ArrayList<Producto> listaProducto) {
		super();
		this.listaProducto = listaProducto;
	}
	public ListaProducto() {
		this.listaProducto = new ArrayList<>();
	}

	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(ArrayList<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	/**
	 * 
	 * @param nombre
	 * @param id
	 * @param valor
	 * @return
	 */
	public boolean agregarProducto(String nombre, int id, int valor){
		if(listaProducto.isEmpty()){
			Producto nuevo = new Producto(id, nombre, valor);
			nuevo.setId(id);
			nuevo.setNombre(nombre);
			nuevo.setValor(valor);
			listaProducto.add(nuevo);
			return true;
		}
		else{
			for(int i=0; i<listaProducto.size();i++){
				if(listaProducto.get(i).getId() == id)
					return false;
			}
			Producto nuevo = new Producto(id, nombre, valor);
			nuevo.setId(id);
			nuevo.setNombre(nombre);
			nuevo.setValor(valor);
			listaProducto.add(nuevo);
			return true;
		}
	}
	/**
	 * 
	 * @param idModificar
	 * @param id
	 * @param nombre
	 * @param valor
	 * @return
	 */
	public boolean modificarProducto(int idModificar, int id , String nombre, int valor){
		if(listaProducto.isEmpty())
			return false;
		else{
			for(int i=0; i<listaProducto.size();i++){
				if(listaProducto.get(i).getId() == idModificar){
					listaProducto.get(i).setId(id);
					listaProducto.get(i).setNombre(nombre);
					listaProducto.get(i).setValor(valor);
					return true;
				}
			}
			return false;
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean eliminarProducto(int id){
		if(listaProducto.isEmpty())
			return false;
		else{
			for(int i=0; i<listaProducto.size();i++){
				if(listaProducto.get(i).getId()==id){
					listaProducto.remove(i);
					return true;
				}
					
			}
			return false;
		}
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Producto existeProducto(int id){
		if(listaProducto.isEmpty()){
			return null;
		}
		else{
			for(int i=0; i<listaProducto.size();i++){
				if(listaProducto.get(i).getId()== id)
					return listaProducto.get(i);
			}
			return null;
		}
	}
public Producto mostrarProducto(int posicion)
    {
        if (!listaProducto.isEmpty())
        {
            return listaProducto.get(posicion);
        }
        return null;
    }
	public void mostrarProductos(){
		if(listaProducto.isEmpty()){
		}
		else{
			for(int i=0; i<listaProducto.size();i++){
                            System.out.println(listaProducto.get(i).getId()+" "+listaProducto.get(i).getNombre()+" "+listaProducto.get(i).getValor());
			}
		}
	}
public int cantidadProductos(){
    return listaProducto.size();
}

	public Producto productoMasVendido(ListaPlanillas planillas)
	{
		int cantMay=0;
		Producto productoMay = new Producto();
		for(int i=0;i<listaProducto.size();i++)
		{
			if(planillas.productoMasPedido(listaProducto.get(i).getId())>cantMay)
			{
				productoMay=((Producto)(listaProducto.get(i)));
				cantMay=(planillas.productoMasPedido(listaProducto.get(i).getId()));
			}
		}
		return productoMay;
	}
}
