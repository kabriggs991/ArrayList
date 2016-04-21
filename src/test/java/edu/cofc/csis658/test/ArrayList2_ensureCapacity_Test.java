package edu.cofc.csis658.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ArrayList2_ensureCapacity_Test {
	
	int minCapacity;
	int finalCapacity;
	
	@Before
	public void setup() {
		minCapacity = -1;
		finalCapacity = 0;
		
	}

	@Test
	public void minCapacity10000() {
		minCapacity = 10000;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(finalCapacity, minCapacity);
	
	}
	
	/*
	 * Specification states that the capacity is at least the size of
	 * the number of elements in the ArrayList. Test with 0 elements.
	 */
	@Test
	public void minCapacityZeroElements() {
		minCapacity = 0;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(finalCapacity, minCapacity);
	
	}
	
	/*
	 * Specification states that the capacity is at least the size of
	 * the number of elements in the ArrayList. Test with 0 elements
	 * and was initialized with 0.
	 */
	@Test
	public void minCapacityZeroElementsZeroInialize() {
		minCapacity = 0;
		
		ArrayList2<String> ar2 = new ArrayList2(0);
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(finalCapacity, minCapacity);
	
	}
	
	/*
	 * Specification states that the capacity is at least the size of
	 * the number of elements in the ArrayList. Test with 1 element
	 * but was initialized with 2.
	 */
	@Test
	public void minCapacityOneElementTwoInialize() {
		minCapacity = 0;
		
		ArrayList2<String> ar2 = new ArrayList2(2);
		ar2.add("one");
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(finalCapacity, 2);
	
	}
	
	/*
	 * Specification states that the capacity is at least the size of
	 * the number of elements in the ArrayList. Test with 3 elements
	 * but was initialized with 2.
	 */
	@Test
	public void minCapacityThreeElementsTwoInialize() {
		minCapacity = 0;
		
		ArrayList2<String> ar2 = new ArrayList2(2);
		ar2.add("one");
		ar2.add("two");
		ar2.add("three");
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(finalCapacity, 3);
	
	}
	
	
	/*
	 * Specification states that the capacity is at least the size of
	 * the number of elements in the ArrayList. Test with 0 elements
	 * and was initialized with 0 but minCapacity to 15, which is 
	 * larger than supposed default.
	 */
	@Test
	public void minCapacityZeroInializeMinFifteen() {
		minCapacity = 15;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(finalCapacity, 15);
	
	}
	
	/*
	 * Specification states that the capacity is at least the size of
	 * the number of elements in the ArrayList. Test with 0 elements
	 * but was initialized with 10 but minCapacity set to 5.
	 */
	@Test
	public void minCapacityFiveInitialMinTen() {
		minCapacity = 5;
		int intialCapacity = 10;
		
		ArrayList2<String> ar2 = new ArrayList2(intialCapacity);
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(finalCapacity, 10);
	
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void minCapacityIllegalArgumentException() {
		minCapacity = Integer.MAX_VALUE;
		
		ArrayList2<String> ar2 = new ArrayList2(-1);
	
	}
	
	@Test(expected=OutOfMemoryError.class)
	public void minCapacityOutOfMemoryError() {
		minCapacity = Integer.MAX_VALUE;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		ar2.ensureCapacity(minCapacity);
		try {
			finalCapacity = getCapacity(ar2);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void min() {
		minCapacity = Integer.MAX_VALUE-5;
		//minCapacity = 2147483639;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		ar2.ensureCapacity(minCapacity);
		try {
			finalCapacity = getCapacity(ar2);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
		
	
	/*
	 * This method uses reflection to gain access to 'elementData' Object in
	 * of ArrayList2 object.
	 */
	static int getCapacity(ArrayList2<?> l) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field dataField = ArrayList2.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}
