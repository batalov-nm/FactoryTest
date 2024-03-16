package org.example;

import java.time.LocalDate;

public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character, LocalDate birthDate) {
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
        if (!(obj instanceof Shark)) return false;

        Shark newShark = (Shark) obj;

        if (!breed.equals(newShark.getBreed())) { return false; }
        if (!name.equals(newShark.getName())) { return false; }
        if (!cost.equals(newShark.getCost())) { return false; }
        if (!character.equals(newShark.getCharacter())) { return false; }
        if (!birthDate.equals(newShark.getBirthDate())) { return false; }
        return true;
    }
    @Override
    public String toString() {
        return "Shark {" + name + " / " + birthDate + "}";
    }
}
