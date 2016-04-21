package edu.cofc.csis658.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayList2_get_Test {
	
	@Test
	public void minCapacityOneElementTwoInialize() {		
		ArrayList2<String> ar2 = new ArrayList2(2);
		ar2.add("one");
	
	
		assertEquals("one", ar2.get(0));
	
	}

}
