public class Location 
{
	private int aisles;
	private int shelves;
	private int bin;
	public Location(int aisles,int shelves,int bin)
	{
		super();
		this.aisles = aisles;
		this.shelves = shelves;
		this.bin = bin;
	}
	//getters and setters
	public void setAisles(int aisles)
	{
		this.aisles = aisles;
	}
	public int getAisles()
	{
		return aisles;
	}
	public void setShelves(int shelves)
	{
		this.shelves = shelves;
	}
	public int getShelves()
	{
		return shelves;
	}
	public void setBin(int bin)
	{
		this.bin = bin;
	}
	public int getBin()
	{
		return bin;
	}
}
