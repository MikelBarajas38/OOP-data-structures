package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList implements List {

    private static final int INITIAL_SIZE = 2;
    private static final String DELETE_VALUE = null;
    private String []array;
    private int size;

    public ArrayList() {
        array = new String[INITIAL_SIZE];
    }

    public void addAtTail(String data) {

        if(isFull()) {
            increaseSize();
        }

        array[size] = data;
        size++;
    }

    public void addAtFront(String data) {

        if(isFull()) {
            increaseSize();
        }

        Iterator iterator = getIteratorAt(size-1);
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

        array[index] = DELETE_VALUE;

        cleanList();
    }

    //logical deletion, taking advantage of garbage collector
    public void removeAll() {
        array = new String[INITIAL_SIZE];
        size = 0;
    }

    public void setAt(int index, String data) {

        if(isInvalidIndex(index)){
            return; //error handling
        }

        array[index] = data;

    }

    public String getAt(int index) {

        if(isInvalidIndex(index)){
            return null; //error handling
        }

        return array[index];

    }

    public void removeAllWithValue(String data) {

        Iterator iterator = getIterator();
        int currentIndex = 0;

        while(iterator.hasNext()){
            String currentData = iterator.next();
            if(currentData.equals(data)){
                array[currentIndex] = DELETE_VALUE;
            }
            currentIndex++;
        }

        cleanList();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator getIterator(){
        return new ArrayListIterator(this);
    }

    //internal methods

    private int getMaxCapacity() {
        return array.length;
    }

    //probably a bad idea, wouldn't allow storing null strings in list. O(n)
    private void cleanList() {

        String []newArray = new String[array.length];

        Iterator iterator = getIterator();
        int newIndex = 0;
        int itemsDeleted = 0;

        while(iterator.hasNext()){
            String data = iterator.next();
            if(data != DELETE_VALUE){
                newArray[newIndex] = data;
                newIndex++;
            } else {
                itemsDeleted++;
            }
        }

        array = newArray;
        size -= itemsDeleted;

        if(shouldDecrease()){
            decreaseSize();
        }

    }

    private void increaseSize() {
        String []newArray = new String[array.length * 2];

        //System.arraycopy(array, 0, newArray, 0, size);
        Iterator iterator = getIterator();
        int newIndex = 0;

        while(iterator.hasNext()){
            newArray[newIndex] = iterator.next();
            newIndex++;
        }

        array = newArray;
    }

    private void decreaseSize() {
        String []newArray = new String[array.length / 2];

        //System.arraycopy(array, 0, newArray, 0, size);
        Iterator iterator = getIterator();
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

    private Iterator getIteratorAt(int index){
        return new ArrayListIterator(this, index);
    }

}
