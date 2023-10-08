package javaAdvanced;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JavaObjectJsonTest {
    public static void main(String[] args) {
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        MyObject myObject = new MyObject("Good1","Good2","Good3");

        String jsonString = gson.toJson(myObject);

        System.out.println("V1:"+jsonString);
        System.out.println("myObject:"+myObject.toString());

        myObject.setName1("BOBOBO1");
        System.out.println("V2:"+jsonString);
        System.out.println("myObject:"+myObject.toString());


    }
}

class MyObject{
    String name1;
    String name2;
    String name3;

    public MyObject(String name1, String name2, String name3) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
    }

    @Override
    public String toString() {
        return "MyEnumObject{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                '}';
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }
}