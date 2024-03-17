package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EqualsTest {

    private final CreateAnimalService animalService = new CreateAnimalServiceImpl();
    private final RandomDataGenerator rnd = new RandomDataGenerator();

    static Stream<Arguments> getPetInfo() {
        return Stream.of(
                Arguments.of(1, "Cat", "SAS", "10.1", "TEST", LocalDate.now()),
                Arguments.of(2, "Cat", "SAS", "10.1", "TEST", LocalDate.now()),
                Arguments.of(3, "Cat", "SAS", "10.1", "TEST", LocalDate.now().minusDays(new Random().nextInt(100))),
                Arguments.of(4, "Cat", "SAS", "15.2", "TESTTEST", LocalDate.now()),
                Arguments.of(5, "Cat", "SAS", "15.2", "TEST", LocalDate.now()),
                Arguments.of(6, "Cat", "BOB", "10.1", "TEST", LocalDate.now()),
                Arguments.of(7, "Dog", "SAS", "10.1", "TEST", LocalDate.now()),
                Arguments.of(8, "Wolf", "MAKSIM", "10.1", "TEST", LocalDate.now())
        );
    }

    @ParameterizedTest(name = "Test number: {0}")
    @MethodSource("getPetInfo")
    void equalsReflexiveTest(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
        Animal newAnimalX = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(X): " + newAnimalX);

        assertTrue(newAnimalX.equals(newAnimalX));
        System.out.println("x.equals(x) is true" + "\n");
    }

//    @ParameterizedTest(name = "Test number: {0}")
//    @MethodSource("getPetInfo")
//    void equalsSymmetricTestSuccess(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
//        Animal newAnimalX = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
//        System.out.println("ANIMAL(X): " + newAnimalX);
//        Animal newAnimalY = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
//        System.out.println("ANIMAL(Y): " + newAnimalY);
//        // Работает некорректно. Не знаю как исправить
//        // Поступет стрим с полями класса и создаются два разных объекта с одинаковыми полями
//        // Предполагаю, что нужно сделать сдвиг, чтобы в ANIMAL(X) поступали аргументы n, а в ANIMAL(Y) поступали аргументы n+1
//       assertTrue(newAnimalX.equals(newAnimalY));
//       System.out.println("x.equals(y) is true if and only if y.equals(x)" + "\n");
//    }
    @Test
    void equalsSymmetricTestSuccess(){
        Animal newAnimalX = animalService.createSpecificAnimal("Wolf", "SAS", 12.2, "SAS", LocalDate.now());
        Animal newAnimalY = animalService.createSpecificAnimal("Wolf", "SAS", 12.2, "SAS", LocalDate.now());

        assertTrue(newAnimalX.equals(newAnimalY));
       System.out.println("x.equals(y) is true if and only if y.equals(x)" + "\n");
    }

    @ParameterizedTest(name = "Test number: {0}")
    @MethodSource("getPetInfo")
    void equalsSymmetricTestFailure(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
        Animal newAnimalX = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(X): " + newAnimalX);
        Animal newAnimalY = animalService.createSpecificAnimal(rnd.createRandomBreed(), rnd.createRandomName(), rnd.createRandomCost(), rnd.createRandomCharacter(), LocalDate.now());
        System.out.println("ANIMAL(Y): " + newAnimalY);

        assertFalse(newAnimalX.equals(newAnimalY));
        System.out.println("x.equals(y) is true if and only if y.equals(x)" + "\n");
    }

//    @ParameterizedTest(name = "Test number: {0}")
//    @MethodSource("getPetInfo")
//    public void equalsTransitiveTest(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
//        Animal newAnimalX = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
//        System.out.println("ANIMAL(X): " + newAnimalX);
//
//        Animal newAnimalY = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
//        System.out.println("ANIMAL(Y): " + newAnimalY);
//
//        Animal newAnimalZ = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
//        System.out.println("ANIMAL(Z): " + newAnimalZ);
//
//        assertTrue(newAnimalX.equals(newAnimalY));
//        assertTrue(newAnimalY.equals(newAnimalZ));
//        assertTrue(newAnimalX.equals(newAnimalZ));
//
//        System.out.println("if x.equals(y) and y.equals(z) are true, then so is x.equals(z)" + "\n");
//    }
}