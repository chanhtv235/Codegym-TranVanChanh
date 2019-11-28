package collection_frameword.trien_khai_lop_list_don_gian;

import java.util.Arrays;

public class Mylist<E> {
    private int size;
    private final int DEFAULT_CAPACITY=10;
    private Object elements[];
    public Mylist(){
        elements=new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(Object e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}
