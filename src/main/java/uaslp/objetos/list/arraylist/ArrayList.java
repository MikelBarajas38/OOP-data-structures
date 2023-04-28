package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayList <T> implements List<T> {

    private static final int INITIAL_SIZE = 2;
    private T []array;
    private int size;

    public ArrayList() {
        array = (T[])(new Object[INITIAL_SIZE]);
    }

    public void addAtTail(T data) throws NotNullAllowedException {

        validateData(data);

        validateArraySize();

        array[size] = data;
        size++;
    }

    public void addAtFront(T data) throws NotNullAllowedException {

        validateData(data);

        validateArraySize();

        Iterator<T> iterator = getIteratorAt(size-1);
        int currentIndex = size;

        while(iterator.hasPrevious()) {
            array[currentIndex] = iterator.previous();
            currentIndex--;
        }

        array[0] = data;
        size++;
    }

    public void remove(int index) throws BadIndexException {

        validateIndex(index);

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

    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException {

        validateData(data);

        validateIndex(index);

        array[index] = data;

    }

    public T getAt(int index) throws BadIndexException{

        validateIndex(index);

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

    private void validateArraySize() {
        if(isFull()) {
            increaseSize();
        }
    }

    private void validateIndex(int index) throws BadIndexException {
        if(isInvalidIndex(index)){
            throw new BadIndexException();
        }
    }

    private void validateData(T data) throws NotNullAllowedException {
        if(data == null) {
            throw new NotNullAllowedException();
        }
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
