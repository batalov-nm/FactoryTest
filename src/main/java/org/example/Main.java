package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CreateAnimalService af = new CreateAnimalServiceImpl();
        List<Animal> sussyAnimals = af.generateAnimals();

        sussyAnimals.remove(1);
        sussyAnimals.set(1, sussyAnimals.get(0));

        System.out.println("EQUALS: " + sussyAnimals.get(3).equals(sussyAnimals.get(5)));
        System.out.println("EQUALS: " + sussyAnimals.get(0).equals(sussyAnimals.get(1)));


        SearchService ss = new SearchServiceImpl();

        System.out.println(ss.findLeapYearNames(sussyAnimals));
        System.out.println(ss.findDuplicate(sussyAnimals));
        System.out.println(ss.findOlderAnimals(sussyAnimals, 40));
    }
}