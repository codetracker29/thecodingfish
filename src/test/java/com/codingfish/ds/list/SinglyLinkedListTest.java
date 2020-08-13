/*
 * Copyright (c) 2020.
 * @author: Srivastava Bodakunti
 */

package com.codingfish.ds.list;

import com.codingfish.ds.list.impl.SinglyLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SinglyLinkedListTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSinglyLinkedListGet() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        // no data added, should produce IndexOutOfBoundsException
        assertEquals(3, (long) linkedList.get(2));
    }

    @Test
    public void testSinglyLinkedListIntegerAdd() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        assertEquals(1, (long) linkedList.get(0));
        linkedList.add(2);
        linkedList.add(3);
        assertEquals(1, (long) linkedList.get(0));
        assertEquals(2, (long) linkedList.get(1));
        assertEquals(3, (long) linkedList.get(2));
        linkedList.addFirst(0);
        assertEquals(0, (long) linkedList.get(0));
    }

    @Test
    public void testSinglyLinkedListIntegerSet() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.addFirst(0);
        linkedList.add(2);
        linkedList.add(1, 1);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.set(4, 4);
        assertEquals("[0, 1, 2, 3, 4]", linkedList.toString());
        linkedList.set(7, 3);
        assertEquals("[0, 1, 2, 7, 4]", linkedList.toString());
    }

    @Test
    public void testSinglyLinkedListIntegerRemoveValueAtIndex() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertEquals(4, linkedList.size());
        assertEquals(2, (long) linkedList.remove(1));
        assertEquals(3, linkedList.size());
        assertEquals(3, (long) linkedList.remove(1));
    }

    @Test
    public void testSinglyLinkedListIntegerDelete() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.delete(2);
        assertEquals("[1, 3, 4]", linkedList.toString());
    }

    @Test
    public void testSinglyLinkedListIntegerSize() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertEquals(4, linkedList.size());
        linkedList.add(5, 2);
        assertEquals(5, linkedList.size());
    }

    @Test
    public void testSinglyLinkedListIntegerClear() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.clear();
        assertEquals("[]", linkedList.toString());
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testSinglyLinkedListIntegerIsEmpty() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testSinglyLinkedListIntegerToString() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        assertEquals("[1, 2, 3, 4]", linkedList.toString());
        linkedList.add(5, 2);
        assertEquals("[1, 2, 5, 3, 4]", linkedList.toString());
    }

    @Test
    public void testSinglyLinkedListStringAdd() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("hello1");
        assertEquals("hello1", linkedList.get(0));
        linkedList.add("hello2");
        linkedList.add("hello3");
        assertEquals("hello1", linkedList.get(0));
        assertEquals("hello2", linkedList.get(1));
        assertEquals("hello3", linkedList.get(2));
        linkedList.addFirst("hello0");
        assertEquals("hello0", linkedList.get(0));
    }

    @Test
    public void testSinglyLinkedListStringSet() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.addFirst("hello0");
        linkedList.add("hello2");
        linkedList.add("hello1", 1);
        linkedList.add("hello3");
        linkedList.add("hello5");
        linkedList.set("hello4", 4);
        assertEquals("[hello0, hello1, hello2, hello3, hello4]", linkedList.toString());
        linkedList.set("hello7", 3);
        assertEquals("[hello0, hello1, hello2, hello7, hello4]", linkedList.toString());
    }

    @Test
    public void testSinglyLinkedListStringRemoveValueAtIndex() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("hello1");
        linkedList.add("hello2");
        linkedList.add("hello3");
        linkedList.add("hello4");
        assertEquals(4, linkedList.size());
        assertEquals("hello2", linkedList.remove(1));
        assertEquals(3, linkedList.size());
        assertEquals("hello3", linkedList.remove(1));
    }
}
