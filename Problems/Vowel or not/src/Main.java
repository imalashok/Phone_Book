import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        List<Character> vowelList = Arrays.asList('a', 'o', 'u', 'i', 'e');

        for (char c : vowelList) {
            if (c == Character.toLowerCase(ch)) {
                return true;
            }
        }
        return false;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}