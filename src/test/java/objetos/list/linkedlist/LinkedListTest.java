package objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;
import uaslp.objetos.list.linkedlist.LinkedList;

public class LinkedListTest {

    @Test
    public void whenListIsCreated_thenItIsEmpty() {

        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        //then
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0, size);

    }

    @Test
    public void givenAnEmptyList_whenAddAtTail_thenFirstElementIsInserted() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.addAtTail("1");

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
    }

    @Test
    public void givenAnNonEmptyList_whenAddAtTail_thenElementIsInserted() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.addAtTail("1");
        list.addAtTail("2");

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("2", list.getAt(list.getSize() - 1));
    }

    @Test
    public void givenAnEmptyList_whenAddAtFront_thenFirstElementIsInserted() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.addAtFront("1");

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
    }

    @Test
    public void givenAnNonEmptyList_whenAddAtFront_thenElementIsInserted() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.addAtFront("1");
        list.addAtFront("2");

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("2", list.getAt(0));
    }

    @Test
    public void whenNullIsAdded_thenNotNullAllowedExceptionIsThrown() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when - then
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.addAtTail(null));
    }

    @Test
    public void whenElementIsRemoved_thenElementGetsDeleted() {
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        list.addAtTail("3");

        //when
        list.remove(1);

        //then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("1", list.getAt(0));
        Assertions.assertEquals("3", list.getAt(1));

    }

    @Test
    public void givenListWithOneElement_whenElementIsRemoved_thenListIsEmpty() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");

        //when
        list.remove(0);

        //then
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void whenFirstElementIsRemoved_thenHeadChanges() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");

        //when
        list.remove(0);

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("2", list.getAt(0));
    }

    @Test
    public void whenLastElementIsRemoved_thenTailChanges() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");

        //when
        list.remove(1);

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("1", list.getAt(list.getSize() - 1));
    }

    @Test
    public void givenAnEmptyList_whenRemoveAll_thenNothingHappens() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when
        list.removeAll();

        //then
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAnNonEmptyList_whenRemoveAll_listIsEmptied() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        list.addAtTail("3");

        //when
        list.removeAll();

        //then
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void whenRemoveAllWithValueX_allElementsXAreRemoved() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        list.addAtTail("1");
        list.addAtTail("1");

        //when
        list.removeAllWithValue("1");

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("2", list.getAt(0));
    }

    @Test
    public void whenSetAt_ElementIsModified() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");


        //when
        list.setAt(0,"A");
        list.setAt(1,"B");

        //then
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("A", list.getAt(0));
        Assertions.assertEquals("B", list.getAt(1));
    }

    @Test
    public void whenSetAtIsNull_thenNotNullAllowedExceptionIsThrown() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");


        //when - then
        Assertions.assertThrows(NotNullAllowedException.class, () -> list.setAt(0, null));
    }

    @Test
    public void whenInvalidIndexIsAccessed_thenBadIndexExceptionIsThrown() {
        //given
        LinkedList<String> list = new LinkedList<>();

        //when - then
        Assertions.assertThrows(BadIndexException.class, () -> list.getAt(0));
        Assertions.assertThrows(BadIndexException.class, () -> list.setAt(0, "1"));
        Assertions.assertThrows(BadIndexException.class, () -> list.remove(0));
    }

    @Test
    public void whenPrev_thenIteratorMoves() {
        //given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("1");
        list.addAtTail("2");
        list.addAtTail("3");

        Iterator<String> iterator = list.getIterator();
        iterator.next();
        iterator.next();

        //when
        iterator.previous();
        iterator.previous();

        //then
        String data = iterator.previous();
        Assertions.assertFalse(iterator.hasPrevious());
        Assertions.assertEquals(data, list.getAt(0));
    }

}
