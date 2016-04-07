package edu.cofc.csis658.test;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class ArrayList2_ensureCapacity_Test {
	
	int minCapacity;
	
	@Before
	public void setup() {

		
	}

	@Test
	public void addAllNumMovedGreaterZero() {
		System.out.println("test begin");
		ArrayList2<String> ar2 = new ArrayList2();
		
		ar2.add("string");
		ar2.add("string2");
		ar2.add("string3");
		
		setA.add("String1");
		setA.add("String2");
		setA.add("String3");
		
		boolean mod = ar2.addAll(1, setA);
	
		assertTrue(mod);
	
		System.out.println("test end");
	}

}
