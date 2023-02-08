package uaslp.objetos.list.linkedlist;

public class LinkedListIterator {

    private Node currentNode;

    LinkedListIterator(Node head) {
        currentNode = head;
    }

    public boolean hasNext() {
        return currentNode != null;
    }

    public String next() {
        String data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }

    //helper functions

    public Node getCurrentNode() {
        return currentNode;
    }
}
