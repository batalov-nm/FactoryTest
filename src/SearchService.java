import java.util.List;

public interface SearchService {
    List<String> findLeapYearNames(List<Animal> animalList);
    List<Animal> findOlderAnimals(List<Animal> animalList, int animalAge);
    Animal findDuplicate(List<Animal> animalList);

}
