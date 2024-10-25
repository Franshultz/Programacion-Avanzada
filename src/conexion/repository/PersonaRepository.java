package repository;

import java.util.LinkedList;

import BLL.Persona;

public interface PersonaRepository {
	void agregarUsuario(Persona persona);
	LinkedList<Persona> MostrarUsuarios();
	Persona BuscarUsuario(int id);
	void EliminarUsuario(int id);
	 void ActualizarUsuario(Persona persona);

}
