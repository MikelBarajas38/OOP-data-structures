package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator implements Iterator {

    private int currentIndex;
    private final ArrayList list;

    ArrayListIterator(ArrayList list){
        this.list = list;
        currentIndex = 0;
    }

    ArrayListIterator(ArrayList list, int index){
        this.list = list;
        currentIndex = index;
    }

    public boolean hasNext() {
        return currentIndex < list.getSize();
    }

    public String next() {
        String data = list.getAt(currentIndex);
        currentIndex++;
        return data;
    }

    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    public String previous() {
        String data = list.getAt(currentIndex);
        currentIndex--;
        return data;
    }

}
