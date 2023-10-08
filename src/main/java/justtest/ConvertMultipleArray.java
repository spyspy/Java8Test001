import java.util.Arrays;

public class ConvertMultipleArray {
    public static void main(String[] args) {

        String[] order = {"C002", "C004", "C026", "C099"};

        String[] aa1 = {"C002", "C099", "C026"};
        String[] aa2 = {"C002-1111", "C099-1111", "C026-111"};
        String[] aa3 = {"C002-2222", "C099-2222", "C026-222"};

//        String[] aa1 = {"C004", "C002", "C099", "C026"};
//        String[] aa2 = {"C004-1111","C002-1111", "C099-1111", "C026-111"};
//        String[] aa3 = {"C004-2222","C002-2222", "C099-2222", "C026-222"};

        String[] bb1 = new String[order.length];
        String[] bb2 = new String[order.length];
        String[] bb3 = new String[order.length];

        // Sort aa1 to create bb1
        System.arraycopy(order, 0, bb1, 0, order.length);
//        Arrays.sort(bb1);

        // Reorder aa2 and aa3 based on the sorted order of bb1
        for (int i = 0; i < bb1.length; i++) {
//            int index = indexOf(aa1, bb1[i]);
//            bb2[i] = aa2[index];
//            bb3[i] = aa3[index];

            if((i >= 0) && (i < aa1.length)){
                if(order[0].equals(aa1[i])){
                    bb2[0]=aa2[i];
                    bb3[0]=aa3[i];
                } else if (order[1].equals(aa1[i])) {
                    bb2[1]=aa2[i];
                    bb3[1]=aa3[i];
                } else if (order[2].equals(aa1[i])) {
                    bb2[2]=aa2[i];
                    bb3[2]=aa3[i];
                } else if (order[3].equals(aa1[i])) {
                    bb2[3]=aa2[i];
                    bb3[3]=aa3[i];
                }
            }
        }

        for (int i = 0; i < bb2.length; i++) {
            if (bb2[i] == null) {
                bb2[i] = "";
            }
        }
        for (int i = 0; i < bb3.length; i++) {
            if (bb3[i] == null) {
                bb3[i] = "";
            }
        }

        System.out.println("order: " + Arrays.toString(order));

        // Print bb1
        System.out.println("bb1: " + Arrays.toString(bb1));

        // Print bb2
        System.out.println("bb2: " + Arrays.toString(bb2));

        // Print bb3
        System.out.println("bb3: " + Arrays.toString(bb3));
    }

}