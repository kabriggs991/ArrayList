package edu.cofc.csis658.test;

import org.junit.Before;
import org.junit.Test;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by lizhealy on 4/11/16.
 */
public class ArrayList2_lastIndexOf_Test {
    private Set<String> setA;

    @Before
    public void setup() {}

    @Test
    public void indexOfLastOccurrenceOfElement() {
        ArrayList2<Integer> testArray = new ArrayList2();

        testArray.add(8);
        testArray.add(2);
        testArray.add(null);
        testArray.add(3);
        testArray.add(6);
        testArray.add(2);
        testArray.add(4);

        int returnValue = testArray.lastIndexOf(6);

        assertEquals(4,returnValue);
    }

    @Test
    public void lastIndexOfNull() {
        ArrayList2<Integer> testArray = new ArrayList2();

        testArray.add(1);
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        testArray.add(null);
        testArray.add(2);

        int returnValue = testArray.lastIndexOf(null);

        assertEquals(4,returnValue);

    }

    @Test
    public void lastIndexOfNotNull() {
        ArrayList2<Integer> testArray = new ArrayList2();

        testArray.add(1);
        testArray.add(4);
        testArray.add(5);
        testArray.add(6);
        testArray.add(2);

        int returnValue = testArray.lastIndexOf(null);

        assertEquals(-1,returnValue);

    }

    @Test
    public void lastIndexOfElementNotInList() {
        ArrayList2<Integer> testArray = new ArrayList2();

        testArray.add(8);
        testArray.add(1);
        testArray.add(2);
        testArray.add(6);
        testArray.add(3);
        testArray.add(2);

        int returnValue = testArray.lastIndexOf(7);

        assertEquals(-1,returnValue);

    }


}
