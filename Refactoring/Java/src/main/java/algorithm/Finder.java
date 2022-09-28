package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
  private final List<Person> _p;

  public Finder(List<Person> p) {
    _p = p;
  }

  public PersonPair Find(DefaultAgeGapCriteria ft) {
    List<PersonPair> tr = new ArrayList<>();

    for (int i = 0; i < _p.size() - 1; i++) {
      for (int j = i + 1; j < _p.size(); j++) {
        PersonPair r = new PersonPair();
        if (_p.get(i).getBirthdate().getTime() < _p.get(j).getBirthdate().getTime()) {
          r.one = _p.get(i);
          r.other = _p.get(j);
        } else {
          r.one = _p.get(j);
          r.other = _p.get(i);
        }
        r.ageGapInMillis = r.other.getBirthdate().getTime() - r.one.getBirthdate().getTime();
        tr.add(r);
      }
    }

    if (tr.size() < 1) {
      return new PersonPair();
    }

    return tr.stream().reduce((ft::apply)).orElseThrow();
  }
}
