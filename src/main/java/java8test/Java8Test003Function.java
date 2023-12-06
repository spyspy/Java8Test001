package java8test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8Test003Function {
    public static void main(String[] args) {

        //Function's features: one parameter, return a value
        Java8Test003Function test = new Java8Test003Function();
        // 定義 Function 當成參數
        System.out.println(myCompute(11, value->{return 2*value;}));
        System.out.println(myCompute(11, value-> 99+value));

        //function's default method
        System.out.println("compose: "+myComputeFor2Fun1(1, value-> 99+value,value->value*value));//100
        System.out.println("andThen: "+myComputeFor2Fun2(1, value-> 99+value,value->value*value));//10000

        System.out.println(" =============== BiFunction ===============");

        //BiFunction
        //For Example: 1 + 2 = 3  There are three parameter involved
        System.out.println(test.myComputeForBiFun1(2,3,(v1,v2)->v1+v2));
        System.out.println(test.myComputeForBiFun1(2,3,(v1,v2)->v1-v2));
        System.out.println(test.myComputeForBiFun1(2,3,(v1,v2)->v1*v2));
        System.out.println(test.myComputeForBiFun1(2,3,(v1,v2)->v1/v2));

        //BiFunction's defautl method. No compose(), Only andThen();
        System.out.println(test.myComputeForBiFun2(2,3,(v1,v2)->v1+v2,v1->v1*v1));// (2+3) => 5*5 =25



    }

    // 定義 Function 當成參數
    // Function<參數,結果> (單一參數的方法，BiFunction則是兩個參數，一個結果)
    private static int myCompute(int a, Function<Integer,Integer> function) {

        int result = function.apply(a);

        return result;
    }

    //function's default method: compose (串接兩個function )
    // ==> execute parameter function(f2) first, then itself(subject function f1)
    private static int myComputeFor2Fun1(int a,Function<Integer,Integer> f1,Function<Integer,Integer> f2){
        //  a   f1              f2
        // (1, value-> 99+value,value->value*value)
        // f2 => 1*1=1  (得到結果，繼續給下一個要執行的function f1)
        // f1 => 1+99 = 100 (result)
        return f1.compose(f2).apply(a);
    };
    //function's default method: andThen
    // ==> execute itself(subject function f1) first, then parameter function(f2)
    private static int myComputeFor2Fun2(int a,Function<Integer,Integer> f1,Function<Integer,Integer> f2){
        //  a   f1              f2
        // (1, value-> 99+value,value->value*value)
        // f1 => 1+99 =100 (得到結果，繼續給下一個要執行的function f2)
        // f2 => 100*100=10000
        return f1.andThen(f2).apply(a);
    };

    //BiFunction
    // Two input, One return
    private int myComputeForBiFun1(int a,int b,BiFunction<Integer,Integer,Integer> biFun1) {
        return biFun1.apply(a, b);
    }
    //BiFunction: Default method: andThen()
    //Why use funciton as second parameter? Because BiFuntion only return one value.
    //Thats why andThen() can get only one parameter.
    private int myComputeForBiFun2(int a,int b,BiFunction<Integer,Integer,Integer> biFun1,Function<Integer,Integer> fun1) {
        return biFun1.andThen(fun1).apply(a, b);
    }

}
