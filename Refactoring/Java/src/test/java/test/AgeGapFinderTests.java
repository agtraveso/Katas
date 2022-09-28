package test;

import static org.assertj.core.api.Assertions.assertThat;

import algorithm.AgeGap;
import algorithm.DefaultAgeGapCriteria;
import algorithm.AgeGapFinder;
import algorithm.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class AgeGapFinderTests {

  Person sue = Person.builder().name("Sue").birthdate(new Date(50, 0, 1)).build();
  Person greg = Person.builder().name("Greg").birthdate(new Date(52, 5, 1)).build();
  Person sarah = Person.builder().name("Sarah").birthdate(new Date(82, 0, 1)).build();
  Person mike = Person.builder().name("Mike").birthdate(new Date(79, 0, 1)).build();

  @Test
  public void Returns_Empty_Results_When_Given_Empty_List() {
    List<Person> list = new ArrayList<>();
    AgeGapFinder finder = new AgeGapFinder(list);

    Optional<AgeGap> result = finder.findOne(DefaultAgeGapCriteria.CLOSEST);

    assertThat(result).isEmpty();
  }

  @Test
  public void Returns_Empty_Results_When_Given_One_Person() {
    List<Person> list = new ArrayList<>();
    list.add(sue);

    AgeGapFinder finder = new AgeGapFinder(list);

    Optional<AgeGap> result = finder.findOne(DefaultAgeGapCriteria.CLOSEST);

    assertThat(result).isEmpty();
  }

  @Test
  public void Returns_Closest_Two_For_Two_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(greg);
    AgeGapFinder finder = new AgeGapFinder(list);

    Optional<AgeGap> result = finder.findOne(DefaultAgeGapCriteria.CLOSEST);

    assertThat(result).hasValueSatisfying(ageGap -> {
      assertThat(ageGap.getYoungest()).isEqualTo(sue);
      assertThat(ageGap.getOldest()).isEqualTo(greg);
    });
  }

  @Test
  public void Returns_Furthest_Two_For_Two_People() {
    List<Person> list = new ArrayList<>();
    list.add(mike);
    list.add(greg);

    AgeGapFinder finder = new AgeGapFinder(list);

    Optional<AgeGap> result = finder.findOne(DefaultAgeGapCriteria.FURTHEST);

    assertThat(result).hasValueSatisfying(ageGap -> {
      assertThat(ageGap.getYoungest()).isEqualTo(greg);
      assertThat(ageGap.getOldest()).isEqualTo(mike);
    });
  }

  @Test
  public void Returns_Furthest_Two_For_Four_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(sarah);
    list.add(mike);
    list.add(greg);
    AgeGapFinder finder = new AgeGapFinder(list);

    Optional<AgeGap> result = finder.findOne(DefaultAgeGapCriteria.FURTHEST);

    assertThat(result).hasValueSatisfying(ageGap -> {
      assertThat(ageGap.getYoungest()).isEqualTo(sue);
      assertThat(ageGap.getOldest()).isEqualTo(sarah);
    });
  }

  @Test
  public void Returns_Closest_Two_For_Four_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(sarah);
    list.add(mike);
    list.add(greg);

    AgeGapFinder finder = new AgeGapFinder(list);

    Optional<AgeGap> result = finder.findOne(DefaultAgeGapCriteria.CLOSEST);

    assertThat(result).hasValueSatisfying(ageGap -> {
      assertThat(ageGap.getYoungest()).isEqualTo(sue);
      assertThat(ageGap.getOldest()).isEqualTo(greg);
    });
  }
}
