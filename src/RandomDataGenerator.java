import java.time.LocalDate;
import java.util.Random;

public class RandomDataGenerator {
    public LocalDate createRandomDate(){
        Random random = new Random();

        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(LocalDate.now().getYear(), 1, 1).toEpochDay();

        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public LocalDate createRandomDate(int firstYear, int lastYear) {
        Random random = new Random();

        int minDay = (int) LocalDate.of(firstYear, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(lastYear, 1, 1).toEpochDay();

        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
