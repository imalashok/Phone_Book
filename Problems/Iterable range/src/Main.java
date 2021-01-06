import java.util.Iterator;

class Range implements Iterable<Long> {

    private long fromInclusive;
    private long toExclusive;

    public Range(long from, long to) {
        this.fromInclusive = from;
        this.toExclusive = to;
    }

    @Override
    public Iterator<Long> iterator() {

        return new Iterator<Long>() {

            long currentPosition = fromInclusive;

            @Override
            public boolean hasNext() {
                return currentPosition < toExclusive;
            }

            @Override
            public Long next() {
                return currentPosition++;
            }
        };
    }
}