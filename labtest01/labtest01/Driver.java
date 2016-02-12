package labtest01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class with a driver program and some 
 * sample items and inventories.
 */
public final class Driver
{
	private static final Item ITEM_CEREAL = new Item("Cereal", 1, 700);
	private static final Item ITEM_JAM = new Item("Jam", 2, 400);
	private static final Item ITEM_BUTTER = new Item("Butter", 3, 250);
	
	private static final int TEN = 10;
	
	private static final Item[] ITEMS = { ITEM_CEREAL, ITEM_JAM, ITEM_BUTTER };
	
	private Driver() {}
	
	/**
	 * @param pArgs Not used
	 */
	public static void main(String[] pArgs)
	{
		Inventory aInventory = new Inventory("testInventory");
		Item notInInventory = new Item("TEST", 1, 20);
		List<Item> sortedList = new ArrayList<Item>();
		for( Item item : ITEMS )
		{
			sortedList.add(item);
			aInventory.stock(item, TEN);
		}
		System.out.println("List before sorting:");
		for(Item i : sortedList) 
		{
			System.out.println(i.getName());
		}
		Collections.sort(sortedList, Item.getPriceComparator());
		Collections.sort(sortedList);
		System.out.println("List after sorting:");
		for(Item i : sortedList) 
		{
			System.out.println(i.getName());
		}
		System.out.println(aInventory.totalValue());
		aInventory.dispose(ITEM_CEREAL, 1);
		System.out.println(aInventory.totalValue());
		aInventory.dispose(notInInventory, TEN);
	}
}
