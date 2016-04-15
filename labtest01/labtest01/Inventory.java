package labtest01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Represents the inventory of a 
 * physical grocery store.
 */
public class Inventory implements Visitable
{
	private final String aName; // Unique
	private final HashMap<Item, Integer> aInventory = new HashMap<>();
	private final Lock aLock = new ReentrantLock();
	private final Condition aCond = aLock.newCondition();
	
	/**
	 * Creates a new inventory with no items in it,
	 * and identified uniquely with pName.
	 * @param pName A unique identifier for this inventory.
	 */
	public Inventory(String pName)
	{
		aName = pName;
	}
	
	/**
	 * @return The unique name of this inventory.
	 */
	public String getName()
	{
		return aName;
	}
	
	/**
	 * Adds pQuantity number of items to the inventory.
	 * @param pItem The type of item to add.
	 * @param pQuantity The amount to add.
	 */
	public void stock(Item pItem, int pQuantity)
	{
		aLock.lock();
		int amount = 0;
		if( aInventory.containsKey(pItem))
		{
			amount = aInventory.get(pItem);
		}
		amount += pQuantity;
		aInventory.put(pItem, amount);
		System.out.println("Added " + pQuantity + " of " + pItem.getName() );
		aCond.signalAll();
		aLock.unlock();
	}
	
	/**
	 * Removes pQuantity of items from the inventory,
	 * for example by selling them or tossing them in
	 * the garbage.
	 * @param pItem The type of item to dispose of
	 * @param pQuantity The amount to dispose.
	 * @pre aInventory.containsKey(pItem) && pQuantity >= aInventory.get(pItem)
	 */
	public void dispose(Item pItem, int pQuantity)
	{
		
		aLock.lock();
		if (!aInventory.containsKey(pItem)) {
			try
			{
				aCond.await();
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			assert aInventory.containsKey(pItem);
			assert pQuantity > 0;
			System.out.println("TETS");
			int amount = aInventory.get(pItem);
			while(amount < pQuantity) {
				try
				{
					aCond.await();
				}
				catch (InterruptedException e)
				{
					return;
				}
			}
			amount -= pQuantity;
			aInventory.put(pItem, amount);
			System.out.println("Removed " + pQuantity + " of " + pItem.getName() );
			aLock.unlock();
		}
	}
	
	/**
	 * @param pItem The item to check for availability.
	 * @return How many of the items are available in the inventory.
	 */
	public int pAvailable(Item pItem)
	{
		if( aInventory.containsKey(pItem))
		{
			return aInventory.get(pItem);
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * 
	 * @return Total quantity
	 */
	public int totalValue()
	{
		int totalQuantity = 0;
		for (Item item : aInventory.keySet()) 
		{
			totalQuantity += aInventory.get(item);
		}
		return totalQuantity;
	}
	
	public Map<Item,Integer> getInvetory() {
		return Collections.unmodifiableMap(aInventory);
	}

	@Override
	public int accept(Visitor v)
	{
		return v.visitInventory(this);
	}
}
