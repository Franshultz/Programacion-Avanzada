package clase07;

public class Main {

	public static void main(String[] args) {
		
		boolean flag = Admin.getInstancia(true);
		
		if (flag == true) {
			System.out.println("Se creo el singleton");
		}
		
		
		flag = Admin.getInstancia(true);
		
		if (flag == false) {
			System.out.println("No se creo porque ya existe");
		}

		
	}

}
