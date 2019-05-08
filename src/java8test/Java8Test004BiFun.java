package java8test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Java8Test004BiFun {
    public static void main(String[] args) {
        Person p1 = new Person("Zone",20);
        Person p2 = new Person("Apple",44);
        Person p3 = new Person("Wonderful",35);

        List<Person> ps = Arrays.asList(p1,p2,p3);
        Java8Test004BiFun test = new Java8Test004BiFun();
        List<Person> psResult = test.getPersonByName("Apple", ps);
        psResult.forEach(p->System.out.println(p.getName()+":"+p.getAge()));

        System.out.println("=========================================");

        List<Person> psResult2 = test.getPersonByAge(25, ps);
        psResult2.forEach(p->System.out.println(p.getName()+":"+p.getAge()));

        System.out.println("=========================================");

        List<Person> psResult3 = test.getPersonByAge2(19, ps,(biAge,biPs)->biPs.stream().filter(per ->per.getAge()>biAge).collect(Collectors.toList()));
        psResult3.forEach(p->System.out.println(p.getName()+":"+p.getAge()));

    }

    //find some conditions in List<Person>
    //use functional way....only one line?
    private List<Person> getPersonByName(String name,List<Person>ps){
        return ps.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
    }

    //search by age
    //Analysis: Two parameget and One Return... JUST like BiFunction
    private List<Person> getPersonByAge(int age,List<Person>ps){
        //return ps.stream().filter(person -> person.getAge() == (age)).collect(Collectors.toList());
        BiFunction<Integer,List<Person>,List<Person>> biFun = (biAge,biPs)->biPs.stream().filter(per ->per.getAge()>biAge).collect(Collectors.toList());
        return biFun.apply(age,ps);
    }

    //more advanced
    private List<Person> getPersonByAge2(int age,List<Person>ps,BiFunction<Integer,List<Person>,List<Person>> biFun){
        return biFun.apply(age,ps);
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