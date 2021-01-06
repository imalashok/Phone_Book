import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> listArray = new ArrayList<>(Arrays.asList(array));
        ListIterator<String> iter = listArray.listIterator();

        while (iter.hasNext()) {
            String str = iter.next();
            iter.remove();
            if (str.charAt(0) == 'J') {
                iter.add(str.substring(1));
            }
        }

        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}