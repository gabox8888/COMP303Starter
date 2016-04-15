package labtest01;

public class RemoveItemThread extends Thread
{
	private Inventory aInv;
	private Item aItem;
	
	public RemoveItemThread(Inventory pInv, Item i) {
		aInv = pInv;
		aItem = i;
	}
	
	@Override
	public void run(){
		aInv.dispose(aItem, 10);
	}


}
