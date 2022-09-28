package algorithm;

public enum DefaultAgeGapCriteria implements AgeGapCriteria {
  CLOSEST {
    @Override
    public PersonPair apply(PersonPair one, PersonPair other) {
      if (one.isAgeGapCloserThan(other)) {
        return one;
      }
      return other;
    }
  },
  FURTHEST {
    @Override
    public PersonPair apply(PersonPair one, PersonPair other) {
      if (!one.isAgeGapCloserThan(other)) {
        return one;
      }
      return other;
    }
  }
}
