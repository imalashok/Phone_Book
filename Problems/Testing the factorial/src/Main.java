public long get(int x) {
    if (x < 0) {
        return -1L;
    } else if (x == 0 || x == 1) {
        return 1L;
    } else {
        return (long) (x * get(x - 1));
    }
}