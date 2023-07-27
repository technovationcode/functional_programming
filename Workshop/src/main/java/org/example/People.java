package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class People {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Jose", "Monterrey", 35),
                new Person("Juan", "Ciudad de Mexico", 25),
                new Person("Pedro", "Monterrey", 19),
                new Person("Ivan", "Merida", 23),
                new Person("Kevin", "Merida", 40),
                new Person("Ignacio", "Monterrey", 39),
                new Person("Ernesto", "Monterrey", 21),
                new Person("Josh", "Los Angeles", 42)
        );


        declarative(people);

    }

    public static void declarative(List<Person> people) {
        // Filter people from Monterrey
        System.out.println("People from Monterrey: ");
        people.stream()
                .filter(person -> person.getCity().equals("Monterrey"))
                .map(Person::getName)
                .forEach(System.out::println);
        // Filter people younger than 30
        System.out.println("People younger than 30: ");
        people.stream()
                .filter(person -> person.getAge() < 30)
                .map(Person::getName)
                .forEach(System.out::println);
        // Get just the names of the people and then group it by City
        System.out.println("Grouping: ");
        System.out.println(people.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.toList()))));

    }

    public static void imperative(List<Person> people) {
        // Filter people from Monterrey
        System.out.println("People from Monterrey: ");
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getCity().equals("Monterrey"))
                System.out.println(people.get(i).getName());
        }
        // Filter people younger than 30
        System.out.println("People younger than 30: ");
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getAge() < 30)
                System.out.println(people.get(i).getName());
        }
        // Get just the names of the people and then group it by City
        System.out.println("Grouping: ");
        HashMap<String, List<String>> groups = new HashMap<>();
        for(int i = 0; i < people.size(); i++){
            if(!groups.containsKey(people.get(i).getCity())){
                groups.put(people.get(i).getCity(), updateList(new ArrayList<>(), people.get(i).getName()));
            } else {
                groups.put(people.get(i).getCity(), updateList((ArrayList<String>) groups.get(people.get(i).getCity()), people.get(i).getName()));
            }
        }
        System.out.println(groups);
    }

    public static ArrayList<String> updateList(ArrayList<String> names, String name){
        ArrayList<String> updatedList = new ArrayList<>(names);
        updatedList.add(name);
        return updatedList;
    }
}

