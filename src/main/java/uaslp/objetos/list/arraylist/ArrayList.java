package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList <T> implements List<T> {

    private static final int INITIAL_SIZE = 2;
    private T []array;
    private int size;

    public ArrayList() {
        array = (T[])(new Object[INITIAL_SIZE]);
    }

    public void addAtTail(T data) {

        if(isFull()) {
            increaseSize();
        }

        array[size] = data;
        size++;
    }

    public void addAtFront(T data) {

        if(isFull()) {
            increaseSize();
        }

        Iterator<T> iterator = getIteratorAt(size-1);
        int currentIndex = size;

        while(iterator.hasPrevious()) {
            array[currentIndex] = iterator.previous();
            currentIndex--;
        }

        array[0] = data;
        size++;
    }

    public void remove(int index) {

        if(isInvalidIndex(index)){
            return; //error handling
        }

        for(int i = index ; i < size - 1; i++){
            array[i] = array[i+1];
        }

        size--;

        if(shouldDecrease()){
            decreaseSize();
        }
    }

    //logical deletion, taking advantage of garbage collector
    public void removeAll() {
        array = (T[])(new Object[INITIAL_SIZE]);
        size = 0;
    }

    public void setAt(int index, T data) {

        if(isInvalidIndex(index)){
            return; //error handling
        }

        array[index] = data;

    }

    public T getAt(int index) {

        if(isInvalidIndex(index)){
            return null; //error handling
        }

        return array[index];

    }

    public void removeAllWithValue(T data) {

        for(int currentIndex = size-1; currentIndex >= 0; currentIndex--){
            if(array[currentIndex].equals(data)){
                remove(currentIndex);
            }
        }

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> getIterator(){
        return new ArrayListIterator<>(this);
    }

    //internal methods

    private int getMaxCapacity() {
        return array.length;
    }

    private void increaseSize() {
        T []newArray = (T[])(new Object[array.length * 2]);

        //System.arraycopy(array, 0, newArray, 0, size);
        Iterator<T> iterator = getIterator();
        int newIndex = 0;

        while(iterator.hasNext()){
            newArray[newIndex] = iterator.next();
            newIndex++;
        }

        array = newArray;
    }

    private void decreaseSize() {
        T []newArray = (T[])(new Object[array.length / 2]);

        //System.arraycopy(array, 0, newArray, 0, size);
        Iterator<T> iterator = getIterator();
        int newIndex = 0;

        while(iterator.hasNext()){
            newArray[newIndex] = iterator.next();
            newIndex++;
        }

        array = newArray;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private boolean shouldDecrease() {
        return size < array.length / 4; //better amortized complexity for (hypothetical) pop/push use cases.
    }

    private boolean isInvalidIndex(int index){
        return index >= size || index < 0;
    }

    private Iterator<T> getIteratorAt(int index){
        return new ArrayListIterator<>(this, index);
    }

}
