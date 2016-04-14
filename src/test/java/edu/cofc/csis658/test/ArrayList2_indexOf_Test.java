package edu.cofc.csis658.test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ArrayList2_indexOf_Test {

		private Set<String> setA;
		
		@Before
		public void setup() {
			
			
		}
		
		@Test
		public void indexOfFirstOccurrenceOfElement() {
			System.out.println("test begin");
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(null);
			testArray.add(4);
			testArray.add(6);
		
			int returnValue = testArray.indexOf(4);
			assertEquals(1,returnValue);
			System.out.println("test end");
		}
		
		@Test
		public void indexOfElementNotInList() {
			System.out.println("test begin");
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(null);
			testArray.add(6);
		
			int returnValue = testArray.indexOf(3);
			assertEquals(-1,returnValue);		
			System.out.println("test end");
		}
		
		@Test
		public void indexOfNull() {
			System.out.println("test begin");
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(null);
			testArray.add(6);	
		
			int returnValue = testArray.indexOf(null);	
			assertEquals(2,returnValue);
			System.out.println("test end");
		}
		
		@Test
		public void indexOfNullNotNullInList() {
			System.out.println("test begin");
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(3);
			testArray.add(6);	
		
			int returnValue = testArray.indexOf(null);	
			assertEquals(-1,returnValue);
			System.out.println("test end");
		}

	
}
