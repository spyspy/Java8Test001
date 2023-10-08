package javaAdvanced;

public class BuilderPattern {
    public static void main(String[] args) {

        System.out.println(BuilderPatterObject.builder().setAge(99).setName("Johnnnny").setAddress("New York").toString());

    }
}
