package model.logic;

public class Pelicula 
{
	private int iD;
	private String genre;
	private String release;
	private String title;
	private double voteA;
	private String actorName1;
	private String actorName2;
	private String actorName3;
	private String actorName4;
	private String actorName5;
	private String dirName;

	public Pelicula(int pId, String pGenre, String pRelease, String pTitle, double pVoteA, String pActorName1, String pActorName2, String pActorName3, String pActorName4, String pActorName5, String pDirName)
	{
		iD = pId;
		genre = pGenre;
		release = pRelease;
		title = pTitle;
		voteA = pVoteA;
		actorName1 = pActorName1;
		actorName2 = pActorName2;
		actorName3 = pActorName3;
		actorName4 = pActorName4;
		actorName5 = pActorName5;
		dirName = pDirName;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getVoteA() {
		return voteA;
	}
	public void setVoteA(double voteA) {
		this.voteA = voteA;
	}
	public String getActorName1() {
		return actorName1;
	}
	public void setActorName1(String actorName1) {
		this.actorName1 = actorName1;
	}
	public String getActorName2() {
		return actorName2;
	}
	public void setActorName2(String actorName2) {
		this.actorName2 = actorName2;
	}
	public String getActorName3() {
		return actorName3;
	}
	public void setActorName3(String actorName3) {
		this.actorName3 = actorName3;
	}
	public String getActorName4() {
		return actorName4;
	}
	public void setActorName4(String actorName4) {
		this.actorName4 = actorName4;
	}
	public String getActorName5() {
		return actorName5;
	}
	public void setActorName5(String actorName5) {
		this.actorName5 = actorName5;
	}

	public int compareTo(Pelicula otra) 
	{
		int comp = 0;
		if(this.getVoteA() < otra.getVoteA())
		{
			comp = -1;
		}
		else if(this.getVoteA() > otra.getVoteA())
		{
			comp = 1;
		}
		else if(this.getVoteA() == otra.getVoteA())
		{
			comp = 0;
		}
		return comp;
	}
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;

	}
}
