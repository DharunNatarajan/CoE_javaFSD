import java.util.*;
public class WareHouseManagement extends Thread
{
	public static void main(String[] args) throws InterruptedException
	{
		List<String> PID1 = Arrays.asList("LAP1","LAP5");
		List<String> PID2 = Arrays.asList("LAP1");
		InventoryManager im = new InventoryManager();
		Product p1 = new Product("LAP1","LENOVO",78,new Location(78,65,21));
		Product p2 = new Product("LAP34","MAC",12,new Location(65,12,7));
		Product p3 = new Product("LAP5","ASUS",56,new Location(12,9,46));
		im.addProduct(p1);
		im.addProduct(p2);
		im.addProduct(p3);
		Order order1 = new Order("OR025",PID1,Order.Priority.EXPEDITED);
		Order order2 = new Order("OR127",PID2,Order.Priority.STANDARD);
		Runnable r1 = () -> im.placeOrder(order1);
		Runnable r2 = () -> im.placeOrder(order2);
		Runnable r3 = () -> im.processOrders();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
	}
}
