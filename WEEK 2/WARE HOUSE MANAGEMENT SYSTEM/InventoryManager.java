import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
public class InventoryManager 
{
	private Map<String,Product> products;
	private BlockingQueue<Order> orderQueue;
	public InventoryManager()
	{
		products = new ConcurrentHashMap<>();
		orderQueue = new PriorityBlockingQueue<>(10,new OrderComparator());
	}
	public synchronized void addProduct(Product product)
	{
		products.put(product.getProductID(),product);
		System.out.println("PRODUCT ADDED : "+product.getName());
	}
	public synchronized void placeOrder(Order order)
	{
		orderQueue.add(order);
		System.out.println("PLACED ORDER : "+order.getOrderID());
	}
	public void processOrders()
	{
		ExecutorService executor = Executors.newFixedThreadPool(3);
		while(!orderQueue.isEmpty()) {
			executor.execute(() -> {
				try
				{
					Order order = orderQueue.poll();
					if(order != null) {
						fullfillOrder(order);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			});
			executor.shutdown();
		}
	}
	private synchronized void fullfillOrder(Order order)
	{
		System.out.println("PROCESSING ORDER : "+order.getOrderID());
		for(String PID : order.getPID())
		{
			Product product = products.get(PID);
			if(product != null && product.getQuantity() > 0)
			{
				product.setQuantity(product.getQuantity()-1);
				System.out.println("FULLFILLED : "+product.getName()+" | REMAINING : "+product.getQuantity());
			}
			else
			{
				System.out.println("OUT OF STOCK : "+(product != null ? product.getName() : "UNKNOWN PRODUCT"));
			}
		}
	}
}