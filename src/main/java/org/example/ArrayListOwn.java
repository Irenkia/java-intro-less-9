package org.example;

import java.util.Arrays;

public class ArrayListOwn<I extends Integer> implements OwnList {
    public static void main(String[] args) {
        ArrayListOwn<Integer> list = new ArrayListOwn();
        System.out.println(list.getClass());
        System.out.println("Add elements in owm ArrayList");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        printOwnList(list.ownList);
        System.out.println("\nsize = " + list.size() + "\n");

        System.out.println("Remove element from index \"3\" = " + list.remove(3));
        printOwnList(list.ownList);
        System.out.println("\nsize = " + list.size() + "\n");

        System.out.println("Add elements \"55\" in owm ArrayList in index \"7\"");
        list.add(7, 55);
        printOwnList(list.ownList);
        System.out.println("\nsize = " + list.size() + "\n");

        printOwnList(list.ownList);
        System.out.println("\nsize = " + list.size() + "\n");

        System.out.println("Add elements \"55\" in owm ArrayList in index \"8\"");
        list.add(8, 55);
        printOwnList(list.ownList);
        System.out.println("\nsize = " + list.size() + "\n");

        System.out.println("list is empty = " + list.isEmpty());
        System.out.println("get element from index \"3\" = " + list.get(3));

        System.out.println("\nAdd elements \"55\" in owm ArrayList in index \"12\"");
        try {
            list.add(12, 55);
        }catch (Exception e){
            e.getMessage();
            System.out.println("- this index does not exist");
        }

        System.out.println("\nRemove elements in owm ArrayList from index \"12\"");
        try {
            list.remove(12);
        }catch (Exception e){
            e.getMessage();
            System.out.println("- this index does not exist");
        }
    }

    private int length = 10;
    private int newLength = 10 * 2;
    private Object[] ownList;
    private int pointer = 0;

    public ArrayListOwn() {
        ownList = new Object[length];
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    @Override
    public void add(Integer element) {
        if (pointer == ownList.length - 1) {
            resize(ownList.length * 2);
        }
        ownList[pointer++] = element;
    }

    @Override
    public Integer get(int i) {
        if (i >= pointer) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer) ownList[i];
    }

    @Override
    public void add(int index, Integer element) {
        if (index >= pointer) {
            throw new IndexOutOfBoundsException();
        }
        Object temp;
        if (pointer == ownList.length - 1) {
            resize(ownList.length * 2);
            temp = ownList[index];
            ownList[index] = element;
            ownList[pointer++] = temp;
        } else {
            pointer++;
            for (int i = pointer; i > index; i--) {
                ownList[i] = ownList[i - 1];
            }
            ownList[index] = element;
        }
    }

    @Override
    public Integer remove(int index) {
        if (index >= pointer) {
            throw new IndexOutOfBoundsException();
        }
        Integer element = get(index);
        for (int i = index; i < pointer; i++) {
            ownList[i] = ownList[i + 1];
        }
        pointer--;
        return element;
    }

    public void resize(int newLength) {
        ownList = Arrays.copyOf(ownList, newLength);
    }

    private static void printOwnList(Object[] ownList) {
        for (Object el : ownList) {
            System.out.print(el + " ");
        }
    }

}
