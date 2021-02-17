package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		Integer dato = 0;
		Integer respuesta = 0;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \nCargarArregloDinamico: ");
				    int capacidad = lector.nextInt();
				    modelo = new Modelo(); 
				    long inicio = System.currentTimeMillis();    
				try 
				{
					modelo.cargarArregloDinamico();
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long finn = System.currentTimeMillis();
		         
		        double tiempo = (double) ((finn - inicio)/1000);
		        System.out.println(tiempo);
					break;

				case 2: 
					view.printMessage("--------- \nCargarLinkedList: ");
				    int capacidad1 = lector.nextInt();
				    modelo = new Modelo(); 
				    long inicio1 = System.currentTimeMillis();    
				try 
				{
					modelo.cargarLinkedList();;
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long finn1 = System.currentTimeMillis();
		         
		        double tiemp1 = (double) ((finn1 - inicio1)/1000);
		        System.out.println(tiemp1);
					break;
				case 3:
					String algo= lector.next();
					Double algo1= lector.nextDouble();
					modelo.encontrarBuenasPeliculas(algo, algo1);
					break;
				case 4:
					modelo.darMalasPeliculas();
					break;
				case 5:
					view.printMessage("-----Hasta pronto-----");
					lector.close();
					fin= true;
					System.exit(0);
					break;
					}
		}
		
	}	
}
