import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }

            if (table[idx] != null) {
                table[idx] = new TableEntry(key, table[idx].value + " " + value);
            } else {
                table[idx] = new TableEntry(key, value);
            }
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public String entrySet() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    tableStringBuilder.append(table[i].getKey()
                            + ": " + table[i].getValue());
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }

        private int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            // put your code here
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        HashTable<String> hashTable = new HashTable<>(number);

        for (int i = 0; i < number; i++) {
            int key = Integer.parseInt(scanner.next());
            String name = scanner.next();
            hashTable.put(key, name);
        }

        System.out.println(hashTable.entrySet());
    }
}