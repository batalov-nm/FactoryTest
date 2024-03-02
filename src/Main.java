import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        CreateAnimalService af = new CreateAnimalServiceImpl();
        af.createSpecificAnimal("Cat", "lizzo", 12.2, "funny", LocalDate.now());
        af.createAnimalList(3, "Dog", "sas", 12.2, "funny", LocalDate.now());
        af.createAnimalListWithRandomDates(3, "Dog", "bob", 12.2, "funny");

//        SearchService ss = new SearchServiceImpl();
//        ss.filterOlderThanAnimals(animList, 10);
    }
}