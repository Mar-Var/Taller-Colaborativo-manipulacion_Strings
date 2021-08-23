package aplicacion;
import javax.swing.JOptionPane;

import aplicacion.Features;
/**
 * This class defines that the App work.
 * @author Marcos Vargas Avella,Andres Ponguta Perez,Geraldine Parada Tobar,Jherson  Baez Paco
 */

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object menuObject[] ={"Convertir a nombre propio","Contar veces que aparece una cadena en el texto",
				"Encriptar","Desencriptar","Agregar caracteres","Eliminar caracteres","Intersectar cadenas",
				"Diferenciar dos cadenas","Borrar caracteres con una direccion y palabra",
				"Validar direcciones de correo electronico","Salir"};
		// Activate if it is by default of the program
		//Features f= new Features("Sogamoso ciudad del sol y del acero"); 
		
		boolean remain=true;
		
		// Disable if it is by default of the program
		Features f= new Features(JOptionPane.showInputDialog(null,"Ingrese la cadena por defecto para la aplicacion"));
		
		while(remain && f.getDEFAULT_MESSAGE()!=null) {
			String menuString=(String)JOptionPane.showInputDialog(null,
					"                      Bienvenido a nuestro menu\n\n"
					+ "Elija una opcion: ","Taller Colaborativo Programacion II",1,null,menuObject,null);
			
			switch (menuString) {
			case "Convertir a nombre propio":
				
				JOptionPane.showMessageDialog(null,"Cadena original: "+f.getDEFAULT_MESSAGE()+
						"\nNombre propio: "+f.ConvertProperName());
				break;
			case "Contar veces que aparece una cadena en el texto":
				JOptionPane.showMessageDialog(null,"Cantidad de veces que aparece la palabra: "+
												f.searchTimeWord(JOptionPane.showInputDialog(null,
																"Ingrese una palabra a buscar dentro del texo")));
				break;
			case "Encriptar":
				String str=JOptionPane.showInputDialog(null,"Ingrese el texto a encriptar");
				JOptionPane.showMessageDialog(null,"Cadena original: "+str+"\nCadena encriptada: "+ f.encrypt(str));
				
				break;
			case "Desencriptar":
				String string = JOptionPane.showInputDialog(null,"Ingrese el texto a desencriptar");
				JOptionPane.showMessageDialog(null,"Cadena original: "+string+
						"\nCadena desencriptada: "+ f.decrypt(string));
				
				break;
			case "Agregar caracteres":
				String c =JOptionPane.showInputDialog(null,"Ingrese un caracter a añadir");
				int amount = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Ingrese la cantidad de veces que se repite")); 
				String orientation =(String)JOptionPane.showInputDialog(null,"Elija donde añadir caracteres: ",
						"",1,null,new Object[] {"Izquierda","Derecha" },null);
				JOptionPane.showMessageDialog(null,"Cadena original: "+f.getDEFAULT_MESSAGE()+
						"\nCadena obtenida: "+  f.addCharacters(c.charAt(0),amount, orientation));
				break;
			case "Eliminar caracteres":
				String entry =  JOptionPane.showInputDialog(null,"Ingrese el caracter a eliminar");
				JOptionPane.showMessageDialog(null,"Cadena original: "+f.getDEFAULT_MESSAGE()+
						"\nCadena obtenida: "+ f.deleteCharacter(entry.charAt(0)));
				break;
			case "Intersectar cadenas":
				JOptionPane.showMessageDialog(null,"Cadena original: "+f.getDEFAULT_MESSAGE()+
						"\nCadena obtenida: "+ f.intersectStrings(JOptionPane.showInputDialog(null,
																"Ingrese una palabra: ")));
				break;
			case "Diferenciar dos cadenas":
				JOptionPane.showMessageDialog(null,"Cadena original: "+f.getDEFAULT_MESSAGE()+
						"\nCadena obtenida: "+ f.differentiateStrings(JOptionPane.showInputDialog(null,
						"Ingrese una palabra: ")));
				
				break;
			case "Borrar caracteres con una direccion y palabra":
				String wrd= JOptionPane.showInputDialog(null,"Ingrese una palabra: ");
				String side =(String)JOptionPane.showInputDialog(null,"Elija la direccion en que empezar ",
						"",1,null,new Object[] {"Izquierda","Derecha" },null);
				JOptionPane.showMessageDialog(null,"Cadena original: "+f.getDEFAULT_MESSAGE()+
						"\nCadena obtenida: "+ f.deleteCharactersWithWord(wrd, side));
				break;
			case "Validar direcciones de correo electronico":
				String email = JOptionPane.showInputDialog(null,"Ingrese una direccion de correo electronico");
				JOptionPane.showMessageDialog(null,"Email ingresado: "+email+
						"\nValidacion: "+ (f.validateEmail(email)?"Formato Correcto":"Formato Incorrecto"));
				
				break;
			case "Salir":
				remain=false;
				break;
			default:				
				break;
			}
			
		}

	}
}