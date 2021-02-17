package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar datos de arreglo dinamico");
			System.out.println("2. Cargar datos de Linked List");
			System.out.println("3. Encontrar buenas peliculas");
			System.out.println("4. Encontrar 20 peliculas con peor promedio de votación ");
			System.out.println("5. Exit");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
