package org.example;

import java.util.*;
import java.util.Collections;

public class ListExample {
    public static void main(String[] args) {
        printList();
        System.out.println();
        printListWithoutDuplicates(names);
        System.out.println();
        printListReverse(names);
        System.out.println();
        printListReplaceOneWordWithAnother(names, "Anna", "Joann");
    }

    private static List<String> names = Arrays.asList("Anna", "Katarzyna", "Tymon", "Tadeusz", "Anna", "Karolina", "Dorota", "Piotr");

    public static List<String> getNames() {
        return names;
    }

    public static void printList() {
        List<String> newNames = getNames();
        System.out.println(newNames);
    }

    public static void printListWithoutDuplicates(List<String> names) {
        Set<String> newNames = new HashSet<>();
        newNames.addAll(names);
        System.out.println(newNames);
    }

    public static void printListReverse(List<String> names) {
        Collections.reverse(names);
        System.out.println(names);
    }

    public static void printListReplaceOneWordWithAnother(List<String> names, String oldWord, String newWord) {
        if (names.contains(oldWord)) {
            List<String> newNames = new LinkedList<>();
            newNames.addAll(names);
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).equals(oldWord)) {
                    newNames.set(i, newWord);
                }
            }
            System.out.println(newNames);
        } else {
            System.out.println("Word \"" + oldWord + "\" does not exist in the list");
        }
    }

}
