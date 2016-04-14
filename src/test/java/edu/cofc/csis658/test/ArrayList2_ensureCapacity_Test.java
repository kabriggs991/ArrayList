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
	
	/*
	 * This method uses reflection to gain access to 'elementData' Object in
	 * of ArrayList2 object.
	 */
	static int getCapacity(ArrayList2<?> l) throws Exception {
        Field dataField = ArrayList2.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}
