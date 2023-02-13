package test;

import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayListIterator;
import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

public class Main {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        System.out.println("\nTest 1 (add at Front)");
        list.addAtFront("A");
        list.addAtFront("B");
        list.addAtFront("C");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());
        list.removeAll();

        System.out.println("\nTest 2 (add at Tail)");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());
        list.removeAll();

        System.out.println("\nTest 3 (remove nth-element)");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        list.addAtTail("D");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());
        list.remove(4);
        list.remove(3);
        list.remove(1);
        list.remove(0);
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());
        list.remove(0);
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());
        list.remove(0);

        System.out.println("\nTest 4 (set at index)");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        list.addAtTail("D");
        printList(list);
        list.setAt(0,"X");
        list.setAt(1,"Y");
        list.setAt(3,"Z");
        list.setAt(4,"ERROR");
        printList(list);
        list.removeAll();

        System.out.println("\nTest 5 (get at index)");
        list.addAtTail("0");
        list.addAtTail("1");
        list.addAtTail("2");
        printList(list);
        System.out.println(list.getAt(0));
        System.out.println(list.getAt(1));
        System.out.println(list.getAt(2));
        System.out.println(list.getAt(3));
        list.removeAll();

        System.out.println("\nTest 5 (remove all with value)");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("B");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("A");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());
        list.removeAllWithValue("A");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());
        list.removeAllWithValue("B");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: " + list.getMaxCapacity());

    }

    public static void printList(LinkedList list) {
        LinkedListIterator it = list.getIterator();
        System.out.print("head");
        while(it.hasNext()){
            System.out.print(" - " + it.next());
        }
        System.out.print(" - tail\n");
    }

    public static void printList(ArrayList list) {

        ArrayListIterator it = list.getIterator();
        System.out.print("array: ");
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
    
}
