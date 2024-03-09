package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EqualsTest {

    @Test
    void EqualsReflexiveTest() {
        CreateAnimalService as = new CreateAnimalServiceImpl();
        Animal newAnimalX = as.createSpecificAnimal("Cat", "SAS", 12.2, "SAS", LocalDate.now());

        assertTrue(newAnimalX.equals(newAnimalX));
        System.out.println("x.equals(x) is true");
    }
    @Test
    void EqualsSymmetricTest() { //
        CreateAnimalService as = new CreateAnimalServiceImpl();
        Animal newAnimalX = as.createSpecificAnimal("Wolf", "SAS", 12.2, "SAS", LocalDate.now());
        Animal newAnimalY = as.createSpecificAnimal("Wolf", "SAS", 12.2, "SAS", LocalDate.now());

       assertTrue(newAnimalX.equals(newAnimalY));
        System.out.println("x.equals(y) is true if and only if y.equals(x)");
    }
    @Test
    void EqualsTransitiveTest() { // Как ПО УМУ добавить больше тестовых сценариев, потому что просто копировать код выглядит как плохая идея
        CreateAnimalService as = new CreateAnimalServiceImpl();
        Animal newAnimalX = as.createSpecificAnimal("Cat", "SAS", 12.2, "SAS", LocalDate.now());
        Animal newAnimalY = as.createSpecificAnimal("Cat", "SAS", 12.2, "SAS", LocalDate.now());
        Animal newAnimalZ = as.createSpecificAnimal("Cat", "SAS", 12.2, "SAS", LocalDate.now());

        assertTrue((newAnimalX.equals(newAnimalY)));
        assertTrue(newAnimalY.equals(newAnimalZ));
        assertTrue(newAnimalX.equals(newAnimalZ));

        System.out.println("if x.equals(y) and y.equals(z) are true , then so is x.equals(z)");
    }
}