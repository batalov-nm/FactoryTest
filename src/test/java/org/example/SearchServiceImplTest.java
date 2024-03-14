package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {

    private final CreateAnimalService animalService = new CreateAnimalServiceImpl();
    private final SearchService searchService = new SearchServiceImpl();
//    private List<Animal> randomAnimals = animalService.generateAnimals();
    @Test
    void findLeapYearNames() {
        List<Animal> leapYearAnimalsList = new ArrayList<>(10);

        RandomDataGenerator rnd = new RandomDataGenerator();
        Animal leapYearAnimal = animalService.createSpecificAnimal(
                rnd.createRandomBreed(),
                rnd.createRandomName(),
                rnd.createRandomCost(),
                rnd.createRandomCharacter(),
                LocalDate.of(2024, 1, 12)
        );

        for (int i = 0; i < 10; i++){
            leapYearAnimalsList.add(leapYearAnimal);
        }
//        leapYearAnimalsList.forEach( (n) -> {
//            leapYearAnimalsList.set(leapYearAnimalsList.indexOf(n), leapYearAnimal);
//        });

        List<String> leapYearNamesList = searchService.findLeapYearNames(leapYearAnimalsList);
        System.out.println("Actual duplicates: " + leapYearAnimalsList.size());
        System.out.println("Duplicates found: " + leapYearNamesList.size());
        assertEquals(leapYearAnimalsList.size(), leapYearNamesList.size());
    }

//    @Test
//    void findOlderAnimals() {
//    }
//
//    @Test
//    void findDuplicate() {
//        CreateAnimalService af = new CreateAnimalServiceImpl();
//        List<Animal> sussyAnimals = af.generateAnimals();
//
//        sussyAnimals.remove(1);
//        sussyAnimals.set(1, sussyAnimals.get(0));
//
//        SearchService ss = new SearchServiceImpl();
//
//        ss.findDuplicate(sussyAnimals);
//    }
}