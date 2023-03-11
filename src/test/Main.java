package test;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {

        List list1 = new LinkedList();
        List list2 = new ArrayList();

        System.out.println("\nTest list1 (LinkedList)");
        testAddAtFront(list1);
        testAddAtTail(list1);
        testRemoveNthElement(list1);
        testSetAtIndex(list1);
        testGetAtIndex(list1);
        testRemoveAllWithValue(list1);

        System.out.println("\nTest list2 (ArrayList)");
        testAddAtFront(list2);
        testAddAtTail(list2);
        testRemoveNthElement(list2);
        testSetAtIndex(list2);
        testGetAtIndex(list2);
        testRemoveAllWithValue(list2);
    }

    private static void testRemoveAllWithValue(List list) {
        System.out.println("\n-> Test remove all with value.");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("B");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("A");
        printList(list);
        System.out.println("Size: " + list.getSize() + " Capacity: ");
        list.removeAllWithValue("A");
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAllWithValue("B");
        printList(list);
        System.out.println("Size: " + list.getSize());
    }

    private static void testGetAtIndex(List list) {
        System.out.println("\n-> Test get at index.");
        list.addAtTail("0");
        list.addAtTail("1");
        list.addAtTail("2");
        printList(list);
        System.out.println(list.getAt(0));
        System.out.println(list.getAt(1));
        System.out.println(list.getAt(2));
        System.out.println(list.getAt(3));
        list.removeAll();
    }

    private static void testSetAtIndex(List list) {
        System.out.println("\n-> Test set at index.");
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
    }

    private static void testRemoveNthElement(List list) {
        System.out.println("\n-> Test remove nth-element.");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        list.addAtTail("D");
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(4);
        list.remove(3);
        list.remove(1);
        list.remove(0);
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(0);
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.remove(0);
    }

    private static void testAddAtTail(List list) {
        System.out.println("\n-> Test add at Tail.");
        list.addAtTail("A");
        list.addAtTail("B");
        list.addAtTail("C");
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAll();
    }

    private static void testAddAtFront(List list) {
        System.out.println("\n-> Test add at Front.");
        list.addAtFront("A");
        list.addAtFront("B");
        list.addAtFront("C");
        printList(list);
        System.out.println("Size: " + list.getSize());
        list.removeAll();
    }

    public static void printList(List list) {
        Iterator it = list.getIterator();
        System.out.print("List contents: ");
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.print("\n");
    }
    
}
