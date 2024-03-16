package org.example;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String breed, String name, Double cost, String character, LocalDate birthDate) {
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
        if (!(obj instanceof Cat)) return false;

        Cat newCat = (Cat) obj;

        if (!breed.equals(newCat.getBreed())) { return false; }
        if (!name.equals(newCat.getName())) { return false; }
        if (!cost.equals(newCat.getCost())) { return false; }
        if (!character.equals(newCat.getCharacter())) { return false; }
        if (!birthDate.equals(newCat.getBirthDate())) { return false; }
        return true;
    }

    @Override
    public String toString() {
        return "Cat {" + name + " / " + birthDate + "}";
    }
}
