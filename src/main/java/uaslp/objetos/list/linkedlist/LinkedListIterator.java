package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;

public class LinkedListIterator <T> implements Iterator<T> {

    private Node<T> currentNode;

    LinkedListIterator(Node<T> head) {
        currentNode = head;
    }

    public boolean hasNext() {
        return currentNode != null;
    }

    public T next() {
        T data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }

    public boolean hasPrevious() {
        return currentNode != null;
    }

    public T previous() {
        T data = currentNode.data;
        currentNode = currentNode.previous;
        return data;
    }

    //internal methods

    public Node<T> getCurrentNode() {
        return currentNode;
    }

}
