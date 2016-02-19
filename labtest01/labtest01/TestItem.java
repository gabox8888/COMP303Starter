package labtest01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestItem
{
	
	@Test
	public void testDecorator() {
		Item aItem = new Item("Test",1,8);
		ItemDecorator aItemDecorator = new ItemDecorator(aItem);
		
		assertEquals("Testing decorator", aItemDecorator.getName(),"ITEM- "+aItem.getName());
		assertFalse("Testing ", aItemDecorator.getName().equals(aItem.getName()));
	}

}
