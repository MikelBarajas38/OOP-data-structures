package uaslp.objetos.list.linkedlist;

class Node <T>{

    T data;
    Node<T> next;
    Node<T> previous;

    Node() {
        data = null;
    }

    Node(T data) {
        this.data = data;
    }

}
