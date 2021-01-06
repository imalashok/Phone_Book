class Problem {
    public static void main(String[] args) {

        String modeValue = "default";

        for (int i = 0; i < args.length; i++) {
            if ("mode".equals(args[i]) && args.length > i + 1) {
                modeValue = args[i + 1];
                break;
            }
        }

        System.out.println(modeValue);
    }
}