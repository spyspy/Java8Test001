package javaAdvanced.enumTest;

public class EnumTest2 {
    public static void main(String[] args) {

        int aa = countFoobangs(FB_TYPE.SWEET);
        System.out.println(aa);

    }

    public static int countFoobangs(FB_TYPE type){
        String bb = type.name();
        int rtn = 0;

        switch (bb){
            case "GREEN":
                System.out.println("Green!!!");
                rtn = 1;
                break;
            case "WRINKLED":
                System.out.println("WRINKLED!!!");
                rtn =2;
                break;
            default:
                System.out.println("Invalid Code!!");

        }


        return rtn;
    }
}

enum FB_TYPE {
    GREEN, WRINKLED, SWEET,
    /** special type for all types combined */
    ALL;
}
