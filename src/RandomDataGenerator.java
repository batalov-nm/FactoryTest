import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class RandomDataGenerator {
    public LocalDate createRandomBirthDate(){
        Random random = new Random();

        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(LocalDate.now().getYear(), 1, 1).toEpochDay();

        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public String createRandomBreed(){
        return null;
    }
    public String createRandomName(){
        return null;
    }
    public Double createRandomCost(){
        return new Random().nextDouble();
    }
    public String createRandomCharacter(){
        return null;
    }

    private enum availableBreeds {
        CAT, DOG, SHARK, WOLF
    }
    private enum availableNames {
        BIBA, BOBA, SAS, LIZZO
    }
    private enum availableCharacter {
        FUNNY, SUSSY, JUICY, MILKY
    }
}
