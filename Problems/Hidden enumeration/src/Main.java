public class Main {

    public static void main(String[] args) {
        int i = 0;
        for (Secret secret : Secret.values()) {
            if (secret.name().startsWith("STAR")) {
                i++;
            }
        }
        System.out.print(i);
    }
}

//// sample enum for inspiration
//   enum Secret {
//    STAR, CRASH, START, // ...
//}
