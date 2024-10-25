package GUI;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Persona;

public class Main {
	public static void main(String[] args) {
		
		
		String[] acciones = {
			"Login","Registrar","Salir"
		};
		
		int menu = 0 ;
		do {
			menu = JOptionPane.showOptionDialog(null, "Bienvenido", null, 0, 0, null, acciones, acciones[0]);
			
			switch (menu) {
			case 0:
				String nombre="";
				while (nombre.isEmpty()) {
					nombre = JOptionPane.showInputDialog("Ingrese nombre");
					if (nombre.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Incorrecto");
					}
				}
				String contrasenia="";
				while (contrasenia.isEmpty()) {
					contrasenia = JOptionPane.showInputDialog("Ingrese contreña");
					if (contrasenia.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Incorrecto");
					}
				}
				Persona nueva = Persona.Login(nombre, contrasenia);
				if (nueva!=null) {
					if (nueva.getRol() == "Admin") {
						JOptionPane.showMessageDialog(null, "Es admin yendo al menú admin");
					}else if(nueva.getRol() == "Emple"){
						JOptionPane.showMessageDialog(null, "Es empleado yendo al menú empleado");

					}
				} else {

				}
				break;

			case 1:
				String nombreusuario = JOptionPane.showInputDialog("Ingrese nombre");
				String contrausuario = JOptionPane.showInputDialog("Ingrese contraseña");

				JOptionPane.showMessageDialog(null, Persona.Registrarse(nombreusuario, contrausuario));
			
				break;
			}
		} while (menu!=2);
		
		
		
		
		
	}
}
