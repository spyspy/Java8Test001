package java8test.stream;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Java8TestStream007 {
    public static void main(String[] args) {
        //Video NO22
        Student7 s1 = new Student7("Test01",100);
        Student7 s2 = new Student7("Test02",95);
        Student7 s3 = new Student7("Test03",60);
        Student7 s4 = new Student7("Test04",66);
        Student7 s5 = new Student7("Test04",95);

        List<Student7>  studentList = Arrays.asList(s1,s2,s3,s4,s5);
        System.out.println("steam().cont():"+studentList.stream().count());

        List<Student7> list2 = studentList.stream().collect(toList());
        list2.stream().forEach(System.out::println);

        //Collector.java
        //parallel (併行) and sequentially (串型)

        //Video 25
        //Find collections whose score is lowest 找出分數最低的
        //comparingInt :: jdk 1.8　
        System.out.println("--------------- minBy");

        studentList.stream().collect(minBy(Comparator.comparingInt(Student7::getScore))).ifPresent(System.out::println);
        studentList.stream().collect(maxBy(Comparator.comparingInt(Student7::getScore))).ifPresent(System.out::println);
        System.out.println("Average: " +studentList.stream().collect(averagingInt(Student7::getScore)));
        //Sum
        System.out.println("Sum : "+studentList.stream().collect(summingInt(Student7::getScore))
        );
        System.out.println("--------------- intSummaryStatistics");

        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(summarizingInt(Student7::getScore));
        System.out.println("statistics:"+intSummaryStatistics);

        System.out.println("--------------- how to use: joining ");
        System.out.println(studentList.stream().map(Student7::getName).collect(joining()));
        System.out.println(studentList.stream().map(Student7::getName).collect(joining(", ")));
        System.out.println(studentList.stream().map(Student7::getName).collect(joining(", ","<begin>","<end>")));
        System.out.println("--------------- grouppingby");
        Map<Integer, List<Student7>> myMap = studentList.stream().collect(groupingBy(Student7::getScore));
        System.out.println(myMap);
        System.out.println("--------------- grouppingby TWO conditions");
        Map<Integer, Map<String, List<Student7>>> myMap2 = studentList.stream().collect(groupingBy(Student7::getScore,groupingBy(Student7::getName)));
        System.out.println(myMap2);
        System.out.println("--------------- partitionBy  >95 ");
        Map<Boolean,List<Student7>> map3 = studentList.stream().collect(partitioningBy(stu -> stu.getScore() >95));
        System.out.println(map3);
        System.out.println("--------------- partitionBy  >95   and  <65 ");
        Map<Boolean, Map<Boolean, List<Student7>>> map4 = studentList.stream().collect(partitioningBy(stu -> stu.getScore() >95,partitioningBy(stu->stu.getScore()<65)));
        System.out.println(map4);
        System.out.println("--------------- partitionBy + groupingBy");





    }
}

class Student7{
    private String name;
    private Integer score;

    public Student7(String name,Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student7{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
