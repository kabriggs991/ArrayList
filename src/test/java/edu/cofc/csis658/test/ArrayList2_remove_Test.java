package edu.cofc.csis658.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ArrayList2_remove_Test {
	
	@Test
	public void addAllNumMovedGreaterZero() {
		System.out.println("test begin");
		ArrayList2<String> ar2 = new ArrayList2();
		
		ar2.add("string");

		ar2.remove(0);

		assertTrue(ar2.size() == 0);
	
		System.out.println("test end");
	}

	
	@Test
	public void addAllNumMovedGreaterZeo() {
		System.out.println("test begin");
		ArrayList2<String> ar2 = new ArrayList2();
		
		ar2.add("string");
		ar2.add("string");
		ar2.add("string");
		ar2.remove(0);

		assertTrue(ar2.size() == 0);
	
		System.out.println("test end");
	}

		
		
}
