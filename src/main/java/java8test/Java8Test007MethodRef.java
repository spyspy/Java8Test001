package java8test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

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
        //Type 1. Class name :: Static method name
        //Type 2. Reference Name(Object Name) ::  Instance Method
        //Type 3. Class name :: Instance method name
        //Type 4. Constructor method reference =>  class name::new


        //Type 1 Example:
        MyStudent stu1 = new MyStudent("S2",15);
        MyStudent stu2 = new MyStudent("S1",95);
        MyStudent stu3 = new MyStudent("S4",55);
        MyStudent stu4 = new MyStudent("S3",45);
        List<MyStudent> students = Arrays.asList(stu1,stu2,stu3,stu4);

        //Sort method will change Object itself
        //Lambda way
        students.sort((ss1,ss2)->MyStudent.compareStudentByScore(ss1,ss2));
        students.forEach(ss1-> System.out.println(ss1.getName()+":"+ss1.getScore()));
        System.out.println("**************************");

        MyStudent stua1 = new MyStudent("T3",85);
        MyStudent stua2 = new MyStudent("T2",77);
        MyStudent stua3 = new MyStudent("T1",99);
        MyStudent stua4 = new MyStudent("T4",10);
        List<MyStudent> students2 = Arrays.asList(stua1,stua2,stua3,stua4);
        //Method Reference way
        //Type 1.  class name :: static method name
        students2.sort(MyStudent::compareStudentByScore);
        students2.forEach(ss1-> System.out.println(ss1.getName()+":"+ss1.getScore()));
        System.out.println("************************** Type 2 ");

        //Type 2. Reference Name(Object Name) ::  Instance Method
        students2.sort((s1,s2)->MyStudent.compareStudentByName(s1,s2));
        students2.forEach(ss1-> System.out.println(ss1.getName()+":"+ss1.getScore()));
        System.out.println("************************** Type 2 ");

        StudentComparator studentComparator = new StudentComparator();
        students2.sort((s1,s2)->studentComparator.compareStudentByScore2(s1,s2));
        students2.forEach(ss1-> System.out.println(ss1.getName()+":"+ss1.getScore()));
        System.out.println("************************** Type 2 ");
        //Type 2
        students2.sort(studentComparator::compareStudentByName2);
        students2.forEach(ss1-> System.out.println(ss1.getName()+":"+ss1.getScore()));

        System.out.println("************************** Type 3 ");

        //Type 3. Class name :: Instance method name
        students2.sort(MyStudent::compareByScore3);
        students2.forEach(ss1-> System.out.println(ss1.getName()+":"+ss1.getScore()));

        System.out.println("************************** Type 3 ");

        //Type 3. Class name :: Instance method name
        students2.sort(MyStudent::compareByName3);
        students2.forEach(ss1-> System.out.println(ss1.getName()+":"+ss1.getScore()));

        System.out.println("************************** Type 3 v2");

        //Another Example
        List<String> citeis = Arrays.asList("Taipei","New York","Amo");
        //The way compare string
        Collections.sort(citeis,(s1,s2) -> s1.compareToIgnoreCase(s2));
        citeis.forEach(ss1-> System.out.println(ss1));
        System.out.println("************************** Type 3 v2");

        //Method Reference
        List<String> citeis2 = Arrays.asList("Taipei2","New York2","Amo2");
        Collections.sort(citeis2,String::compareToIgnoreCase);
        citeis2.forEach(System.out::println);
        System.out.println("************************** Type 3 v2 change to Descending order");
        //Descending order
        Collections.sort(citeis2,Collections.reverseOrder());
        citeis2.forEach(System.out::println);

        System.out.println("************************** Type 4");
        //Type 4. Constructor method:  class name::new
        Java8Test007MethodRef myObject = new Java8Test007MethodRef();
        //new String() ==> String::new
        System.out.println(myObject.getString(String::new));
        System.out.println(myObject.getString2("Wow",String::new));


    }

    //for type4
    public String getString(Supplier<String>supplier){
        return supplier.get()+":MyTestGo..";
    }

    //for type4
    public String getString2(String str, Function<String,String> fun){
        return fun.apply(str);
    }
}

class MyStudent{
    private String name;
    private int score;

    //Constructor
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

    //For Type 1 Test
    //static method: order by name and score;
    public static int compareStudentByScore(MyStudent s1,MyStudent s2){
        return s1.getScore()-s2.getScore();
    }

    //For Type 1 Test
    public static int compareStudentByName(MyStudent s1,MyStudent s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

    //Note: previous two method design wrongly?

    //For Type 3
    //Correct way to design
    public int compareByScore3(MyStudent s1){
        return this.getScore() - s1.getScore();
    }
    //For Type 3
    public int compareByName3(MyStudent s1){
        return this.getName().compareToIgnoreCase(s1.getName());
    }


}

//Type 2 use
class StudentComparator{
    public int compareStudentByScore2(MyStudent s1,MyStudent s2){
        return s1.getScore()-s2.getScore();
    }

    public int compareStudentByName2(MyStudent s1,MyStudent s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}
