package edu.cofc.csis658.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ArrayList2_remove_Test {
	
	@Test
	public void numMovedEqualToZero() {
		System.out.println("test: numMovedEqualToZero start");
		ArrayList2<String> ar = new ArrayList2();
		
		ar.add("element");

		int x = ar.size();
		assertEquals(x, 1);
		
		ar.remove(0);
		assertEquals(ar.size(), 0);
	
		System.out.println("test: numMovedEqualToZero end ");
	}

	
	@Test
	public void numMovedGreaterThanZero() {
		System.out.println("test: numMovedGreaterThanZero start");
		ArrayList2<String> ar2 = new ArrayList2();
		
		ar2.add("string");
		ar2.add("string");
		ar2.add("string");
		
		int x = ar2.size();
		assertEquals(x, 3);
		
		ar2.remove(1);

		assertEquals(ar2.size(), 2);
	
		System.out.println("test: numMovedGreaterThanZero end");
	}
		
	@Test(expected=IndexOutOfBoundsException.class)
	public void numMovedLessThanZero() {
		System.out.println("test: numMovedLessThanZero start");
		ArrayList2<String> ar3 = new ArrayList2();
		

		ar3.add("string");
		
		ar3.remove(1);

	
		System.out.println("test: numMovedLessThanZero end");
	}
	
}
