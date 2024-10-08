package clase07;

public class Admin {

	private static boolean instancia;
	
	private Admin(boolean instancia) {
		this.instancia = false;
	}
	
	public static boolean isInstancia() {
		return instancia;
	}


	public static void setInstancia(boolean instancia) {
		Admin.instancia = instancia;
	}



	public static boolean getInstancia(boolean valor) {
		if (instancia == false) {
			instancia = valor;
			return instancia;
		} else {
			System.out.println("Ya existe");
			return false;
		}
	}
}
