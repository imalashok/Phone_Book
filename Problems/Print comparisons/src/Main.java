import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();

        int jumpSize = (int) Math.sqrt(size);
        int currentIndex = 0;
        int numberOfComparisons = 1;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                intList.add(numberOfComparisons);
            } else {
                while (i > currentIndex) {
                    currentIndex = Math.min(currentIndex + jumpSize, size - 1);
                    numberOfComparisons += 1;

                    if (i <= currentIndex) {
                        numberOfComparisons += currentIndex - i;
                        intList.add(numberOfComparisons);
                    }
                }
                numberOfComparisons = 1;
                currentIndex = 0;
            }
        }

        for (Integer i : intList) {
            System.out.print(i + " ");
        }
    }
}