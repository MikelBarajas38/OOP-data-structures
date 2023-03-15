package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator <T> implements Iterator<T> {

    private int currentIndex;
    private final ArrayList<T> list;

    ArrayListIterator(ArrayList<T> list){
        this.list = list;
        currentIndex = 0;
    }

    ArrayListIterator(ArrayList<T> list, int index){
        this.list = list;
        currentIndex = index;
    }

    public boolean hasNext() {
        return currentIndex < list.getSize();
    }

    public T next() {
        T data = list.getAt(currentIndex);
        currentIndex++;
        return data;
    }

    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    public T previous() {
        T data = list.getAt(currentIndex);
        currentIndex--;
        return data;
    }

}
