import java.time.LocalDate;
import java.util.List;

public interface CreateAnimalService {
    Animal createSpecificAnimal(String breed, String name, Double cost, String character, LocalDate birthDate);
    List<Animal> createAnimalList(int N, String breed, String name, Double cost, String character, LocalDate birthDate);
    public List<Animal> createAnimalListWithRandomDates(int N, String breed, String name, Double cost, String character);

    default List<AbstractAnimal> generateAnimals(){
        return null;
    }
}
