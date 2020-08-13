/*
 * Copyright (c) 2020.
 * @author: Srivastava Bodakunti
 */

package com.codingfish.ds.list.impl;

import com.codingfish.ds.list.IList;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SinglyLinkedList<T> implements IList<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    @Override
    public void add(T data) {
        if (data == null)
            return;
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> lastNode = getLastNode(head);
            lastNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void addFirst(T data) {
        if (data == null)
            return;

        Node<T> newNode = new Node<>(data);

        if (head != null)
            newNode.setNext(head);

        head = newNode;
        size++;
    }

    @Override
    public void add(T data, int index) {
        if (data == null)
            return;

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size()) {
            add(data);
        } else if (index < size()) {
            Node<T> newNode = new Node<>(data);
            Node<T> beforeNode = getNode(index - 1);
            Node<T> afterNode = getNode(index);
            newNode.setNext(afterNode);
            assert beforeNode != null;
            beforeNode.setNext(newNode);
            size++;
        } else {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    @Override
    public T get(int index) {
        if (isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        } else {
            Node<T> cursorNode = head;
            for (int i = 0; i < index; i++) {
                cursorNode = cursorNode.getNext();
            }
            return cursorNode.data;
        }
    }

    @Override
    public void set(T data, int index) {
        if (data == null)
            return;

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size()) {
            add(data);
            return;
        }

        if (isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        } else {
            Node<T> cursorNode = head;
            for (int i = 0; i < index; i++) {
                cursorNode = cursorNode.getNext();
            }
            cursorNode.data = data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T remove(int index) {
        if (isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        } else {
            Node<T> cursorNode = head;
            for (int i = 0; i < index - 1; i++) {
                cursorNode = cursorNode.getNext();
            }
            T removed = cursorNode.getNext().data;
            cursorNode.next = cursorNode.getNext().getNext();
            size--;
            return removed;
        }
    }

    @Override
    public void delete(T data) {
        if (head != null) {
            Node<T> currentNode = head;
            Node<T> previousNode = head;

            while (currentNode != null) {
                if (currentNode.getData() == data) {
                    previousNode.setNext(currentNode.getNext());
                    break;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    @Override
    public void clear() {
        removeAllElements();
    }

    private synchronized void removeAllElements() {
        if (head != null) {
           for (Node<T> cursorNode = head; cursorNode != null;) {
               Node<T> next = cursorNode.getNext();
               cursorNode.data = null;
               cursorNode.next = null;
               size--;
               cursorNode = next;
           }
        }
    }

    private boolean isElementIndex(int index) {
        return index < 0 || index > size - 1;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /*Node<T> node(int index) {
        Node<T> cursor = head;
        for (int i = -1; i < index; i++) {
            cursor = cursor.getNext();
        }
       return cursor;
    }*/

    private Node<T> getLastNode(Node<T> node) {
        return node.getNext() != null ? getLastNode(node.getNext()) : node;
    }

    @Nullable
    private Node<T> getNode(int index) {
        if (isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        if (index == 0)
            return head;

        if (index == size() - 1)
            return getLastNode(head);

        int cursor = 0;
        Node<T> cursorNode = head;

        while (cursor <= index) {
            if (cursor == index) {
                return cursorNode;
            } else {
                if (cursorNode != null) {
                    cursorNode = next(cursorNode);
                }
                cursor++;
            }
        }
        return null;
    }

    private Node<T> next(Node<T> node) {
        return node.getNext() != null ? node.getNext() : null;
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder("[");
        Node<T> cursorNode = head;

        while (cursorNode != null) {
            format.append(cursorNode.toString());
            cursorNode = next(cursorNode);

            if (cursorNode != null) {
                format.append(", ");
            }
        }
        format.append("]");
        return format.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof SinglyLinkedList))
            return false;

        SinglyLinkedList<?> that = (SinglyLinkedList<?>) obj;

        if (size != that.size)
            return false;

        return Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }
}
