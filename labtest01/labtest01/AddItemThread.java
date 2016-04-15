package labtest01;

public class AddItemThread extends Thread
{
	private Inventory aInv;
	private Item aItem;
	
	public AddItemThread(Inventory pInv, Item i) {
		aInv = pInv;
		aItem = i;
	}
	
	@Override
	public void run(){
		System.out.println("TT" );
		aInv.stock(aItem, 15);
	}

}
