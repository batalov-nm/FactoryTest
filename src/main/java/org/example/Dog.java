package org.example;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dog)) return false;

        Dog newDog = (Dog) obj;

        if (!breed.equals(newDog.getBreed())) { return false; }
        if (!name.equals(newDog.getName())) { return false; }
        if (!cost.equals(newDog.getCost())) { return false; }
        if (!character.equals(newDog.getCharacter())) { return false; }
        if (!birthDate.equals(newDog.getBirthDate())) { return false; }
        return true;
    }
    @Override
    public String toString() {
        return "Dog{" +
//                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
//                ", cost=" + cost +
//                ", character='" + character + '\'' +
//                ", birthDate=" + birthDate +
                '}';
    }
}
