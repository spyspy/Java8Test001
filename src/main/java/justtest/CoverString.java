package justtest;

public class CoverString {
    public static void main(String[] args) {
        String originalString = "abcdefghijklmyesterday";
        int start = 5; // Starting index of the portion to cover
        int end = 16; // Ending index of the portion to cover

        String coveredString = coverString(originalString, start, end);
        System.out.println(coveredString);
    }

    private static String coverString(String original, int start, int end) {
        String covered = original.substring(0, start); // Extract the portion before the covered part

        int coveredLength = end - start; // Calculate the length of the covered part
        for (int i = 0; i < coveredLength; i++) {
            covered += "*"; // Add asterisks for the covered part
        }

        covered += original.substring(end); // Append the portion after the covered part

        return covered;
    }
}
