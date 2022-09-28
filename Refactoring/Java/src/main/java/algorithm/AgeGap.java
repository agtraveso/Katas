package algorithm;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AgeGap {
  private final Person one;
  private final Person other;
  private final long ageGapInMillis;

  public AgeGap(Person one, Person other) {
    if(one!= null && other != null) {
      if(one.getBirthdate().getTime() <  other.getBirthdate().getTime()) {
        this.one = one;
        this.other = other;
      } else {
        this.one = other;
        this.other = one;
      }

      this.ageGapInMillis = this.other.getBirthdate().getTime() - this.one.getBirthdate().getTime();
    } else {
      this.one = null;
      this.other = null;
      this.ageGapInMillis = 0;
    }
  }

  public Person getOne() {
    return one;
  }

  public Person getOther() {
    return other;
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
        .append(one, ageGap.one)
        .append(other, ageGap.other)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(one)
        .append(other)
        .append(ageGapInMillis)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
        .append("one", one)
        .append("other", other)
        .append("ageGapInMillis", ageGapInMillis)
        .toString();
  }
}
