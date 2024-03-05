package org.example;

import java.time.LocalDate;

public class Wolf extends Predator {
    public Wolf(String breed, String name, Double cost, String character, LocalDate birthDate) {
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
        if (!(obj instanceof Wolf)) return false;

        Wolf newWolf = (Wolf) obj;

        if (!breed.equals(newWolf.getBreed())) { return false; }
        if (!name.equals(newWolf.getName())) { return false; }
        if (!cost.equals(newWolf.getCost())) { return false; }
        if (!character.equals(newWolf.getCharacter())) { return false; }
        if (!birthDate.equals(newWolf.getBirthDate())) { return false; }
        return true;
    }

    @Override
    public String toString() {
        return "Wolf{" +
//                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
//                ", cost=" + cost +
//                ", character='" + character + '\'' +
//                ", birthDate=" + birthDate +
                '}';
    }
}
