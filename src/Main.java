import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CreateAnimalService af = new CreateAnimalServiceImpl();
        List<Animal> sussyAnimals = af.generateAnimals(10);

        SearchService ss = new SearchServiceImpl();

        System.out.println(ss.findLeapYearNames(sussyAnimals));
    }
}