package javaAdvanced.enumTest;

public class EnumTest3 {

    public enum GoHead{
        Test1(1),
        Test2(2),
        Test3(3);

        private int value;

        private GoHead(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {


    }
}
