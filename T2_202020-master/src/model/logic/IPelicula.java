package model.logic;

public interface IPelicula extends Comparable<Pelicula>
{
	public int getiD();
	public void setiD(int iD); 
	public String getGenre();
	public void setGenre(String genre);
	public String getRelease();
	public void setRelease(String release);
	public String getTitle();
	public void setTitle(String title); 
	public double getVoteA(); 
	public void setVoteA(double voteA);
	public String getActorName1();
	public void setActorName1(String actorName1);
	public String getActorName2();
	public void setActorName2(String actorName2);
	public String getActorName3();
	public void setActorName3(String actorName3);
	public String getActorName4();
	public void setActorName4(String actorName4);
	public String getActorName5();
	public void setActorName5(String actorName5);
	public int compareTo(Pelicula otra);

}
