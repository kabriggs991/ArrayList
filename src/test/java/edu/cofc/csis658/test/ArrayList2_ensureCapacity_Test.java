package edu.cofc.csis658.test;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Before;
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
		assertTrue(finalCapacity == minCapacity);
	
	}
	
	@Test
	public void minCapacity0() {
		minCapacity = 0;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(finalCapacity == minCapacity);
	
	}
	
	@Test
	public void minCapacity5() {
		minCapacity = 5;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		try {
			ar2.ensureCapacity(minCapacity);
			finalCapacity = getCapacity(ar2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(finalCapacity == 0);
	
	}
	
	@Test(expected=OutOfMemoryError.class)
	public void minCapacityOutOfMemoryError() {
		minCapacity = Integer.MAX_VALUE;
		
		ArrayList2<String> ar2 = new ArrayList2();
	
		ar2.ensureCapacity(minCapacity);
		try {
			finalCapacity = getCapacity(ar2);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
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
