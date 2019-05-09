package java8test;

import java.util.Arrays;
import java.util.List;

public class Java8Test007MethodRef {
    public static void main(String[] args) {
        //方法引用  Method Reference
        List<String> listString = Arrays.asList("Test1","Test2","Test3");

        //forEach
        listString.forEach((str)-> System.out.println(str));
        System.out.println("***********************************");
        //method reference
        listString.forEach(System.out::println);
        System.out.println("***********************************");

        //There are 4 types of Method References
        //Type 1.  class name :: static method name


        //Type 1 Example:
        MyStudent stu1 = new MyStudent("S1",15);
        MyStudent stu2 = new MyStudent("S2",95);
        MyStudent stu3 = new MyStudent("S3",55);
        MyStudent stu4 = new MyStudent("S4",45);
        List<MyStudent> students = Arrays.asList(stu1,stu2,stu3,stu4);

        //Sort method will change Object itself
        //Lambda way
        students.sort((ss1,ss2)->MyStudent.compareStudentByScore(ss1,ss2));
        students.forEach(ss1-> System.out.println(ss1.getScore()));
        System.out.println("**************************");

        MyStudent stua1 = new MyStudent("S1",85);
        MyStudent stua2 = new MyStudent("S2",77);
        MyStudent stua3 = new MyStudent("S3",99);
        MyStudent stua4 = new MyStudent("S4",10);
        List<MyStudent> students2 = Arrays.asList(stua1,stua2,stua3,stua4);
        //Method Reference way
        //Type 1.  class name :: static method name
        students2.sort(MyStudent::compareStudentByScore);
        students2.forEach(ss1-> System.out.println(ss1.getScore()));



    }
}

class MyStudent{
    private String name;

    private int score;

    //static method: order by name and score;
    public static int compareStudentByScore(MyStudent s1,MyStudent s2){
        return s1.getScore()-s2.getScore();
    }

    public static int compareStudentByName(MyStudent s1,MyStudent s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

    public MyStudent(String name, int score) {
        this.name = name;
        this.score = score;
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
}
