package ejercicioObjetos;

import java.util.Scanner;

public class EjecucionPassword {

	public static void main(String[] args) {
		
		Password clave = new Password();
		
		Password arregloClaves[] = new Password[leerEntero("ingrese la cantidad de claves que desea almacenar")];
		boolean arregloClaveBoolean[] = new boolean[arregloClaves.length]; 
		
		int largoPassword = leerEntero("Ingrese el largo en que desea la contraseña");
		
		for (int i =0; i<arregloClaves.length;i++) {
			arregloClaves[i] = new Password(largoPassword);
			arregloClaveBoolean[i] = arregloClaves[i].esFuerte();		
			escribir("contraseña"+(i+1)+ ": "+arregloClaves[i].getContrasena()+" ,es fuerte :"+arregloClaveBoolean[i],true);
		}
		
	}
	
	public static int leerEntero(String mensaje) {
		escribir(mensaje,true);
		Scanner entrada = new Scanner(System.in);
		return entrada.nextInt();
	}
	
	
	public static void escribir(String mensaje, boolean salto) {
		if (salto) {
			System.out.println(mensaje);
		}else
			System.out.print(mensaje);			
	}

	
}
