/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamsandlambdas;

import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SteamsAndLambdas {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    PersonSearcher ps = new PersonSearcher();
    List<Person> list = ps.createRoster();
    //Approach 1
    System.out.println("\nApproach 1: ");
    ps.printPersonsOlderThan(list, 18);
    //System.out.println();
    //ps.printPersonsOlderThanStream(list, 18);
    System.out.println("\nApproach 2: ");
    //Aproach 2
    ps.printPersonsWithinAgeRange(list, 30, 40);

    //Approach 3 - local class
    class CheckPersonEligibleForSelectiveService implements CheckPerson {

      public boolean test(Person p) {
        return p.gender == Person.Sex.MALE
          && p.getAge() >= 18
          && p.getAge() <= 25;
      }

    }
    System.out.println("\nApproach 3: Local Class");
    ps.printPersons(list, new CheckPersonEligibleForSelectiveService());

    //Approach 4 - anonymous inner class
    System.out.println("\nApproach 4: Anonymous Inner Class");
    ps.printPersons(list,
      new CheckPerson() {
        public boolean test(Person p) {
          return p.gender == Person.Sex.FEMALE
          && p.getAge() >= 18
          && p.getAge() <= 25;
        }
      }
    );
    //Approach 5 - lambdas w/ interface
    System.out.println("\nApproach 5: Lambda w/interface");
    ps.printPersons(list,
      (Person p) -> p.gender == Person.Sex.FEMALE
      && p.getAge() >= 18
      && p.getAge() <= 25);

    //Approach 6: Lambda expression w/type inference
    System.out.println("\nApproach 5: Lambda expression w/type inference");
    ps.printPersons(list,
      person -> person.gender == Person.Sex.FEMALE
      && person.getAge() >= 18
      && person.getAge() <= 25);
    //Aggregates

    list.stream()
      .filter(p -> p.getGender() == Person.Sex.FEMALE)
      .forEach(p -> System.out.println(p.getName()));
  }

}
