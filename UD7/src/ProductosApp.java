import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ProductosApp {

	public static void main(String[] args) {
		// Creo la hashtable y añado los productos
		Hashtable<String, String> productos = new Hashtable<String, String>();
		productos.put("Portátil HP", "485,56€");
		productos.put("PC Gaming", "1123,48€");
		productos.put("Ratón Star Wars", "85,55€");
		productos.put("Teclado Microsoft", "65,60€");
		productos.put("Monitor LG", "150,30€");
		productos.put("Auriculares Trust", "58,25€");
		productos.put("Antena WiFi", "25,41€");
		productos.put("Targeta gráfica Nvidia", "859,51€");
		productos.put("Procesador Intel", "309,91€");
		productos.put("Placa base", "159,56€");
		// Le pregunto al usuario qué desea hacer
		String decision = JOptionPane.showInputDialog("Qué deseas hacer? Añadir o consultar?");
		// Si decide añadir, le pediremos la cantidad, el nombre y el precio, y se añadirá dicho artículo
		if(decision.equalsIgnoreCase("Añadir")) {
			String cantidad = JOptionPane.showInputDialog("Introduce la cantidad del producto");
			int cantidad2 = Integer.parseInt(cantidad);
			String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto");
			String precio = JOptionPane.showInputDialog("Introduce el precio");
			añadirArticulo(cantidad2, nombre, precio, productos);
		// Si decide consultar, le pregunto si quiere consultar un producto concreto, o todos los artículos
		} else if(decision.equalsIgnoreCase("Consultar")) {
			String decision2 = JOptionPane.showInputDialog("Consultar producto concreto (1)? O consultar todos los productos (2)?");
			consultarProductos(decision2, productos);
		}
		
	}
	
	// Método que añadirá el artículo introducido por el usuario, el número de veces equivalente a la cantidad introducida
	public static void añadirArticulo(int cantidad, String nombre, String precio, Hashtable<String, String> productos) {
		for (int i = 0; i < cantidad; i++) {
			productos.put(nombre, precio);
		}
		JOptionPane.showMessageDialog(null, "Producto añadido con éxito");
	}
	
	// Método que consulta un producto o todos, dependiendo de la decisión del usuario
	public static void consultarProductos(String decision, Hashtable<String, String> productos) {
		if(decision.equals("1")) {
			String producto = JOptionPane.showInputDialog("Introduce el producto que quieres consultar");
			System.out.println(productos.get(producto));
		} else if(decision.equals("2")) {
			System.out.println(productos);
		}
	}

}
