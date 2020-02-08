package ejercicioObjetos;



/**
 * Clase password capas de crear contraseñas debiles y fuertes segun se solicite
 * longitud de password por defecto:8
 * 
 * @author Manuel Soyarzo
 * @since 08/02/2020
 */
public class Password {
		private int longitud;
		private String contrasena;
		
		public Password() {
			this.longitud = 8;
			generaPassword();
		}
		
		public Password(int longitud) {
			this.longitud = longitud;
			generaPassword();
		}
		
		public int getLongitud() {
			return longitud;
		}
		
		public void setLongitud(int longitud) {
			this.longitud = longitud;
		}
		
		public String getContrasena() {
			return contrasena;
		}
		
		/**
		 * Funcion que genera contraseñas al azar hasta que la contraseña sea fuerte
		 * 
		 * @since 08/02/2020
		 */
		public void generarPaswordFuerte() {
			boolean fuerte = true;
			
			do {
				generaPassword();
				fuerte=esFuerte();
			}while(fuerte!=true);	
		}
		
		/**
		 * Funcion utiliada para generar una password al azar, este azar
		 * es controlada por un siclo switch. segun el valor entre 0 y 2 que 
		 * se le asigne a la variable seleccion en cada siclo se concatenara
		 * a la variable pass el caracter correspondiente entregado por el 
		 * rango correspondiente a cada caso
		 *  
		 * @since 08/02/2020
		 */
		public void generaPassword() {
			String pass = "";
			int seleccion;
			
			do {
				seleccion=azar(0,2);
				
				switch(seleccion) {
				case 0:
					pass+=(char)azar(65,90);break; // Letras desde la ´A´ a la ´Z´ en mayusculas
				case 1:
					pass+=(char)azar(97,122);break; // Letras desde la ´a´ a la ´z´ en minusculas 
				case 2:
					pass+=(char)azar(48,57);break;  // Valores entre 0 a 9
				}
			}while(pass.length()<this.longitud);
			
			this.contrasena=pass;	
		}
		
		/**
		 * Funcion que evalua si nuestra contrasena es fuerte, para ello debe cumplir con
		 * lo siguiente:  debe tener más de 2 mayúsculas, más de 1 minúscula y más de 5 números.
		 * @return retorna verdadero si cumpple con lo requerido y false si no cumple
		 * @since 08/02/2020
		 */
		public boolean esFuerte() {
			boolean fortachon= true;
			
			if(this.contrasena.length()<8) {      // si la password tiene menos de 8 cifras retorna falso
				fortachon=false;
			}else {
				if (ocurrencias(this.contrasena,65,90)<2) {    // si la password tiene menos de 2 caracteres entre ´A´ y ´Z´ 
					fortachon=false;                           // Mayusculas retorna falso
				}else {
					if(ocurrencias(this.contrasena,97,122)<1) {   // si la password tiene menos de 1 caracteres entre ´a´ y ´z´
						fortachon=false;                           // en minusculas retorna falso
					}else {
						if (ocurrencias(this.contrasena,48,57)<5) {   // si la password tiene menos de 5 numeros entre 0 y 9
							fortachon=false;                           // retorna falso
						}
					}	
				}
			}
			
				return fortachon;
		}
		
		/**
		 * Funcion que dado un string nos retorna cuantas de sus letras se encuentra dentro 
		 * del codigo ACSiii entre los valores acsiiDesde y acsiiHasta
		 * @param texto Cadena de texto la cual analisara nuestra funcion
		 * @param acsiiDesde Valor acsii minimo a analizar
		 * @param acsiiHasta Valor acsii maximo a analizar
		 * @return Cantidad de caracteres pertenecientes al rango indicado del codigo acsii
		 * @since 08/02/2020
		 */
		private int ocurrencias(String texto,int acsiiDesde,int acsiiHasta) {
			int ocurren =0;
			for (int i  = 0; i<texto.length();i++) {
				if ((int)texto.charAt(i)>=acsiiDesde && (int)texto.charAt(i)<=acsiiHasta) {
					ocurren++;
				}	
			}
			return ocurren;	
		}
		
		/**
		 * Funcion que retorna un numero al azar, dado entre un numero minimo y maximo.
		 * La funcion Math.random retorna valor de tipo Double entre 0 incluide hasta 1 excluido, 
		 * dado esto para obtener un numero dentro del rango indicado debemos multiplicar 
		 * dicha funcion por la cantidad de datos posibles a obtener:
		 * Ej:  Necesitamos un numero entre 20 y 30 incluyendo estos mismos 
		 * 
		 * int ejemplo = (int)(Math.random()*(30+1-20))+20;
		 * 
		 * en este caso multiplicamos nustra funcion math.random * 11 ya que entre el numero 
		 * 20 y el 30 yncluyendo ambos numeros tenemos 11 posibles cifras a retornar
		 * 
		 * @param desde numero minimo que puede retornar esta funcion
		 * @param hasta numero maximo que puede retornar esta funcion
		 * @return Retorna numero al azar generado por la funcion
		 * @since 08/02/2020
		 */
		private static int azar(int desde, int hasta) {
			int azar = (int)(Math.random()*(hasta+1-desde))+ desde; //
			return azar;
		}	
	}
	
	
	


