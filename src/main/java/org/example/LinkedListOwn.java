package org.example;

import java.util.Arrays;

public class LinkedListOwn<I extends String> {
    public static void main(String[] args) {
        LinkedListOwn<String> cars = new LinkedListOwn();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        printOwnLinkedList(cars.ownLinkedList);
        System.out.println("\nsize = " + cars.size() + "\n");

        System.out.println("Add elements \"KIA\" in owm LinkedList in index \"2\"");
        cars.add(2, "KIA");
        printOwnLinkedList(cars.ownLinkedList);
        System.out.println("\nsize = " + cars.size() + "\n");

        System.out.println("Remove element from index \"3\" = ");
        cars.remove(3);
        printOwnLinkedList(cars.ownLinkedList);
        System.out.println("\nsize = " + cars.size() + "\n");

        System.out.println("\nAdd elements \"Suzuki\" in owm LinkedList in index \"12\"");
        try {
            cars.add(12, "Suzuki");
        }catch (Exception e){
            e.getMessage();
            System.out.println("- this index does not exist");
        }

        System.out.println("\nRemove elements in owm LinkedList from index \"12\"");
        try {
            cars.remove(12);
        }catch (Exception e){
            e.getMessage();
            System.out.println("- this index does not exist");
        }
    }
    private int length = 10;
    private int newLength = 10 * 2;
    private Object[] ownLinkedList;
    private int pointer = 0;

    public LinkedListOwn() {
        ownLinkedList = new Object[length];
    }

    public int size() {
        return pointer;
    }

    public void add(String element) {
        if (pointer == ownLinkedList.length - 1) {
            resize(newLength);
        }
        ownLinkedList[pointer++] = element;
    }

    public void add(int index, String element) {
        if (index >= pointer) {
            throw new IndexOutOfBoundsException();
        }
        Object temp;
        if (pointer == ownLinkedList.length - 1) {
            resize(newLength);
            temp = ownLinkedList[index];
            ownLinkedList[index] = element;
            ownLinkedList[pointer++] = temp;
        } else {
            pointer++;
            for (int i = pointer; i > index; i--) {
                ownLinkedList[i] = ownLinkedList[i - 1];
            }
            ownLinkedList[index] = element;
        }
    }

    public void remove(int index) {
        if (index >= pointer) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < pointer; i++) {
            ownLinkedList[i] = ownLinkedList[i + 1];
        }
        pointer--;
    }

    public void resize(int newLength) {
        ownLinkedList = Arrays.copyOf(ownLinkedList, newLength);
    }

    private static void printOwnLinkedList(Object[] ownLinkedList) {
        for (Object el : ownLinkedList) {
            System.out.print(el + " ");
        }
    }
}
