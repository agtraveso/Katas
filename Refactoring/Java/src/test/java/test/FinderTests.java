package test;

import static org.junit.Assert.assertEquals;

import algorithm.AgeGap;
import algorithm.DefaultAgeGapCriteria;
import algorithm.Finder;
import algorithm.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class FinderTests {

  Person sue = Person.builder().name("Sue").birthdate(new Date(50, 0, 1)).build();
  Person greg = Person.builder().name("Greg").birthdate(new Date(52, 5, 1)).build();
  Person sarah = Person.builder().name("Sarah").birthdate(new Date(82, 0, 1)).build();
  Person mike = Person.builder().name("Mike").birthdate(new Date(79, 0, 1)).build();

  @Test
  public void Returns_Empty_Results_When_Given_Empty_List() {
    List<Person> list = new ArrayList<>();
    Finder finder = new Finder(list);

    AgeGap result = finder.Find(DefaultAgeGapCriteria.CLOSEST);
    assertEquals(null, result.getOne());
    assertEquals(null, result.getOther());
  }

  @Test
  public void Returns_Empty_Results_When_Given_One_Person() {
    List<Person> list = new ArrayList<>();
    list.add(sue);

    Finder finder = new Finder(list);

    AgeGap result = finder.Find(DefaultAgeGapCriteria.CLOSEST);

    assertEquals(null, result.getOne());
    assertEquals(null, result.getOther());
  }

  @Test
  public void Returns_Closest_Two_For_Two_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(greg);
    Finder finder = new Finder(list);

    AgeGap result = finder.Find(DefaultAgeGapCriteria.CLOSEST);

    assertEquals(sue, result.getOne());
    assertEquals(greg, result.getOther());
  }

  @Test
  public void Returns_Furthest_Two_For_Two_People() {
    List<Person> list = new ArrayList<>();
    list.add(mike);
    list.add(greg);

    Finder finder = new Finder(list);

    AgeGap result = finder.Find(DefaultAgeGapCriteria.FURTHEST);

    assertEquals(greg, result.getOne());
    assertEquals(mike, result.getOther());
  }

  @Test
  public void Returns_Furthest_Two_For_Four_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(sarah);
    list.add(mike);
    list.add(greg);
    Finder finder = new Finder(list);

    AgeGap result = finder.Find(DefaultAgeGapCriteria.FURTHEST);

    assertEquals(sue, result.getOne());
    assertEquals(sarah, result.getOther());
  }

  @Test
  public void Returns_Closest_Two_For_Four_People() {
    List<Person> list = new ArrayList<>();
    list.add(sue);
    list.add(sarah);
    list.add(mike);
    list.add(greg);

    Finder finder = new Finder(list);

    AgeGap result = finder.Find(DefaultAgeGapCriteria.CLOSEST);

    assertEquals(sue, result.getOne());
    assertEquals(greg, result.getOther());
  }
}
