package edu.cofc.csis658.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ArrayList2Test {
	
	private Set<String> setA;
	
	@Before
	public void setup() {
		int indexNumber = 4;
		setA = new HashSet<String>();
		
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


@Test
public void addAllNumMovedequalToZero() {
	System.out.println("test begin");
	ArrayList2<String> ar2 = new ArrayList2();
	
	ar2.add("string");

	setA.add("String1");
	setA.add("String2");
	setA.add("String3");
	
	boolean mod = ar2.addAll(1, setA);

	assertTrue(mod);

	System.out.println("test end");
}


@Test
public void addAllNumNewEqualZero() {
	System.out.println("test begin");
	ArrayList2<String> ar2 = new ArrayList2();
	
	ar2.add("string");
	ar2.add("string2");
	ar2.add("string3");
	

	
	boolean mod = ar2.addAll(3, setA);

	assertFalse(mod);

	System.out.println("test end");
}

}
