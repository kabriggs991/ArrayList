package edu.cofc.csis658.test;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ArrayList2_indexOf_Test {

		private Set<String> setA;
		
		@Before
		public void setup() {}
	
		@Test
		public void indexOfFirstOccurrenceOfElement() {
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(null);
			testArray.add(4);
			testArray.add(6);
		
			int returnValue = testArray.indexOf(4);
			assertEquals(1,returnValue);
		}

	
		@Test
		public void indexOfElementNotInList() {
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(null);
			testArray.add(6);
		
			int returnValue = testArray.indexOf(3);
			assertEquals(-1,returnValue);		
		}
		
		
		@Test
		public void indexOfNull() {
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(null);
			testArray.add(6);	
		
			int returnValue = testArray.indexOf(null);	
			assertEquals(2,returnValue);
		}
		

		@Test
		public void indexOfNullNotInList() {
			ArrayList2<Integer> testArray = new ArrayList2();
			
			testArray.add(1);
			testArray.add(4);
			testArray.add(3);
			testArray.add(6);	
		
			int returnValue = testArray.indexOf(null);	
			assertEquals(-1,returnValue);
		}

	
}
