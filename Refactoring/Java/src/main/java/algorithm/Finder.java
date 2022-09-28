package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
  private final List<Person> _p;

  public Finder(List<Person> p) {
    _p = p;
  }

  public Optional<AgeGap> findOne(DefaultAgeGapCriteria ageGapCriteria) {
    List<AgeGap> tr = new ArrayList<>();

    for (int i = 0; i < _p.size() - 1; i++) {
      for (int j = i + 1; j < _p.size(); j++) {
        tr.add(new AgeGap(_p.get(i), _p.get(j)));
      }
    }

    return tr.stream().reduce((ageGapCriteria::apply));
  }
}
