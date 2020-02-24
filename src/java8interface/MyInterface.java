package java8interface;

interface MyInterface {

    void interfaceAction1(String str);

    void interfaceAction2(String str);

    void interfaceAction3(String str);

    default void defaultNewMethod() {
        System.out.println("Newly added default method");
    }

    static void staticNewMethod(){
        System.out.println("Newly added static method");
    }
}
