public class Product 
{
	String ProductID;
	String name;
	int quantity;
	Location location;
	
	Product(String ProductID,String name,int quantity, Location location)
	{
		this.ProductID = ProductID;
		this.name = name;
		this.quantity = quantity;
		this.location = location;
	}
	
	// Getters and Setters
	
	public void setProductID(String ProductID)
	{
		this.ProductID = ProductID;
	}
	public String getProductID()
	{
		return ProductID;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setLocation(Location location)
	{
		this.location = location;
	}
	public Location getLocation()
	{
		return location;
	}
}
