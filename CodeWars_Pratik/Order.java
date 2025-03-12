package CodeWars_Pratik;

public class Order {
    public static void main(String[] args) {
        String words = "is2 Thi1s T4est 3a";
        String[] wordsArray = words.trim().split("\\s+"); // Split into words
        String[] sortedArray = new String[wordsArray.length]; // Array for sorted words

        // Iterate through each word to extract its number and place it in the correct position
        for (String word : wordsArray) {
            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    int position = Character.getNumericValue(c) - 1; // Convert char to int index (1-based to 0-based)
                    sortedArray[position] = word; // Place word in correct position
                    break; // Move to next word after finding digit
                }
            }
        }

        // Join sorted words into a sentence
        String sortedSentence = String.join(" ", sortedArray);
        System.out.println(sortedSentence); // Output: "This is a Test"

    }
}
