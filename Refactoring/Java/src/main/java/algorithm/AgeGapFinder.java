package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgeGapFinder {
  private final List<AgeGap> ageGaps = new ArrayList<>();

  public AgeGapFinder(List<Person> people) {
    people.forEach(
        currentPerson ->
            people.stream()
                .filter(candidate -> !currentPerson.equals(candidate))
                .forEach(nextPerson -> ageGaps.add(new AgeGap(currentPerson, nextPerson))));
  }

  public Optional<AgeGap> findOne(DefaultAgeGapCriteria ageGapCriteria) {
    return this.ageGaps.stream().reduce((ageGapCriteria::apply));
  }
}
