import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double allocatedMemory = 2.0;
        double size = 0;

        int n = scanner.nextInt();
        double scalingFactor = scanner.nextDouble();
        double downscalingFactor = Double.parseDouble(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "add":
                    int addCount = Integer.parseInt(command[1]);

                    while (addCount != 0) {
                        if (allocatedMemory - size < addCount) {
                            addCount -= (int) (allocatedMemory - size);
                            size = allocatedMemory;
                            allocatedMemory = allocatedMemory * scalingFactor;
                        } else {
                            size += addCount;
                            addCount = 0;
                        }
                    }
                    allocatedMemory = Math.floor(allocatedMemory);
                    break;
                case "delete":
                    int deleteCount = Integer.parseInt(command[1]);

                    if (size >= deleteCount) {
                        size -= deleteCount;
                    }

                    while (allocatedMemory / downscalingFactor >= size) {
                        allocatedMemory = allocatedMemory / downscalingFactor;
                    }
                    allocatedMemory = Math.floor(allocatedMemory);
                    break;
                case "count":
                    System.out.println((int) allocatedMemory);
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}