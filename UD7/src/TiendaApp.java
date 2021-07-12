import java.text.DecimalFormat;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class TiendaApp {

	public static void main(String[] args) {
		// Creo la hashtable y añado los productos
				Hashtable<String, Double> productos = new Hashtable<String, Double>();
				productos.put("Portátil HP", 485.56);
				productos.put("PC Gaming", 1123.48);
				productos.put("Ratón Star Wars", 85.55);
				productos.put("Teclado Microsoft", 65.60);
				productos.put("Monitor LG", 150.30);
				productos.put("Auriculares Trust", 58.25);
				productos.put("Antena WiFi", 25.41);
				productos.put("Targeta gráfica Nvidia", 859.51);
				productos.put("Procesador Intel", 309.91);
				productos.put("Placa base", 159.56);
				// Le pregunto al usuario qué desea hacer
				String decision = JOptionPane.showInputDialog("Qué deseas hacer? Añadir, consultar o comprar?");
				// Si decide añadir, le pediremos la cantidad, el nombre y el precio, y se añadirá dicho artículo
				if(decision.equalsIgnoreCase("Añadir")) {
					String cantidad = JOptionPane.showInputDialog("Introduce la cantidad del producto");
					int cantidad2 = Integer.parseInt(cantidad);
					String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto");
					String precio = JOptionPane.showInputDialog("Introduce el precio");
					double precio2 = Double.parseDouble(precio);
					añadirArticulo(cantidad2, nombre, precio2, productos);
				// Si decide consultar, le pregunto si quiere consultar un producto concreto, o todos los artículos
				} else if(decision.equalsIgnoreCase("Consultar")) {
					String decision2 = JOptionPane.showInputDialog("Consultar producto concreto (1)? O consultar todos los productos (2)?");
					consultarProductos(decision2, productos);
				} else if(decision.equalsIgnoreCase("Comprar")) {
					String numProductos = JOptionPane.showInputDialog("Introduce el número de productos a comprar");
					int numProductos2 = Integer.parseInt(numProductos);
					comprarArticulos(numProductos2, productos);
				}

			}
			
			// Método que añadirá el artículo introducido por el usuario, el número de veces equivalente a la cantidad introducida
			public static void añadirArticulo(int cantidad, String nombre, double precio2, Hashtable<String, Double> productos) {
				for (int i = 0; i < cantidad; i++) {
					productos.put(nombre, precio2);
				}
				JOptionPane.showMessageDialog(null, "Producto añadido con éxito");
			}
			
			// Método que consulta un producto o todos, dependiendo de la decisión del usuario
			public static void consultarProductos(String decision, Hashtable<String, Double> productos) {
				if(decision.equals("1")) {
					String producto = JOptionPane.showInputDialog("Introduce el producto que quieres consultar");
					System.out.println(productos.get(producto));
				} else if(decision.equals("2")) {
					System.out.println(productos);
				}
			}
			
			// Método para comprar artículos
			public static void comprarArticulos(int numProducto, Hashtable<String, Double> productos) {
				// Creo otro hashtable que contendrá los productos comprados
				Hashtable<String, Double> productosComprados = new Hashtable<String, Double>();
				int i = 0;
				double sumaPrecio = 0;
				// Preguntamos el nombre de los productos a comprar, hasta el número de productos solicitado
				while(i < numProducto) {
					String producto = JOptionPane.showInputDialog("Introduce el artículo");
					productosComprados.put(producto, productos.get(producto));
					sumaPrecio += (productos.get(producto) + (productos.get(producto) * 0.21));
					i++;
				}
				
				// Clase que utilizo para que no salgan demasiados decimales
				DecimalFormat df = new DecimalFormat("##.##");
				
				// Muestro toda la información
				JOptionPane.showMessageDialog(null, "IVA aplicado " + "21%");
				JOptionPane.showMessageDialog(null, "Productos comprados" + productosComprados + "\n"
													+ "Número de productos comprados " + numProducto + "\n");
				String pago = JOptionPane.showInputDialog(null, "Serán " + df.format(sumaPrecio) + "€" + ", por favor, realiza el pago");
				double pago2 = Double.parseDouble(pago);
				
				if(pago2 > sumaPrecio) {
					double cambio = pago2 - sumaPrecio;
					JOptionPane.showMessageDialog(null, "El cambio será " + df.format(cambio) + " Gracias por venir!");
				} else {
					JOptionPane.showMessageDialog(null, "Gracias por venir!");
				}
				
			}
	}
