package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;

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
        T data = null;
        try{
            data = list.getAt(currentIndex);
        } catch(BadIndexException ignored){
        }
        currentIndex++;
        return data;
    }

    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    public T previous() {
        T data = null;
        try{
            data = list.getAt(currentIndex);
        } catch(BadIndexException ignored){
        }
        currentIndex--;
        return data;
    }

}
