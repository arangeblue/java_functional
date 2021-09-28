package imperative;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *@title : Main
 *@author : wikyubok 
 *@date : "2021-09-28 00:47:01"
*/

public class Main {
    
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE));
        
        

        // Imperative approach 명령적 접근법
        System.out.println("// Imperative Approach //\n\n");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        
        for (Person female : females) {
            System.out.println(female);
        }


        // Declarative Approach 선언적 접근법
        System.out.println("\n\n// Declarative Approach //\n\n");
        System.out.println("--------- females1 ---------\n");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Predicate<? super Person> predicate = person -> FEMALE.equals(person.gender);
        List<Person> females2 = people.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println("\n--------- females2 ---------\n");
        females2.forEach(System.out::println);
                


    
    }




    static class Person {
        private final String name;
        private final Gender gender;

    

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person {gender=" + gender + ", name=" + name + "}";
        }
        
        
    }

    enum Gender {
        MALE, FEMALE
    }
}
