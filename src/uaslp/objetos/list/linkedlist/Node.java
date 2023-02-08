package uaslp.objetos.list.linkedlist;

public class Node {

    String data;
    Node next;
    Node previous;

    Node() {
        data = null;
    }

    Node(String data) {
        this.data = data;
    }
}
