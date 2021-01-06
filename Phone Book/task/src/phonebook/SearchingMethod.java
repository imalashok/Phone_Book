package phonebook;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface SearchingMethod {

    void search(Map<String, String> phonebook, List<String> contactsList);

    void search(List<String> phonebook, List<String> contactsList);
}

class LinearSearchingMethod implements SearchingMethod {

    @Override
    public void search(Map<String, String> phonebook, List<String> contactsList) {
        int contactsListLength = contactsList.size();
        int foundContactsCount = 0;

        for (String name : contactsList) {
            for (String nameInPhonebook : phonebook.values()) {

                if (name.equals(nameInPhonebook)) {
                    foundContactsCount++;
                    break;
                }
            }
        }

        System.out.print("Found " + foundContactsCount + " / " + contactsListLength + " entries. ");
    }

    @Override
    public void search(List<String> phonebook, List<String> contactsList) {

    }
}

class JumpSearchingMethod implements SearchingMethod {

    @Override
    public void search(Map<String, String> phonebook, List<String> contactsList) {
    }

    @Override
    public void search(List<String> phonebook, List<String> contactsList) {

        //System.out.println(phonebook);

    }
}