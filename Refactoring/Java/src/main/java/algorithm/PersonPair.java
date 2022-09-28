package algorithm;

public class PersonPair {
  public Person one;
  public Person other;
  public long ageGapInMillis;

  public boolean isAgeGapCloserThan(PersonPair other) {
    return this.ageGapInMillis < other.ageGapInMillis;
  }
}
