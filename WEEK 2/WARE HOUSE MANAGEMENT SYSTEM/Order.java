import java.util.*;
public class Order
{
	private String orderID;
	private List<String> PID;
	private Priority priority;
	
	public enum Priority
	{
		STANDARD,EXPEDITED
	}
	
	public Order(String orderID, List<String> PID,Priority priority)
	{
		this.orderID = orderID;
		this.PID = PID;
		this.priority = priority;
	}
	
	// Getters and Setters
	public String getOrderID()
	{
		return orderID;
	}
	public List<String> getPID()
	{
		return PID;
	}
	public Priority getPriority()
	{
		return priority;
	}
}