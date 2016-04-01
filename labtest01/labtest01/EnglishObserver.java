package labtest01;

import java.util.Observable;
/**
 * 
 * @author gcemaj
 *
 */
public class EnglishObserver extends AbstarctCorporationLogger
{

	@Override
	public void update(Observable pO, Object pArg)
	{
		System.out.println();
		System.out.println("----Observer Updated----");
		System.out.println("An inventory " + pArg + "  added." );
		System.out.println("----Observer Updated----");
		System.out.println();		
	}

}
