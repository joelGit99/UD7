import java.text.DecimalFormat;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class SupermercadoApp {

	public static void main(String[] args) {
		// Creo un hashtable con los diferentes productos pasados por caja
		int numProductos = 0;
		double sumaPrecio = 0;
		Hashtable<Double, String> tablaProductos = new Hashtable<Double, String>();
		String producto1 = JOptionPane.showInputDialog("Introduce el producto");
		double precio1 = 2.3 + (2.3 * 0.21);
		tablaProductos.put(precio1, producto1);
		sumaPrecio += precio1;
		numProductos++;
		String producto2 = JOptionPane.showInputDialog("Introduce el producto");
		double precio2 = 1.99 + (1.99 * 0.04);
		tablaProductos.put(precio2, producto2);
		sumaPrecio += precio2;
		numProductos++;
		String producto3 = JOptionPane.showInputDialog("Introduce el producto");
		double precio3 = 0.56 + (0.56 * 0.21);
		tablaProductos.put(precio3, producto3);
		sumaPrecio += precio3;
		numProductos++;
		
		// Clase que utilizo para que no salgan demasiados decimales
		DecimalFormat df = new DecimalFormat("##.##");
		
		// Muestro toda la información
		JOptionPane.showMessageDialog(null, producto1 + "\n"
											+ "IVA aplicado: 21%" + "\n"
											+ "Precio bruto: 2,30€" + "\n"
											+ "Precio más IVA " + df.format(precio1) + "€");
		JOptionPane.showMessageDialog(null, producto2 + "\n"
				+ "IVA aplicado: 4%" + "\n"
				+ "Precio bruto: 1,99€" + "\n"
				+ "Precio más IVA " + df.format(precio2) + "€");
		JOptionPane.showMessageDialog(null, producto3 + "\n"
				+ "IVA aplicado: 21%" + "\n"
				+ "Precio bruto: 0,56€" + "\n"
				+ "Precio más IVA " + df.format(precio3) + "€");
		JOptionPane.showMessageDialog(null, "Número de artículos comprados: " + numProductos);
		String pago = JOptionPane.showInputDialog("Serán " + df.format(sumaPrecio) + "€" + ", por favor, introduzca su pago");
		double pago2 = Double.parseDouble(pago);
		if(pago2 > sumaPrecio) {
			double cambio = pago2 - sumaPrecio;
			JOptionPane.showMessageDialog(null, "El cambio serán " + df.format(cambio) + "€");
		} else {
			JOptionPane.showMessageDialog(null, "Gracias por venir!");
		}
	}

}
