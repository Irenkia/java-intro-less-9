package org.example;

public interface OwnList {

    int size();
    boolean isEmpty();
    void add(Integer element);
    Integer get(int i);
    void add(int index, Integer element);
    Integer remove(int index);
}
