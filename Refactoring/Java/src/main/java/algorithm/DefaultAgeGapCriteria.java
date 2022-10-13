package algorithm;

public enum DefaultAgeGapCriteria implements AgeGapCriteria {
  CLOSEST {
    @Override
    public AgeGap apply(AgeGap one, AgeGap other) {
      if (one.isAgeGapCloserThan(other)) {
        return one;
      }
      return other;
    }
  },
  FURTHEST {
    @Override
    public AgeGap apply(AgeGap one, AgeGap other) {
      if (!one.isAgeGapCloserThan(other)) {
        return one;
      }
      return other;
    }
  }
}
