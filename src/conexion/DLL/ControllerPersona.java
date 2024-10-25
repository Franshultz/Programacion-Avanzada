package DLL;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import BLL.Persona;
import repository.PersonaRepository;

public class ControllerPersona implements PersonaRepository {
	private static Connection con = conexion.getInstance().getConection();
	@Override
	public void agregarUsuario(Persona persona) {
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement(
							"INSERT INTO `persona`(`nombre`, `rol`, `password`) VALUES (?,?,?)" 
						,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getRol());
			statement.setString(3, persona.getPassword());
			int filas = statement.executeUpdate();
				if(filas>0) {
					 try (ResultSet rs = statement.getGeneratedKeys()) {
			                if (rs.next()) {
								JOptionPane.showMessageDialog(null, "Se agregó usuario id " + rs.getLong(1));
			                }
			           }				}
			

			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
	}
	@Override
	public  LinkedList<Persona> MostrarUsuarios() {
		 LinkedList<Persona> personas = new  LinkedList<Persona>();
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `persona`");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				 
				personas.add(new Persona(resultSet.getString("nombre"), resultSet.getString("rol"),resultSet.getString("password"),resultSet.getInt("id") ));
			}
			
		} catch (Exception e) {
System.out.println("No se agregó");		}
		
		
		return personas;
	}
	@Override
	public  Persona BuscarUsuario(int id) {
		Persona nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM `persona` WHERE id= ? ");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nuevo = new Persona(resultSet.getString("nombre"), resultSet.getString("rol"),resultSet.getString("password"),resultSet.getInt("id") );
			}
		
		} catch (Exception e) {
			System.out.println("No se agregó");		
		}
		
		
		return nuevo;
	}
	@Override
	public  void EliminarUsuario(int id) {
		Persona nuevo = null;
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("DELETE FROM `persona` WHERE id= ? ");
			statement.setInt(1, id);
			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se borró");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
	@Override
	public  void ActualizarUsuario(Persona persona) {
		
		try {
			
			PreparedStatement statement = (PreparedStatement) 
					con.prepareStatement("UPDATE `persona` SET `nombre`=?,`rol`=?,`password`=? WHERE id = ?");
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getRol());
			statement.setString(3, persona.getPassword());
			statement.setInt(4, persona.getId());

			int fila = statement.executeUpdate();
			if (fila>0) {
				JOptionPane.showMessageDialog(null, "Se actualizó");
			}
		
		} catch (Exception e) {
			System.out.println("No se borró");		
		}
		
		
	}
}
