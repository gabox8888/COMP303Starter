package labtest01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

/**
 * Represents a company that owns and operates
 * one or more grocery stores, each with its own inventory.
 */
public class Corporation extends Observable implements Visitable
{
	private Map<String, Inventory> aInventories = new HashMap<String, Inventory>();
	
	/**
	 * @param pInventory An inventory to add to the corporation.
	 */
	public void addInventory(Inventory pInventory)
	{
		aInventories.put(pInventory.getName(), pInventory);
		setChanged();
		notifyObservers(pInventory.getName());
	}

	@Override
	public int accept(Visitor v)
	{
		return v.visitCorporation(this);
	}

	public Map<String,Inventory> getInvetories() {
		return Collections.unmodifiableMap(aInventories);
	}
}
