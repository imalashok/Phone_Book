import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();
        editDistanceAlignment(firstWord, secondWord);
    }

    public static int match(char a, char b) {
        return (a == b) ? 0 : 5;
    }

    public static void editDistanceAlignment(String s, String t) {
        int[][] d = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            d[i][0] = i * 3;
        }

        for (int j = 0; j < t.length() + 1; j++) {
            d[0][j] = 0;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                int insCost = d[i][j - 1] + 3;
                int delCost = d[i - 1][j] + 3;
                int subCost = d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1));
                d[i][j] = Math.min(Math.min(insCost, delCost), subCost);
            }
        }

        reconstructAlignment(d, s, t);
    }

    public static void reconstructAlignment(int[][] d, String s, String t) {

//        for (int i = 0; i < s.length() + 1; i++) {
//            for (int j = 0; j < t.length() + 1; j++) {
//                System.out.print(d[i][j] + " ");
//            }
//            System.out.println();
//        }

        StringBuilder ssBuilder = new StringBuilder();
        StringBuilder ttBuilder = new StringBuilder();
        int i = s.length();
        int j = t.length();

        int minJDist = Integer.MAX_VALUE;

        for (int k = 1; k < t.length() + 1; k++) {
            if (d[s.length()][k] <= minJDist) {
                minJDist = d[s.length()][k];
                j = k;
            }
        }

        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && d[i][j] == d[i - 1][j - 1] + match(s.charAt(i - 1), t.charAt(j - 1))) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append(t.charAt(j - 1));
                i -= 1;
                j -= 1;
            } else if (j > 0 && d[i][j] == d[i][j - 1] + 3) {
                ssBuilder.append("-");
                ttBuilder.append(t.charAt(j - 1));
                j -= 1;
            } else if (i > 0 && d[i][j] == d[i - 1][j] + 3) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append("-");
                i -= 1;
            } else if (i == 0) {
                break;
            } else if (i > 0 && j == 0) {
                ssBuilder.append(s.charAt(i - 1));
                ttBuilder.append("-");
                i -= 1;
            }
        }

        String ss = ssBuilder.reverse().toString();
        String tt = ttBuilder.reverse().toString();

        Alignment alignment = new Alignment(minJDist, ss, tt);

        System.out.println(alignment.editDistance);
        System.out.println(alignment.source);
        System.out.println(alignment.target);
    }
}


class Alignment {
    public int editDistance;
    public String source;
    public String target;

    public Alignment(int editDist, String source, String target) {
        this.editDistance = editDist;
        this.source = source;
        this.target = target;
    }
}