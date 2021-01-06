import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            intList.add(scanner.nextInt());
        }
        int targetValue = scanner.nextInt();

        int jumpSize = (int) Math.sqrt(size);
        int numberOfComparisons = 0;

        int leftIndex = 0;
        int rightIndex = 0;

        if (intList.get(0) == targetValue) {
            numberOfComparisons++;
        } else {
            while (rightIndex < size - 1) {

                numberOfComparisons++;


                if (intList.get(rightIndex) >= targetValue) {
                    numberOfComparisons--;
                    break;
                }

                leftIndex = rightIndex;
                rightIndex = Math.min(rightIndex + jumpSize, size - 1);
            }
        }

        if (targetValue <= intList.get(rightIndex)) {
            numberOfComparisons += backwardSearch(intList, targetValue, leftIndex, rightIndex);
        }

        if (rightIndex == size - 1 && intList.get(rightIndex) < targetValue) {
            numberOfComparisons++;
        }

        System.out.println(numberOfComparisons);
    }

    private static int backwardSearch(List<Integer> intList, int targetValue, int leftIndex, int rightIndex) {
        int backwardNumberOfComparisons = 0;

        for (int i = rightIndex; i > leftIndex; i--) {
            backwardNumberOfComparisons++;

            if (intList.get(i) <= targetValue) {
                break;
            }
        }
        return backwardNumberOfComparisons;
    }
}