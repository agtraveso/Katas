package algorithm;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AgeGap {
  private final Person youngest;
  private final Person oldest;
  private final long ageGapInMillis;

  public AgeGap(Person one, Person other) {
    if (one.isYoungerThan(other)) {
      this.youngest = one;
      this.oldest = other;
    } else {
      this.youngest = other;
      this.oldest = one;
    }

    this.ageGapInMillis = this.oldest.ageGapWith(this.youngest);
  }

  public Person getYoungest() {
    return youngest;
  }

  public Person getOldest() {
    return oldest;
  }

  public long getAgeGapInMillis() {
    return ageGapInMillis;
  }

  public boolean isAgeGapCloserThan(AgeGap other) {
    return this.ageGapInMillis < other.ageGapInMillis;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof AgeGap ageGap)) {
      return false;
    }

    return new EqualsBuilder()
        .append(ageGapInMillis, ageGap.ageGapInMillis)
        .append(youngest, ageGap.youngest)
        .append(oldest, ageGap.oldest)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(youngest)
        .append(oldest)
        .append(ageGapInMillis)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
        .append("one", youngest)
        .append("other", oldest)
        .append("ageGapInMillis", ageGapInMillis)
        .toString();
  }
}
