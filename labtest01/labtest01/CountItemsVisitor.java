package labtest01;

public class CountItemsVisitor implements Visitor
{

	@Override
	public int visitInventory(Inventory inv)
	{
		int numItems = 0;
		for(Item i : inv.getInvetory().keySet()) {
			numItems += inv.getInvetory().get(i);
		}
		
		System.out.println("The number of items in the invetory is " + numItems);
		return numItems;
	}

	@Override
	public int visitCorporation(Corporation c)
	{	
		int numItems = 0;
		for (String s : c.getInvetories().keySet()) {
			System.out.println(s);
			numItems += c.getInvetories().get(s).accept(this);
		}
		System.out.println("The number of items in the corporation is " + numItems);
		return numItems;
	}

}
