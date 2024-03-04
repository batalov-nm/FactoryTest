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
        System.out.println(
                newAnimal.getBreed()    + " / " +
                newAnimal.getName()     + " / " +
                newAnimal.getCost()     + " / " +
                newAnimal.getCharacter()+ " / " +
                newAnimal.getBirthDate()+ " / ");
        return newAnimal;
    }
}
