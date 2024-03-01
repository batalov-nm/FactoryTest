import java.time.LocalDate;

public class Dog extends Pet implements Animal{
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;
    protected LocalDate birthDate;
    public Dog(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String getBreed() { return breed; }

    @Override
    public String getName() { return name; }

    @Override
    public Double getCost() { return cost; }

    @Override
    public String getCharacter() { return character; }

    @Override
    public LocalDate getBirthDate() { return birthDate; }

}
