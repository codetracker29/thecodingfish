/*
 * Copyright (c) 2020.
 * @author: Srivastava Bodakunti
 */

package com.codingfish.ds.list;

public interface IList<T> {

    void add(T data);

    void addFirst(T data);

    void add(T data, int index);

    T get(int index);

    void set(T data, int index);

    int size();

    boolean isEmpty();

    T remove(int index);

    void delete(T data);

    void clear();

}
