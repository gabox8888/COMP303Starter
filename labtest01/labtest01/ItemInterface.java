package labtest01;

public abstract class ItemInterface
{
	Item aItem;
	
	public ItemInterface (Item pItem) {
		aItem = pItem;
	}
	
	public String getName() {
		return aItem.getName();
	}
	
	public int getId() {
		return aItem.getId();
	}

}
