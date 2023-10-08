package javaOldAdvanced.genericTest;

import java.lang.reflect.Method;

public class GenericReflection {
    public static void main(String[] args) {


        TestObject testObject = new TestObject();
        Class wow;

        Method[] methods = testObject.getClass().getMethods();
        for(Method mm : methods){
            System.out.println("method Name : "+mm.getName());
        }



    }
}

class TestObject{
    String name;
    String address;

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
}
