package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {

    private final CreateAnimalService animalService = new CreateAnimalServiceImpl();
    private final SearchService searchService = new SearchServiceImpl();
//    private List<Animal> randomAnimals = animalService.generateAnimals();

    static Stream<Arguments> getPetInfo() {
        return Stream.of(
                Arguments.of(1, "Cat", "SAS", "10.1", "TEST", LocalDate.of(2020, 1, 12)),
                Arguments.of(2, "Shark", "SAS", "10.1", "TEST", LocalDate.of(2016, 1, 12)),
                Arguments.of(3, "Dog", "SAS", "10.1", "TEST", LocalDate.now().minusDays(new Random().nextInt(100))),
                Arguments.of(4, "Wolf", "SAS", "15.2", "TESTTEST", LocalDate.of(1925, 1, 12))
        );
    }

    @ParameterizedTest(name = "Test number: {0}")
    @MethodSource("getPetInfo")
    void findLeapYearNames(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
        List<Animal> leapYearAnimalsList = new ArrayList<>();

        Animal leapYearAnimal = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);

        if (leapYearAnimal.getBirthDate().getYear() % 4 == 0){
            for (int i = 0; i < 10; i++){
                leapYearAnimalsList.add(leapYearAnimal);
            }
        }

        List<String> leapYearNamesList = searchService.findLeapYearNames(leapYearAnimalsList);

        System.out.println("Test number: " + testNumber);
        System.out.println("Actual duplicates: " + leapYearAnimalsList.size());
        System.out.println("Duplicates found: " + leapYearNamesList.size() + "\n");

        assertEquals(leapYearAnimalsList.size(), leapYearNamesList.size());
    }

    @ParameterizedTest(name = "Test number: {0}")
    @MethodSource("getPetInfo")
    void findOlderAnimals(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
        List<Animal> newAnimalList = animalService.generateAnimals();
        Animal newAnimal = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        newAnimalList.set(0, newAnimal);

        int randomAge = new Random().nextInt(50);

        List<Animal> returnList = searchService.findOlderAnimals(newAnimalList, randomAge);

        System.out.println("Test number: " + testNumber + " (age: >" + randomAge + ")");
        System.out.println("Initial list: " + newAnimalList);
        System.out.println("Older animals: " + returnList + "\n");
//        assertEquals(); // fixme Какой из параметров можно сравнить, чтобы это имело смысл?
    }

    @ParameterizedTest(name = "Test number: {0}")
    @ValueSource(ints = {2, 3, 5, 4, 8})
    void findDuplicate(int duplicateIndex) {
        List<Animal> sussyAnimals = animalService.generateAnimals();

        for (int i = 0; i < duplicateIndex; i++){
            sussyAnimals.set(i, sussyAnimals.get(0));
        }

        List<Animal> findDuplicateTestList = searchService.findDuplicate(sussyAnimals);

        System.out.println("Initial list: " + sussyAnimals);
        System.out.println("Duplicate list: " + findDuplicateTestList + "\n");

        assertEquals(findDuplicateTestList.size(), duplicateIndex-1);
    }
}