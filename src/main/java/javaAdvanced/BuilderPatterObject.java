package javaAdvanced;

public class BuilderPatterObject {
    private String name;
    private String address;
    private int age;

    public static BuilderPatterObject builder(){
        return new BuilderPatterObject();
    }

    @Override
    public String toString() {
        return "BuilderPatterObject{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public BuilderPatterObject setName(String name){
        this.name = name;
        return this;
    }
    public BuilderPatterObject setAddress(String address){
        this.address = address;
        return this;
    }
    public BuilderPatterObject setAge(int age){
        this.age = age;
        return this;
    }
}
