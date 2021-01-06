import java.util.Scanner;

public class Main {
    static int size = 5;
    static HashTable hashTable = new HashTable<>(size);

    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

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

        public void remove() {
             removed = true;   
        }

        public boolean isRemoved() {
             return removed;   
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
                rehash();
                idx = findKey(key);
            }

            table[idx] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            int idx = findKey(key);

            if (idx != -1 && !(table[idx] == null) && table[idx].getKey() == key) {
                table[idx].remove();
            }
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
            size = table.length * 2;
            TableEntry[] tempTable = new TableEntry[size];
            TableEntry[] tableCopy = new TableEntry[table.length];
            System.arraycopy(table, 0, tableCopy, 0, table.length);

            table = tempTable;
            for (TableEntry entry : tableCopy) {
                hashTable.put(entry.getKey(), entry.getValue());
            }
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue()
                                                + ", removed=" + table[i].isRemoved());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfInsertions = scanner.nextInt();
        int numberOfDeletions = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numberOfInsertions; i++) {
            int key = scanner.nextInt();
            String value = scanner.nextLine().trim();

            hashTable.put(key, value);
        }

        for (int i = 0; i < numberOfDeletions; i++) {
            int key = scanner.nextInt();
            hashTable.remove(key);
        }
        System.out.println(hashTable.toString());
    }
}