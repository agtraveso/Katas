package algorithm;

import java.util.Date;

public class Person {
  private final String name;
  private final Date birthdate;


  private Person(String name, Date birthdate) {
    this.name = name;
    this.birthdate = birthdate;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getName() {
    return name;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public boolean isYoungerThan(Person other) {
    return this.birthdate.before(other.getBirthdate());
  }

  public long ageGapWith(Person other) {
    return this.birthdate.getTime() - other.getBirthdate().getTime();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Person person)) {
      return false;
    }

    return new org.apache.commons.lang3.builder.EqualsBuilder()
        .append(name, person.name)
        .append(birthdate, person.birthdate)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
        .append(name)
        .append(birthdate)
        .toHashCode();
  }

  public static final class Builder {

    private String name;
    private Date birthdate;

    private Builder() {}

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder birthdate(Date birthdate) {
      this.birthdate = birthdate;
      return this;
    }

    public Person build() {
      return new Person(name, birthdate);
    }
  }
}
