package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedList <T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addAtTail(T data) throws NotNullAllowedException {

        if(data == null) {
            throw new NotNullAllowedException();
        }

        Node<T> node = new Node<>(data);
        node.previous = tail;

        if(isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;

    }

    public void addAtFront(T data) throws NotNullAllowedException{

        if(data == null) {
            throw new NotNullAllowedException();
        }

        Node<T> node = new Node<>(data);
        node.next = head;

        if(isEmpty()){
            tail = node;
        } else {
            head.previous = node;
        }
        head = node;
        size++;

    }

    public void remove(int index) throws BadIndexException{

        if(isInvalidIndex(index)){
            throw new BadIndexException();
        }

        //cast is needed to make use of getCurrentNode internal method
        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        deleteNode(iterator.getCurrentNode());
        size--;

    }

    public void removeAll() {

        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();

        while(iterator.hasNext()) {
            Node<T> temp = iterator.getCurrentNode();
            iterator.next();
            deleteNode(temp);
        }
        size = 0;

    }

    public void setAt(int index, T data) throws BadIndexException, NotNullAllowedException{

        if(data == null) {
            throw new NotNullAllowedException();
        }

        if(isInvalidIndex(index)){
            throw new BadIndexException();
        }

        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }

        iterator.getCurrentNode().data = data;

    }

    public T getAt(int index) throws BadIndexException{

        if(isInvalidIndex(index)){
            throw new BadIndexException();
        }

        Iterator<T> iterator = getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        return iterator.next();

    }

    public void removeAllWithValue(T data){

        LinkedListIterator<T> iterator = (LinkedListIterator<T>) getIterator();

        while(iterator.hasNext()) {
            Node<T> temp = iterator.getCurrentNode();
            if(temp.data.equals(data)){ //compare value
                deleteNode(temp);
                size--;
            }
            iterator.next();
        }

    }

    public int getSize() {
        return size;
    }

    public Iterator<T> getIterator() {
        return new LinkedListIterator<>(head);
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    //internal methods

    private boolean isInvalidIndex(int index){
        return index >= size || index < 0;
    }

    private void deleteNode(Node<T> node) {

        //node doesn't exists
        if(node == null) {
            return;
        }

        //list contains single element
        if(head == node && tail == node){
            head = null;
            tail = null;
            return;
        }

        //delete first element
        if(head == node) {
            head = head.next;
            head.previous = null;
            return;
        }

        //delete last element
        if(tail == node) {
            tail = tail.previous;
            tail.next = null;
            return;
        }

        //delete any element
        node.previous.next = node.next;
        node.next.previous = node.previous;

    }

}
