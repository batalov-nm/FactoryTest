package org.example;

import java.time.LocalDate;
import java.util.Random;

public class RandomDataGenerator {
    public LocalDate createRandomBirthDate() {
        Random random = new Random();

        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(LocalDate.now().getYear(), 1, 1).toEpochDay();

        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);

//        LocalDate newRandomDate = LocalDate.of(
//                getRandomNumber(1900, LocalDate.now().getYear()),
//                getRandomNumber(1,12),
//                getRandomNumber(1,31));
//        return newRandomDate;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String createRandomBreed() {
        return availableBreeds.getAvailableBreed(getRandomNumber(0, availableBreeds.getAvailableBreedLength()));
    }

    public String createRandomName() {
        return availableNames.getAvailableName(getRandomNumber(0, availableNames.getAvailableNameLength()));
    }

    public Double createRandomCost() {
        return new Random().nextDouble();
    }

    public String createRandomCharacter() {
        return availableCharacters.getAvailableCharacter(getRandomNumber(0, availableCharacters.getAvailableCharactersLength()));
    }

    private enum availableBreeds {
        CAT, DOG, SHARK, WOLF;
        private static final availableBreeds[] list = availableBreeds.values();

        public static String getAvailableBreed(int i) {
            return list[i].toString();
        }

        public static int getAvailableBreedLength() {
            return list.length;
        }
    }

    private enum availableNames {
        Ozon, Tolyan, OXOTA, Lizzo;
        private static final availableNames[] list = availableNames.values();

        public static String getAvailableName(int i) {
            return list[i].toString();
        }

        public static int getAvailableNameLength() {
            return list.length;
        }
    }

    private enum availableCharacters {
        FUNNY, SUSSY, JUICY, MILKY;
        private static final availableCharacters[] list = availableCharacters.values();

        public static String getAvailableCharacter(int i) {
            return list[i].toString();
        }

        public static int getAvailableCharactersLength() {
            return list.length;
        }
    }
}
