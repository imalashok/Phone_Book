import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> list = stream.collect(Collectors.toList());

        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.stream().min(order).get(), list.stream().max(order).get());
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
}