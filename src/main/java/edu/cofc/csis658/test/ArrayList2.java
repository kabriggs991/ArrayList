package edu.cofc.csis658.test;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.RandomAccess;


public class ArrayList2<E> extends AbstractList<E>

        implements List<E>, RandomAccess, Cloneable, java.io.Serializable

{

    private static final long serialVersionUID = 8683452581122892189L;
    
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;



    /**

     * Default initial capacity.

     */

    private static final int DEFAULT_CAPACITY = 10;


    /**

     * Shared empty array instance used for empty instances.

     */

    private static final Object[] EMPTY_ELEMENTDATA = {};


    /**

     * The array buffer into which the elements of the ArrayList are stored.

     * The capacity of the ArrayList is the length of this array buffer. Any

     * empty ArrayList with elementData == EMPTY_ELEMENTDATA will be expanded to

     * DEFAULT_CAPACITY when the first element is added.

     */

    transient Object[] elementData; // non-private to simplify nested class access


    /**

     * The size of the ArrayList (the number of elements it contains).

     *

     * @serial

     */

    private int size;


    /**

     * Constructs an empty list with the specified initial capacity.

     *

     * @param  initialCapacity  the initial capacity of the list

     * @throws IllegalArgumentException if the specified initial capacity

     *         is negative

     */

    public ArrayList2(int initialCapacity) {

        super();

        if (initialCapacity < 0)

            throw new IllegalArgumentException("Illegal Capacity: "+

                                               initialCapacity);

        this.elementData = new Object[initialCapacity];

    }


    /**

     * Constructs an empty list with an initial capacity of ten.

     */

    public ArrayList2() {

        super();

        this.elementData = EMPTY_ELEMENTDATA;

    }


    /**

     * Constructs a list containing the elements of the specified

     * collection, in the order they are returned by the collection's

     * iterator.

     *

     * @param c the collection whose elements are to be placed into this list

     * @throws NullPointerException if the specified collection is null

     */

    public ArrayList2(Collection<? extends E> c) {

        elementData = c.toArray();

        size = elementData.length;

        // c.toArray might (incorrectly) not return Object[] (see 6260652)

        if (elementData.getClass() != Object[].class)

            elementData = Arrays.copyOf(elementData, size, Object[].class);

    }

    
    /**

     * Returns the index of the first occurrence of the specified element

     * in this list, or -1 if this list does not contain the element.

     * More formally, returns the lowest index <tt>i</tt> such that

     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,

     * or -1 if there is no such index.

     */

    public int indexOf(Object o) {

        if (o == null) {

            for (int i = 0; i < size; i++)

                if (elementData[i]==null)

                    return i;

        } else {

            for (int i = 0; i < size; i++)

                if (o.equals(elementData[i]))

                    return i;

        }

        return -1;

    }


    /**

     * Returns the index of the last occurrence of the specified element

     * in this list, or -1 if this list does not contain the element.

     * More formally, returns the highest index <tt>i</tt> such that

     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,

     * or -1 if there is no such index.

     */

    public int lastIndexOf(Object o) {

        if (o == null) {

            for (int i = size-1; i >= 0; i--)

                if (elementData[i]==null)

                    return i;

        } else {

            for (int i = size-1; i >= 0; i--)

                if (o.equals(elementData[i]))

                    return i;

        }

        return -1;

    }
    
    /**

     * Removes the element at the specified position in this list.

     * Shifts any subsequent elements to the left (subtracts one from their

     * indices).

     *

     * @param index the index of the element to be removed

     * @return the element that was removed from the list

     * @throws IndexOutOfBoundsException {@inheritDoc}

     */

    public E remove(int index) {

        rangeCheck(index);


        modCount++;

        E oldValue = elementData(index);


        int numMoved = size - index - 1;

        if (numMoved > 0)

            System.arraycopy(elementData, index+1, elementData, index,

                             numMoved);

        elementData[--size] = null; // clear to let GC do its work


        return oldValue;

    }
    
    
    
    /**

     * Checks if the given index is in range.  If not, throws an appropriate

     * runtime exception.  This method does *not* check if the index is

     * negative: It is always used immediately prior to an array access,

     * which throws an ArrayIndexOutOfBoundsException if index is negative.

     */

    private void rangeCheck(int index) {

        if (index >= size)

            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

    }
    
    private String outOfBoundsMsg(int index) {

        return "Index: "+index+", Size: "+size;

    }




 // Positional Access Operations


    @SuppressWarnings("unchecked")

    E elementData(int index) {

        return (E) elementData[index];

    }


    
    /**

     * Save the state of the <tt>ArrayList</tt> instance to a stream (that

     * is, serialize it).

     *

     * @serialData The length of the array backing the <tt>ArrayList</tt>

     *             instance is emitted (int), followed by all of its elements

     *             (each an <tt>Object</tt>) in the proper order.

     */

    private void writeObject(java.io.ObjectOutputStream s)

        throws java.io.IOException{

        // Write out element count, and any hidden stuff

        int expectedModCount = modCount;

        s.defaultWriteObject();


        // Write out size as capacity for behavioural compatibility with clone()

        s.writeInt(size);


        // Write out all elements in the proper order.

        for (int i=0; i<size; i++) {

            s.writeObject(elementData[i]);

        }


        if (modCount != expectedModCount) {

            throw new ConcurrentModificationException();

        }

    }

	
    @Override
	public E get(int index) {
		rangeCheck(index);
		return elementData(index);
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean add(E e) {
		ensureCapacityInternal(size + 1);  // Increments modCount!!
		elementData[size++] = e;
		return true;
	}
		
	private void ensureCapacityInternal(int minCapacity) {

        if (elementData == EMPTY_ELEMENTDATA) {

            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);

        }


        ensureExplicitCapacity(minCapacity);

    }
	
	private void ensureExplicitCapacity(int minCapacity) {

        modCount++;


        // overflow-conscious code

        if (minCapacity - elementData.length > 0)

            grow(minCapacity);

    }
	
	private void grow(int minCapacity) {

        // overflow-conscious code

        int oldCapacity = elementData.length;

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity - minCapacity < 0)

            newCapacity = minCapacity;

        if (newCapacity - MAX_ARRAY_SIZE > 0)

            newCapacity = hugeCapacity(minCapacity);

        // minCapacity is usually close to size, so this is a win:

        elementData = Arrays.copyOf(elementData, newCapacity);

    }
	

	 private static int hugeCapacity(int minCapacity) {

        if (minCapacity < 0) // overflow

            throw new OutOfMemoryError();

        return (minCapacity > MAX_ARRAY_SIZE) ?

            Integer.MAX_VALUE :

            MAX_ARRAY_SIZE;

	}
	
	public static void main(String[]args) {
		System.out.println("test begin");
		ArrayList2<String> ar2 = new ArrayList2();
		
		ar2.add("test add");
		
		System.out.println(ar2.get(0));
		
		System.out.println("test end");

	}

}
