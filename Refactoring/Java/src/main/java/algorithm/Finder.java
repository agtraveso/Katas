package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
  private final List<Person> _p;

  public Finder(List<Person> p) {
    _p = p;
  }

  public AgeGap Find(DefaultAgeGapCriteria ft) {
    List<AgeGap> tr = new ArrayList<>();

    for (int i = 0; i < _p.size() - 1; i++) {
      for (int j = i + 1; j < _p.size(); j++) {
        tr.add(new AgeGap(_p.get(i), _p.get(j)));
      }
    }

    if (tr.size() < 1) {
      return new AgeGap(null, null);
    }

    return tr.stream().reduce((ft::apply)).orElseThrow();
  }
}
