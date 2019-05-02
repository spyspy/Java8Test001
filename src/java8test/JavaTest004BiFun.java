package java8test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaTest004BiFun {
    public static void main(String[] args) {
        Person p1 = new Person("Zone",20);
        Person p2 = new Person("Apple",44);
        Person p3 = new Person("Wonderful",35);

        List<Person> ps = Arrays.asList(p1,p2,p3);
        JavaTest004BiFun test = new JavaTest004BiFun();
        List<Person> psResult = test.getPersonByName("Apple", ps);
        psResult.forEach(p->System.out.println(p.getName()+":"+p.getAge()));

    }

    //find some conditions in List<Person>
    //use functional way....only one line?
    public List<Person> getPersonByName(String name,List<Person>ps){
        return ps.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }

    //search by age
    //Analysis:
    public List<Person> getPersonByAge(int age,List<Person>ps){
        return ps.stream().filter(person -> person.getAge() == (age)).collect(Collectors.toList());
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}