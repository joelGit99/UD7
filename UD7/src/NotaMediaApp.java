import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class NotaMediaApp {

	public static void main(String[] args) {
		// Creo un arraylist por alumno, con sus respectivas notas
		ArrayList<Double> notesPau = new ArrayList<>();
		notesPau.add(8.5);
		notesPau.add(6.3);
		notesPau.add(9.4);
		notesPau.add(7.9);
		notesPau.add(9.1);
		
		ArrayList<Double> notesMarta = new ArrayList<>();
		notesMarta.add(7.6);
		notesMarta.add(9.4);
		notesMarta.add(4.6);
		notesMarta.add(5.7);
		notesMarta.add(8.3);
		
		ArrayList<Double> notesLucas = new ArrayList<>();
		notesLucas.add(2.3);
		notesLucas.add(7.1);
		notesLucas.add(9.4);
		notesLucas.add(5.6);
		notesLucas.add(6.8);
		
		// Añado los alumnos a una hashtable, con su nombre, y su nota media
		Hashtable<String, String> clase = new Hashtable<String, String>();
		clase.put("Pau", calculoNotaMedia(notesPau));
		clase.put("Marta", calculoNotaMedia(notesMarta));
		clase.put("Lucas", calculoNotaMedia(notesLucas));
		
		Enumeration<String> enumeration = clase.elements();
		
		while(enumeration.hasMoreElements()) {
			JOptionPane.showMessageDialog(null, enumeration.nextElement());
		}
		
	}
	
	// Método que calcula la nota media
	public static String calculoNotaMedia(ArrayList<Double> notes) {
		Iterator<Double> it = notes.iterator();
		double num;
		double suma = 0;
		while(it.hasNext()) {
			num = it.next();
			suma = suma + num;
		}
		double calculo = suma / notes.size();
		String calculo2 = Double.toString(calculo);
		return calculo2;
	}

}
