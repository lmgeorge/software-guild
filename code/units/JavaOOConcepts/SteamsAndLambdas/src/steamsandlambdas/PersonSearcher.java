/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamsandlambdas;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class PersonSearcher {

  //Approach 1
  public void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
      if (p.getAge() >= age) {
        p.printPerson();
      }
    }
  }
  
  public void printPersonsOlderThanStream(List<Person> roster, int age) {
    roster.stream()
      .filter((p) -> (p.getAge() >= age))
      .forEach((p) -> {
        p.printPerson();
      });
  }
  //Approach 2
  public void printPersonsWithinAgeRange(
    List<Person> roster, int low, int high) {
    roster.stream()
      .filter((p) -> (low <= p.getAge() && p.getAge() < high))
      .forEach((p) -> {
        p.printPerson();
      });
  }

  //Approach 3
  public  void printPersons(
    List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}

  //public void printPersonsPredicate()
  
  //Utility method to creat a list of person objects
  public List<Person> createRoster() {

    List<Person> roster = new ArrayList<>();
    roster.add(
      new Person(
        "Fred",
        IsoChronology.INSTANCE.date(1980, 6, 20),
        Person.Sex.MALE,
        "fred@example.com"));
    roster.add(
      new Person(
        "Jane",
        IsoChronology.INSTANCE.date(1990, 7, 15),
        Person.Sex.FEMALE, "jane@example.com"));
    roster.add(
      new Person(
        "George",
        IsoChronology.INSTANCE.date(1991, 8, 13),
        Person.Sex.MALE, "george@example.com"));
    roster.add(
      new Person(
        "Bob",
        IsoChronology.INSTANCE.date(2000, 9, 12),
        Person.Sex.MALE, "bob@example.com"));

    return roster;
  }
}
