package test;

import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("\nTest 1 (add at Front)");
        list.addAtFront("A");
        list.addAtFront("B");
        list.addAtFront("C");
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAll();

        System.out.println("\nTest 2 (add at Tail)");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAll();

        System.out.println("\nTest 3 (remove nth-element)");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        list.addAtTail("D");
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(4);
        list.remove(3);
        list.remove(1);
        list.remove(0);
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(0);
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(0);

        System.out.println("\nTest 4 (set at index)");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        list.addAtTail("D");
        printLinkedList(list);
        list.setAt(0,"X");
        list.setAt(1,"Y");
        list.setAt(3,"Z");
        list.setAt(4,"ERROR");
        printLinkedList(list);
        list.removeAll();

        System.out.println("\nTest 5 (get at index)");
        list.addAtTail("0");
        list.addAtTail("1");
        list.addAtTail("2");
        printLinkedList(list);
        System.out.println(list.getAt(0));
        System.out.println(list.getAt(1));
        System.out.println(list.getAt(2));
        System.out.println(list.getAt(3));
        list.removeAll();

        System.out.println("\nTest 5 (remove all with value)");
        list.addAtTail("A");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("A");
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAllWithValue("A");
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAllWithValue("B");
        printLinkedList(list);
        System.out.println("Size: " + list.getSize());

    }

    public static void printLinkedList(LinkedList list) {
        LinkedListIterator it = list.getIterator();
        System.out.print("head");
        while(it.hasNext()){
            System.out.print(" - " + it.next());
        }
        System.out.print(" - tail\n");
    }
}
