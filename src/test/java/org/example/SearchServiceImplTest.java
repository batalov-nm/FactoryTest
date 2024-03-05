package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {

    @Test
    void findLeapYearNames() {
        CreateAnimalService af = new CreateAnimalServiceImpl();
        List<Animal> sussyAnimals = af.generateAnimals();
        Animal newLeapAnimal1 = af.createSpecificAnimal("cat", "DODIK", 1.1, "1", LocalDate.of(2024, 1, 12));
        sussyAnimals.set(0, newLeapAnimal1);

        SearchService ss = new SearchServiceImpl();
        System.out.println(ss.findLeapYearNames(sussyAnimals));
        assertTrue(ss.findLeapYearNames(sussyAnimals).contains(newLeapAnimal1.getName()));
    }

    @Test
    void findOlderAnimals() {
    }

    @Test
    void findDuplicate() {
        CreateAnimalService af = new CreateAnimalServiceImpl();
        List<Animal> sussyAnimals = af.generateAnimals();

        sussyAnimals.remove(1);
        sussyAnimals.set(1, sussyAnimals.get(0));

        SearchService ss = new SearchServiceImpl();

        ss.findDuplicate(sussyAnimals);
    }
}