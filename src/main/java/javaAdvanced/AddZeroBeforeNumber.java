package javaAdvanced;

public class AddZeroBeforeNumber {
    public static void main(String[] args) {
        int myint = 0;

        for(myint =1 ; myint<=200;myint=myint+30){

            //From int to String
            String  myintStr = String.valueOf(myint);

            // 15 digit         //123456789012345
            String paddingSize = "000000000000000";

            System.out.println((paddingSize+myintStr).substring(myintStr.length()));
        }


        int num = 999;
        String numStr = String.valueOf(num);
        System.out.println("numStr.length():"+numStr.length());

        String formatted = String.format("%010d", num);

        System.out.println("formatted:"+formatted);
    }
}
