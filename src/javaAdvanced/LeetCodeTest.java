package javaAdvanced;

public class LeetCodeTest {
    public static void main(String[] args) {

        char[] charArray1 ={'h','e','l','l','o'};


        int www = charArray1.length;


        char[] modify1 = new char[www];

        int count = www;

        for(char wo : charArray1){
            count--;
            modify1[count] = wo;
            System.out.println("count:"+count +" | wo:"+wo);
        }

        for(char go : modify1){
            System.out.print(go);
        }
        System.out.println("=================");
        char[] charArray2 ={'H','a','n','n','a','h'};
        //                   0   1   2   3   4   5
        reverseString(charArray2);
        for(char go : charArray2){
            System.out.print(go);
        }


    }

    public static void reverseString(char[] s){
        char i;//暫存空間
        for(int x = 0 ; x<s.length/2; x++){
            i = s[x];//原始array放入暫存  (第一次是第一個字元)
            s[x] = s[s.length-1-x]; //把剛剛已經放入暫存的空間塞入(第一次是塞入將s[6-1-0] => s[5] 塞入 s[0])
            s[s.length-1-x] = i;    //把暫存空間的放入s[5]  因為上面已經移位了
        }
    }

}
