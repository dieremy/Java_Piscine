import java.util.Scanner;

public class Program {

    // Count character occurrences in the text
    private static int[] countCharacterOccurrences(String text) {
        int[] occurrences = new int[65536]; // Assuming Unicode BMP
        char[] chars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            char c = chars[i];
            occurrences[c]++;
        }
        return occurrences;
    }

    // Sort characters by occurrence count and lexicographic order
    private static void sortCharactersByOccurrences(char[] characters, int[] occurrences) {
        for (int i = 0; i < characters.length - 1; i++) {
            for (int j = 0; j < characters.length - i - 1; j++) {
                if (occurrences[characters[j]] < occurrences[characters[j + 1]] ||
                        (occurrences[characters[j]] == occurrences[characters[j + 1]] &&
                                characters[j] > characters[j + 1])) {
                    // Swap characters
                    char temp = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temp;
                }
            }
        }
    }

    // Display histogram with the top 10 most frequent characters
    private static void displayHistogram(char[] characters, int[] occurrences) {
        // Display only the top 10 most frequent characters
        int maxOccurrences = occurrences[characters[0]];
        int scaleFactor = (maxOccurrences + 9) / 10; // Scale factor for proportional display

        for (int i = 10; i > 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (j < characters.length) {
                    int count = occurrences[characters[j]];
                    int scaledCount = (count + scaleFactor - 1) / scaleFactor;
                    if (scaledCount >= i) {
                        System.out.print("# ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }

        // Print character labels
        for (int j = 0; j < 10; j++) {
            if (j < characters.length) {
                System.out.print(characters[j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        // Read input text
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();

        // Count character occurrences
        int[] occurrences = countCharacterOccurrences(text);

        // Create an array to hold all possible characters
        char[] characters = new char[65536];
        int charIndex = 0;
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > 0) {
                characters[charIndex] = (char) i;
                charIndex++;
            }
        }

        // Sort characters by occurrence count
        sortCharactersByOccurrences(characters, occurrences);

        // Display histogram
        displayHistogram(characters, occurrences);
    }
}
