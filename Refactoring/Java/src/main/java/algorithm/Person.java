package algorithm;

import java.util.Date;

public record Person(String name, Date birthdate) {

  public static Builder builder() {
    return new Builder();
  }

  public boolean isYoungerThan(Person other) {
    return this.birthdate.before(other.birthdate());
  }

  public long ageGapWith(Person other) {
    return this.birthdate.getTime() - other.birthdate().getTime();
  }

  public static final class Builder {

    private String name;
    private Date birthdate;

    private Builder() {
    }

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
