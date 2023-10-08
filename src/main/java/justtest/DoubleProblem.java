package justtest;


import java.math.BigDecimal;
import java.text.DecimalFormat;

// https://arshadsuraj.medium.com/java-floating-point-numbers-rounding-problem-solution-a07e019b9dd5
public class DoubleProblem {
    public static void main(String[] args) {

        double a=Double.parseDouble("0.000363")*1000;
        System.out.println(""+a);

        DecimalFormat df = new DecimalFormat("0.000");

        BigDecimal b1 = new BigDecimal("0.000363");
        BigDecimal b2 = new BigDecimal("1000");
        BigDecimal b3= b1.multiply(b2);
        System.out.println(df.format(b3));
    }
}
