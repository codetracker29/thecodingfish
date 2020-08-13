/*
 * Copyright (c) 2020.
 * @author: Srivastava Bodakunti
 */

package com.codingfish.ds.list.impl;

import lombok.Getter;
import lombok.Setter;

class Node<T> {

    @Getter
    @Setter
    public T data;

    @Getter
    @Setter
    public Node<T> next;

    public Node() {

    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> link) {
        this.data = data;
        this.next = link;
    }

    @Override
    public String toString() {
        if (data != null) {
            return this.data.toString();
        } else {
            return "";
        }
    }
}
