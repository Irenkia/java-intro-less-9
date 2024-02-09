package org.example;

import java.util.*;

public class Person implements Comparable<Person> {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Dave", "Robinson", 1994, 170, 80));
        list.add(new Person("Glen", "Scott", 1999, 160, 60));
        list.add(new Person("Alexis", "Clark", 1991, 180, 90));
        list.add(new Person("Martin", "Morgan", 2002, 165, 55));
        list.add(new Person("Ted", "Smith", 1984, 175, 70));
        list.forEach(System.out::println);
        System.out.println("\n----------from List----------\n");

        Collections.sort(list);
        list.forEach((person -> {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());
        }));
        System.out.println();

        Collections.sort(list, Comparator.comparing(Person::getHeight));
        list.forEach((person -> {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getHeight());
        }));
        System.out.println();

        Collections.sort(list, Comparator.comparing(Person::getWeight).reversed());
        list.forEach((person -> {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getWeight());
        }));

        System.out.println("\n----------from TreeSet----------\n");
        TreeSet<Person> set = new TreeSet<>();
        set.addAll(list);
        set.forEach(person -> {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());
        });
        System.out.println();

        set = new TreeSet<>(Comparator.comparing(Person::getHeight));
        set.addAll(list);
        set.forEach(person -> {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getHeight());
        });
        System.out.println();

        set = new TreeSet<>(Comparator.comparing(Person::getWeight).reversed());
        set.addAll(list);
        set.forEach(person -> {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getWeight());
        });
    }

    private String name;
    private String surname;
    private int age;
    private int height;
    private int weight;

    public Person(String name, String surname, int age, int height, int weight) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.getAge();
    }

}

