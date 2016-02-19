package labtest01;

/**
 * 
 * @author gcemaj
 *
 */
public class ItemDecorator extends ItemInterface
{
	/**
	 * 
	 * @param pItem
	 */
	public ItemDecorator(Item pItem)
	{
		super(pItem);
	}
	
	/**
	 * @return String
	 */
	public String getName() 
	{
		return "ITEM- " +aItem.getName();
	}
	
	/**
	 * @return int ID
	 */
	public int getId()
	
	{
		return aItem.getId();
	}
	

}
