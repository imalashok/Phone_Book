import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int levelsValue = 0;

        while (scanner.hasNext()) {
            String level = scanner.next();

            switch (level.toLowerCase()) {
                case "severe":
                    levelsValue += 1000;
                    break;
                case "warning":
                    levelsValue += 900;
                    break;
                case "info":
                    levelsValue += 800;
                    break;
                case "config":
                    levelsValue += 700;
                    break;
                case "fine":
                    levelsValue += 500;
                    break;
                case "finer":
                    levelsValue += 400;
                    break;
                case "finest":
                    levelsValue += 300;
                    break;
                default:
                    break;
            }
        }

        System.out.println(levelsValue);
    }
}