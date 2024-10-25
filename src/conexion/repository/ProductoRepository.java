package repository;

import java.util.LinkedList;

import BLL.Producto;

public interface ProductoRepository {
	 void agregarProducto(Producto producto);
	LinkedList<Producto> MostrarProductos();
	Producto BuscarProducto(int id);
	void EliminarProducto(int id);
	 void ActualizarProducto(Producto producto);
}
