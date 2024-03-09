package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchServiceImpl implements SearchService {
    @Override
    public List<String> findLeapYearNames(List<Animal> animalList) {
        List<String> leapYearNamesList = new ArrayList<>();
        for (Animal i : animalList) {
            if (i.getBirthDate().getYear() % 4 == 0) {
                leapYearNamesList.add(i.getName());
            }
        }
        return leapYearNamesList;
    }

    @Override
    public List<Animal> findOlderAnimals(List<Animal> animalList, int animalAge) {
        List<Animal> findOlderAnimalsList = new ArrayList<>();
        for (Animal i : animalList) {
            int animalNumericalAge = LocalDate.now().getYear() - i.getBirthDate().getYear();
            if (animalNumericalAge >= animalAge) {
                findOlderAnimalsList.add(i);
            }
        }
        return findOlderAnimalsList;
    }

    @Override
    public List<Animal> findDuplicate(List<Animal> animalList) {
        List<Animal> findDuplicateList = new ArrayList<>();
        Set<Animal> findDuplicatesSet = new HashSet<>();
        for (Animal i : animalList)
            if (findDuplicatesSet.contains(i)) {
                findDuplicateList.add(i);
            } else {
                findDuplicatesSet.add(i);
            }
        System.out.println(findDuplicateList);
        return findDuplicateList;
    }
}
