package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamicoo;
import model.data_structures.LinkedList;




/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo 
{
	/**
	 * Atributos del modelo del mundo
	 */

	public final static String MOVIES = "./data/MoviesCastingRaw-small.csv";
	public final static String CAST = "./data/SmallMoviesDetailsCleaned.csv";
	private IArregloDinamicoo<Pelicula> movieArreglo;
	private LinkedList<Pelicula> arregloMovie;
	private LinkedList<Integer> datos;
	private int tamañoMax;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		arregloMovie = new LinkedList();
		datos=  new LinkedList();
		movieArreglo=  (IArregloDinamicoo<Pelicula>) new ArregloDinamico(tamañoMax);

	}
	public Modelo(int capacidad)
	{
		tamañoMax= capacidad;

	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}


	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Integer buscar(Integer dato)
	{
		return datos.getElement(dato);
	}
	/**
	 * Requerimiento encontrar buenas películas de un Director
	 * 
	 */
	public String encontrarBuenasPeliculas(String nombreDirector, double calificacionPelicula) 
	{
		String valorFinal= "Peliculas buenas del director" +nombreDirector;

		for (int i = 0; i < arregloMovie.size(); i++) 
		{
			Pelicula actualMovie= (Pelicula) arregloMovie.getElement(i);

			if(actualMovie.getDirName().equals(nombreDirector)&&actualMovie.getVoteA()>=calificacionPelicula)
			{
				valorFinal= valorFinal+"\n Titulo: "+actualMovie.getTitle()+" \n ID: "+actualMovie.getiD()+" \n Genero: "+actualMovie.getGenre()+" \n Dia de Lanzamiento: " +actualMovie.getRelease()+" \n Promedio votos: "+actualMovie.getVoteA()+" \nActor1: "+actualMovie.getActorName1()+" \n Actor 2: "+actualMovie.getActorName2()+" \n Actor 3: "+actualMovie.getActorName3()+" \n Actor 4: "+actualMovie.getActorName4()+" \nActor5: "+actualMovie.getActorName5()+"\n\n";
			}
		}
		return valorFinal;
	}
	/** 
	 * Se retornan las 20 peores peliculas
	 * @return las 20 peores peliculas que no tengan 0 votos. 
	 */
	public String darMalasPeliculas() 
	{ 
		if (arregloMovie.size() == 0 ) 
		{ 
			return "No hay peliculas cargadas"; 
		}

		int salto, i;
		boolean cambios;

		for (salto = arregloMovie.size() / 2; salto != 0; salto /= 2) {
			cambios = true;
			while (cambios) {                                         
				cambios = false;
				for (i = salto; i < arregloMovie.size(); i++)   
				{
					if (arregloMovie.getElement(i - salto).getVoteA() > arregloMovie.getElement(i).getVoteA()) {       
						Pelicula aux = arregloMovie.getElement(i);                  

						arregloMovie.exchange(i, i-salto);

						cambios = true;                                                
					}
				}
			}
		}

		String rta = "Las 20 peores peliculas por votacion son:"; 

		for (int j = 0; j < 20; j++) {

			Pelicula actualMovie= (Pelicula) arregloMovie.getElement(i); 
			if(actualMovie.getVoteA() == 0)
				j++; 
			else 
				rta += "\n Titulo: "+actualMovie.getTitle()+" \n ID: "+actualMovie.getiD()+" \n Genero: "+actualMovie.getGenre()+" \n Dia de Lanzamiento: " +actualMovie.getRelease()+" \n Promedio votos: "+actualMovie.getVoteA()+" \nActor1: "+actualMovie.getActorName1()+" \n Actor 2: "+actualMovie.getActorName2()+" \n Actor 3: "+actualMovie.getActorName3()+" \n Actor 4: "+actualMovie.getActorName4()+" \nActor5: "+actualMovie.getActorName5()+"\n\n";
		}


	}

	public void cargarArregloDinamico() throws Exception
	{

		try{

			BufferedReader reader1 = new BufferedReader(new FileReader(CAST));
			String [] datos = new String[19];
			String line = reader1.readLine();
			line = reader1.readLine();

			BufferedReader reader2 = new BufferedReader(new FileReader(MOVIES));
			String [] datos2 = new String[22];
			String line2 = reader2.readLine();
			line2 = reader2.readLine();

			while(line != null && line2!=null)
			{
				datos = line.split(";");
				int pId = Integer.parseInt(datos[0]);
				String pActorName1 = datos[1];
				int pActorGend1 = Integer.parseInt(datos[2]);
				String pActorName2 = datos[3];
				int pActorGend2 = Integer.parseInt(datos[4]);
				String pActorName3 = datos[5];
				int pActorGend3 = Integer.parseInt(datos[6]);
				String pActorName4 = datos[7];
				int pActorGend4 = Integer.parseInt(datos[8]);
				String pActorName5 = datos[9];
				int pActorGend5 = Integer.parseInt(datos[10]);
				int pActorNumb = Integer.parseInt(datos[11]);
				String pDirName = datos[12];
				int pDirGend = Integer.parseInt(datos[13]);
				int pDirNumb = Integer.parseInt(datos[14]);
				String pProdName = datos[15];
				int pProdNumber = Integer.parseInt(datos[16]);
				String pScreenName = datos[17];
				String pEditName = datos[18];

				datos2 = line2.split(";");
				int pId1 = Integer.parseInt(datos2[0]);
				int pBudget = Integer.parseInt(datos2[1]);
				String pGenre = datos2[2];
				String pImbdId = datos2[3];
				String pOriLang = datos2[4];
				String pOriTitle = datos2[5];
				String pOverView = datos2[6];
				int pPopularity = Integer.parseInt(datos2[7]);
				String pProdCompany = datos2[8];
				String pProdCountry = datos2[9];
				String pRelease = datos2[10];
				int pRevenue = Integer.parseInt(datos2[11]);
				int pRuntime = Integer.parseInt(datos2[12]);
				String pSpokLang = datos2[13];
				String pStatus = datos2[14];
				String pTagline = datos2[15];
				String pTitle = datos2[16];
				double pVoteA = Double.parseDouble(datos2[17]);
				int pVoteC = Integer.parseInt(datos2[18]);
				int pProdCompNumb = Integer.parseInt(datos2[19]);
				int pProdCountNumb = Integer.parseInt(datos2[20]);
				int pSpokLangNumb = Integer.parseInt(datos2[21]);

				Pelicula item = new Pelicula(pId, pGenre, pRelease, pTitle, pVoteA, pActorName1, pActorName2, pActorName3, pActorName4, pActorName5, pDirName);

				movieArreglo.agregar(item);
				line = reader1.readLine();
				line2 = reader2.readLine();
			}

			reader1.close();
			reader2.close();
		}
		catch(Exception e)
		{
		}

	}
	public void cargarLinkedList() throws Exception
	{

		try{
			BufferedReader reader1 = new BufferedReader(new FileReader(CAST));
			String [] datos = new String[19];
			String line = reader1.readLine();
			line = reader1.readLine();

			BufferedReader reader2 = new BufferedReader(new FileReader(MOVIES));
			String [] datos2 = new String[22];
			String line2 = reader2.readLine();
			line2 = reader2.readLine();

			while(line != null && line2!=null)
			{
				datos = line.split(";");
				int pId = Integer.parseInt(datos[0]);
				String pActorName1 = datos[1];
				int pActorGend1 = Integer.parseInt(datos[2]);
				String pActorName2 = datos[3];
				int pActorGend2 = Integer.parseInt(datos[4]);
				String pActorName3 = datos[5];
				int pActorGend3 = Integer.parseInt(datos[6]);
				String pActorName4 = datos[7];
				int pActorGend4 = Integer.parseInt(datos[8]);
				String pActorName5 = datos[9];
				int pActorGend5 = Integer.parseInt(datos[10]);
				int pActorNumb = Integer.parseInt(datos[11]);
				String pDirName = datos[12];
				int pDirGend = Integer.parseInt(datos[13]);
				int pDirNumb = Integer.parseInt(datos[14]);
				String pProdName = datos[15];
				int pProdNumber = Integer.parseInt(datos[16]);
				String pScreenName = datos[17];
				String pEditName = datos[18];

				datos2 = line2.split(";");
				int pId1 = Integer.parseInt(datos2[0]);
				int pBudget = Integer.parseInt(datos2[1]);
				String pGenre = datos2[2];
				String pImbdId = datos2[3];
				String pOriLang = datos2[4];
				String pOriTitle = datos2[5];
				String pOverView = datos2[6];
				int pPopularity = Integer.parseInt(datos2[7]);
				String pProdCompany = datos2[8];
				String pProdCountry = datos2[9];
				String pRelease = datos2[10];
				int pRevenue = Integer.parseInt(datos2[11]);
				int pRuntime = Integer.parseInt(datos2[12]);
				String pSpokLang = datos2[13];
				String pStatus = datos2[14];
				String pTagline = datos2[15];
				String pTitle = datos2[16];
				double pVoteA = Double.parseDouble(datos2[17]);
				int pVoteC = Integer.parseInt(datos2[18]);
				int pProdCompNumb = Integer.parseInt(datos2[19]);
				int pProdCountNumb = Integer.parseInt(datos2[20]);
				int pSpokLangNumb = Integer.parseInt(datos2[21]);

				Pelicula item = new Pelicula(pId, pGenre, pRelease, pTitle, pVoteA, pActorName1, pActorName2, pActorName3, pActorName4, pActorName5, pDirName);

				arregloMovie.append(item);
				line = reader1.readLine();
				line2 = reader2.readLine();
			}

			reader1.close();
			reader2.close();
		}
		catch(Exception e)
		{
		}

	}



	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Integer eliminar(Integer dato)
	{
		return (Integer) datos.deleteElement(dato);
	}


}	

