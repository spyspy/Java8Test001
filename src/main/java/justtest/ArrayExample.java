package justtest;

public class ArrayExample {
    public static void main(String[] args) {
        String[] array1 = {"C002-1111", null, "C026-111", null};
        String[] array2 = new String[0]; // An empty array
        String[] array3 = null; // A null array
        String[] array4 = {null, null, null, null};


        boolean isEmptyOrNull1 = isNullOrEmpty(array1);
        boolean isEmptyOrNull2 = isNullOrEmpty(array2);
        boolean isEmptyOrNull3 = isNullOrEmpty(array3);
        boolean isEmptyOrNull4 = isNullOrEmpty(array4);


        System.out.println("isEmptyOrNull1: " + isEmptyOrNull1); // false (contains non-null elements)
        System.out.println("isEmptyOrNull2: " + isEmptyOrNull2); // true (array is empty)
        System.out.println("isEmptyOrNull3: " + isEmptyOrNull3); // true (array is null)
        System.out.println("isEmptyOrNull4: " + isEmptyOrNull4); // true (array is null)
    }

    private static boolean isNullOrEmpty(String[] array) {
        return array == null || array.length == 0 || allNullElements(array);
    }

    private static boolean allNullElements(String[] array) {
        for (String element : array) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }
}
