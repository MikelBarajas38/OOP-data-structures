package uaslp.objetos.list.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public void addAtTail(String data) {

        Node node = new Node(data);
        node.setPrevious(tail);

        if(isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;

    }

    public void addAtFront(String data) {

        Node node = new Node(data);
        node.setNext(head);

        if(isEmpty()){
            tail = node;
        } else {
            head.setPrevious(node);
        }
        head = node;
        size++;

    }

    public void remove(int index) {

        if(isInvalidIndex(index)){
            return; //error handling
        }

        LinkedListIterator iterator = getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        deleteNode(iterator.getCurrentNode());
        size--;

    }

    public void removeAll() {

        LinkedListIterator iterator = getIterator();

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

        LinkedListIterator iterator = getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        iterator.getCurrentNode().setData(data);

    }

    public String getAt(int index){

        if(isInvalidIndex(index)){
            return null; //error handling
        }

        LinkedListIterator iterator = getIterator();
        int current_index = 0;

        while(iterator.hasNext() && current_index != index) {
            iterator.next();
            current_index++;
        }
        return iterator.next();

    }

    public void removeAllWithValue(String data){

        LinkedListIterator iterator = getIterator();

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

    public LinkedListIterator getIterator() {
        return new LinkedListIterator(head);
    }

    //helper Functions

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
