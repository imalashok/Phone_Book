package phonebook;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContactsSearcher {

    private SearchingMethod method;
    public static long linearSearchTime = Long.MAX_VALUE;
    public static long jumpSearchTime = Long.MAX_VALUE;
    public static long bubbleSortingTime = 0;
    public static boolean isBubbleSorted = false;
    private Map<String, String> phonebookMap;


    public void setMethod(SearchingMethod method) {
        this.method = method;
    }

    public void search(Map<String, String> phonebook, List<String> contactsList) {
        phonebookMap = phonebook;
        long startingTime = System.currentTimeMillis();

        System.out.println("Start searching (linear search)...");

        this.method.search(phonebook, contactsList);

        long endingTime = System.currentTimeMillis();
        long msDuration = endingTime - startingTime;

        linearSearchTime = msDuration;

        long min = msDuration / 60000;
        msDuration = msDuration % 60000;
        long sec = msDuration / 1000;
        msDuration = msDuration % 1000;

        System.out.printf("Time taken: %d min. %d sec. %d ms.\n", min, sec, msDuration);
    }

    public void search(List<String> phonebook, List<String> contactsList) {

        System.out.println("\nStart searching (bubble sort + jump search)...");

        isBubbleSorted = bubbleSort(phonebook);

        long startingTime = System.currentTimeMillis();

        this.method.search(phonebook, contactsList);

        long endingTime = System.currentTimeMillis();
        jumpSearchTime = endingTime - startingTime;

        long min;
        long sec;

        if (isBubbleSorted) {
            long totalTime = bubbleSortingTime + jumpSearchTime;
            min = totalTime / 60000;
            totalTime = totalTime % 60000;
            sec = totalTime / 1000;
            totalTime = totalTime % 1000;

            System.out.printf("Time taken: %d min. %d sec. %d ms.\n", min, sec, totalTime);

            min = bubbleSortingTime / 60000;
            bubbleSortingTime = bubbleSortingTime % 60000;
            sec = bubbleSortingTime / 1000;
            bubbleSortingTime = bubbleSortingTime % 1000;

            System.out.printf("Sorting time: %d min. %d sec. %d ms.\n", min, sec, bubbleSortingTime);

            min = jumpSearchTime / 60000;
            jumpSearchTime = jumpSearchTime % 60000;
            sec = jumpSearchTime / 1000;
            jumpSearchTime = jumpSearchTime % 1000;

            System.out.printf("Searching time: %d min. %d sec. %d ms.\n", min, sec, jumpSearchTime);
        } else {
            LinearSearchingMethod linearSearchingMethod = new LinearSearchingMethod();
            startingTime = System.currentTimeMillis();

            linearSearchingMethod.search(phonebookMap, contactsList);

            endingTime = System.currentTimeMillis();

            linearSearchTime = endingTime - startingTime;

            long totalTime = bubbleSortingTime + linearSearchTime;
            min = totalTime / 60000;
            totalTime = totalTime % 60000;
            sec = totalTime / 1000;
            totalTime = totalTime % 1000;

            System.out.printf("Time taken: %d min. %d sec. %d ms.\n", min, sec, totalTime);

            min = bubbleSortingTime / 60000;
            bubbleSortingTime = bubbleSortingTime % 60000;
            sec = bubbleSortingTime / 1000;
            bubbleSortingTime = bubbleSortingTime % 1000;

            System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search\n", min, sec, bubbleSortingTime);

            min = linearSearchTime / 60000;
            linearSearchTime = linearSearchTime % 60000;
            sec = linearSearchTime / 1000;
            linearSearchTime = linearSearchTime % 1000;

            System.out.printf("Searching time: %d min. %d sec. %d ms.\n", min, sec, linearSearchTime);
        }
    }

    public static boolean bubbleSort(List<String> phonebook) {

        long startingTime = System.currentTimeMillis();
        long endingTime;

        for (int i = 0; i < phonebook.size() - 1; i++) {
            for (int j = 0; j < phonebook.size() - i - 1; j++) {
                endingTime = System.currentTimeMillis();
                long breakPointTime = linearSearchTime * 10;

                if ((endingTime - startingTime) >= breakPointTime) {
                    bubbleSortingTime = endingTime - startingTime;
                    return false;
                }

                String word1 = phonebook.get(j);
                String word2 = phonebook.get(j + 1);

                Scanner scan = new Scanner(word1);
                scan.next();
                String word1Part2 = scan.nextLine().trim();

                scan = new Scanner(word2);
                scan.next();
                String word2Part2 = scan.nextLine().trim();


                if (word1Part2.compareToIgnoreCase(word2Part2) > 0) {
                    phonebook.remove(j);
                    phonebook.add(j, word2);
                    phonebook.remove(j + 1);
                    phonebook.add(j + 1, word1);
                    //System.out.println("Replaced " + i + " " + j);
                }
            }
        }

        endingTime = System.currentTimeMillis();

        bubbleSortingTime = endingTime - startingTime;

        return true;
    }
}
