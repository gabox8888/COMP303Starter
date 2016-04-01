package labtest01;

import java.util.Observable;

/**
 * 
 * @author gcemaj
 *
 */
public class FrenchObserver extends AbstarctCorporationLogger
{
	@Override
	public void update(Observable pO, Object pArg)
	{
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("----Observer Updated----");
		System.out.println("Un inventaire " + pArg + "  ajouté." );
		System.out.println("----Observer Updated----");
		System.out.println();
	}

}
