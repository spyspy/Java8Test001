package java8test.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8TestStream006 {
    public static void main(String[] args) {
        //Video 22 Stream, group by...etc...

        List<String> list1 = Arrays.asList("Hello","Wow","Oheiyo");
        List<String> list2 = Arrays.asList("New York","Taipei","Tokyo");

        System.out.println("------------------- flatMap() Practice 1 combine two list");

        List<String> result = list1.stream().flatMap(x1String->list2.stream().map(x2String->x1String+","+x2String)).collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("------------------- flatMap() Practice 2 see its nature");

        //
        list1.stream().flatMap(list1String->list1.stream().map(list2String->list2String+":hoho")).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("------------------- groupingBy() by name (like SQL group by)");

        Student stu1 = new Student("Tom",100,25);
        Student stu2 = new Student("Mary",90,17);
        Student stu3 = new Student("Tom",95,20);
        Student stu4 = new Student("Apple",90,18);

        //Group by Name
        List<Student> studentList = Arrays.asList(stu1,stu2,stu3,stu4);

        //Like SQL?
        //select * from student group by name;
        // Tom.....2
        // Marry...1
        // Apple...1

        Map<String,List<Student>> map1= studentList.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map1);

        System.out.println("------------------- groupingBy() by score");
        Map<Integer,List<Student>> map2= studentList.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(map2);

        System.out.println("------------------- groupingBy() by age");
        Map<Integer,List<Student>> map3= studentList.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println(map3);

        System.out.println("------------------- groupingBy() counting");
        //select name,count(*) from student group by name
        Map<String,Long> map4= studentList.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        System.out.println(map4);

        System.out.println("------------------- groupingBy() average");
        Map<String,Double> map5= studentList.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getScore)));
        System.out.println(map5);

        System.out.println("------------------- partitionBy() true or false  ");
        Map<Boolean,List<Student>> map6= studentList.stream().collect(Collectors.partitioningBy(stud -> stud.getScore()>95));
        System.out.println(map6);


    }
}

class Student{
    private String name;
    private int score;
    private int age;

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
