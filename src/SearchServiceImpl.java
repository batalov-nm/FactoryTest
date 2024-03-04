import java.time.LocalDate;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchServiceImpl implements SearchService{
    @Override
    public List<String> findLeapYearNames(List<Animal> animalList) {
        List<String> leapYearNamesList = new ArrayList<>();
        for (Animal i: animalList){
            if(i.getBirthDate().getYear() % 4 == 0) {
                leapYearNamesList.add(i.getName());
            }
        }
        return leapYearNamesList;
    }

    @Override
    public List<Animal> findOlderAnimals(List<Animal> animalList, int animalAge) {
//        SortedSet<Animal> animalTreeSet = new TreeSet<>();
//        int yearFloor = LocalDate.now().getYear() - animalAge;
//        animalTreeSet.addAll(animalList);
////        animalTreeSet.headSet();
        return null;
    }

    @Override
    public Animal findDuplicate(List<Animal> animalList) {
        return null;
    }
}
