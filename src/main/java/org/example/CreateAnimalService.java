package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {
    Animal createSpecificAnimal(String breed, String name, Double cost, String character, LocalDate birthDate);

    default List<Animal> generateAnimals() {
        List<Animal> newAnimalList = new ArrayList<>(10);
        RandomDataGenerator rnd = new RandomDataGenerator();

        for (int i = 0; i < 10; i++) {
            Animal newAnimal = createSpecificAnimal(
                    rnd.createRandomBreed(),
                    rnd.createRandomName(),
                    rnd.createRandomCost(),
                    rnd.createRandomCharacter(),
                    rnd.createRandomBirthDate());

            newAnimalList.add(newAnimal);
        }
        System.out.println(newAnimalList);
        return newAnimalList;
    }
}
