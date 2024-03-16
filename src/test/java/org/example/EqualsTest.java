package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EqualsTest {

    private final CreateAnimalService animalService = new CreateAnimalServiceImpl();

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
    void EqualsReflexiveTest(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
        Animal newAnimalX = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(X): " + newAnimalX);

        assertTrue(newAnimalX.equals(newAnimalX));
        System.out.println("x.equals(x) is true" + "\n");
    }

    @ParameterizedTest(name = "Test number: {0}")
    @MethodSource("getPetInfo")
    void EqualsSymmetricTest(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
        Animal newAnimalX = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(X): " + newAnimalX);
        Animal newAnimalY = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(Y): " + newAnimalY);
        //fixme Работает некорректно. Не знаю как исправить
        // Поступет стрим с полями класса и создаются два разных объекта с одинаковыми полями
        // Предполагаю, что нужно сделать сдвиг, чтобы в ANIMAL(X) поступали аргументы n, а в ANIMAL(Y) поступали аргументы n+1
       assertTrue(newAnimalX.equals(newAnimalY));
       System.out.println("x.equals(y) is true if and only if y.equals(x)" + "\n");
    }

    @ParameterizedTest(name = "Test number: {0}")
    @MethodSource("getPetInfo")
    public void EqualsTransitiveTest(int testNumber, String  breed, String name, String cost, String character, LocalDate date) {
        Animal newAnimalX = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(X): " + newAnimalX);

        Animal newAnimalY = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(Y): " + newAnimalY);

        Animal newAnimalZ = animalService.createSpecificAnimal(breed, name, Double.valueOf(cost), character, date);
        System.out.println("ANIMAL(Z): " + newAnimalZ);

        // fixme Точно такая же проблема, как и прошлом тесте
        assertTrue(newAnimalX.equals(newAnimalY));
        assertTrue(newAnimalY.equals(newAnimalZ));
        assertTrue(newAnimalX.equals(newAnimalZ));

        System.out.println("if x.equals(y) and y.equals(z) are true, then so is x.equals(z)" + "\n");
    }
}