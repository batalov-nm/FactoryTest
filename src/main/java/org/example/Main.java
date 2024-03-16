package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CreateAnimalService as = new CreateAnimalServiceImpl();
        List<Animal> newTenAnimalsList = as.generateAnimals();
//        List<Animal> newNAnimalsList = as.generateAnimals(15); // fixme не перегружается метод в CreateAnimalServiceImpl

        SearchService ss = new SearchServiceImpl();

        System.out.println(newTenAnimalsList);
        System.out.println(ss.findLeapYearNames(newTenAnimalsList));
        System.out.println(ss.findDuplicate(newTenAnimalsList));
        System.out.println(ss.findOlderAnimals(newTenAnimalsList, 40));
    }
}