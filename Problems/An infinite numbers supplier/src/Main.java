import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<Integer>() {
            int nextNumber = -1;

            @Override
            public Integer get() {
                nextNumber++;
                return nextNumber;
            }
        };
    }

}