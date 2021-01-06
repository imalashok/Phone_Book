package phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phonebook = readPhonebookFromFileToMap();
        List<String> contactsList = readContactsListFromFile();


        ContactsSearcher searcher = new ContactsSearcher();
        searcher.setMethod(new LinearSearchingMethod());
        searcher.search(phonebook, contactsList);

        List<String> sortedPhonebook = readPhonebookFromFileToList();
        searcher.setMethod(new JumpSearchingMethod());
        searcher.search(sortedPhonebook, contactsList);

    }



//    private static List<String> convertMapToListPhonebook(Map<String, String> phonebook) {
//        List<String> phonebookList = new ArrayList<>();
//
//        for (var entry : phonebook.entrySet()) {
//            phonebookList.add(entry.getKey() + " " + entry.getValue());
//        }
//
//        return phonebookList;
//    }

    public static Map<String, String> readPhonebookFromFileToMap() {
        Map<String, String> tempPhonebook = new HashMap<>();
        File file = new File("d:/directory.txt");
//        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                tempPhonebook.put(scanner.next(), scanner.nextLine().trim());
//                count++;
            }

//            System.out.println("Loaded records = " + count);
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }

        return tempPhonebook;
    }

    public static List<String> readPhonebookFromFileToList() {
        List<String> tempPhonebook = new ArrayList<>();
        File file = new File("d:/directory.txt");
//        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                tempPhonebook.add(line.trim());
//                count++;
            }

//            System.out.println("Loaded records = " + count);
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }

        return tempPhonebook;
    }



    public static List<String> readContactsListFromFile() {
        List<String> contactsList = new ArrayList<>();
        File file = new File("d:/find.txt");
//        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                contactsList.add(scanner.nextLine());
//                count++;
            }

//            System.out.println("Loaded records = " + count);
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }

        return contactsList;
    }
}
