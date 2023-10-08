package java8interface;

public class TestClass2 implements MyInterface {
    @Override
    public void interfaceAction1(String str) {
        System.out.println("TestClass2 interfaceAction1");
    }

    @Override
    public void interfaceAction2(String str) {
        System.out.println("TestClass2 interfaceAction2");
    }

    @Override
    public void interfaceAction3(String str) {
        System.out.println("TestClass2 interfaceAction3");
    }
}
