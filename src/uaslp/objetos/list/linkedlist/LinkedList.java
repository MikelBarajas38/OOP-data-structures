package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class LinkedList implements List {

    private Node head;
    private Node tail;
    private int size;

    public void addAtTail(String data) {

        Node node = new Node(data);
        node.previous = tail;

        if(isEmpty()) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;

    }

    public void addAtFront(String data) {

        Node node = new Node(data);
        node.next = head;

        if(isEmpty()){
            tail = node;
        } else {
            head.previous = node;
        }
        head = node;
        size++;

    }

    public void remove(int index) {

        if(isInvalidIndex(index)){
            return; //error handling
        }

        //cast is needed to make use of getCurrentNode internal method
        LinkedListIterator iterator = (LinkedListIterator) getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        deleteNode(iterator.getCurrentNode());
        size--;

    }

    public void removeAll() {

        LinkedListIterator iterator = (LinkedListIterator) getIterator();

        while(iterator.hasNext()) {
            Node temp = iterator.getCurrentNode();
            iterator.next();
            deleteNode(temp);
        }
        size = 0;

    }

    public void setAt(int index, String data){

        if(isInvalidIndex(index)){
            return; //error handling
        }

        LinkedListIterator iterator = (LinkedListIterator) getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        iterator.getCurrentNode().data = data;

    }

    public String getAt(int index){

        if(isInvalidIndex(index)){
            return null; //error handling
        }

        Iterator iterator = getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        return iterator.next();

    }

    public void removeAllWithValue(String data){

        LinkedListIterator iterator = (LinkedListIterator) getIterator();

        while(iterator.hasNext()) {
            Node temp = iterator.getCurrentNode();
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

    public Iterator getIterator() {
        return new LinkedListIterator(head);
    }

    //internal methods

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    private boolean isInvalidIndex(int index){
        return index >= size || index < 0;
    }

    private void deleteNode(Node node) {

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
