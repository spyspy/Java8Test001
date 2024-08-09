package checkNullpoint;

import java.util.Objects;

public class checkNullpoint001 {
    public static void main(String[] args) {

        // 使用 String.equals  VS 使用 Java 7.0 引進的 Objects.equals

        TestObj testObj1 = new TestObj("A11","V111","C111","99");
        TestObj testObj2 = new TestObj("A11","C111",null,"69");

        if(!Objects.equals(testObj1.getAddress(),testObj2.getAddress())){
            System.out.println("no equal");
        }else {
            System.out.println("equal");
        }

        if(!Objects.equals(testObj1.getCode(),testObj2.getCode())){
            System.out.println("no equal");
        }else {
            System.out.println("equal");
        }

        if(!testObj1.getAddress().equals(testObj2.getAddress())){
            System.out.println("no equal");
        }else {
            System.out.println("equal");
        }

        // Exception in thread "main" java.lang.NullPointerException:
        if(!testObj2.getAddress().equals(testObj1.getAddress())){
            System.out.println("no equal");
        }else {
            System.out.println("equal");
        }
    }
}

class TestObj {
    String code;
    String name;
    String address;
    String age;

    public TestObj(String code, String name, String address, String age) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
