import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public Animal createSpecificAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
        Animal newAnimal = switch (breed.toLowerCase()) {
            case "cat" -> new Cat(breed, name, cost, character, birthDate);
            case "dog" -> new Dog(breed, name, cost, character, birthDate);
            case "shark" -> new Shark(breed, name, cost, character, birthDate);
            case "wolf" -> new Wolf(breed, name, cost, character, birthDate);
            default -> throw new IllegalStateException("Unexpected value: " + breed.toLowerCase());
        };
        System.out.println(newAnimal.getBreed() + " <" + newAnimal.getName() + "> have been created!");
        return newAnimal;
    }

    @Override
    public List<Animal> createAnimalList(int N, String breed, String name, Double cost, String character, LocalDate birthDate) {
        List<Animal> newAnimalList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            newAnimalList.add(createSpecificAnimal(breed, name, cost, character, birthDate));
        }
        System.out.println(newAnimalList);
        return newAnimalList;
    }

    @Override
    public List<Animal> createAnimalListWithRandomDates(int N, String breed, String name, Double cost, String character) {
        List<Animal> newAnimalList = new ArrayList<>(N);
        RandomDataGenerator rnd = new RandomDataGenerator();

        for (int i = 0; i < N; i++) {
            newAnimalList.add(createSpecificAnimal(breed, name, cost, character, rnd.createRandomBirthDate()));
        }
        System.out.println(newAnimalList.getFirst().getBirthDate());
        return newAnimalList;
    }
}
