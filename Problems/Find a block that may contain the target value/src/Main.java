import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            intList.add(scanner.nextInt());
        }
        int targetValue = scanner.nextInt();

        int jumpSize = (int) Math.sqrt(size);
        int leftIndex = 0;
        int rightIndex = Math.min(jumpSize - 1, size - 1);


        while (rightIndex != size - 1) {
            if (targetValue <= intList.get(rightIndex)) {
                break;
            }
            leftIndex = rightIndex + 1;
            rightIndex = Math.min(rightIndex + jumpSize, size - 1);
        }

        if (rightIndex == size - 1 && targetValue > intList.get(rightIndex)) {
            System.out.println(-1);
        } else {
            System.out.println(leftIndex + " " + rightIndex);
        }
    }
}