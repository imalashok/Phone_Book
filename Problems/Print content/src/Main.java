// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {

    public static <E> String info(E[] array) {
        String s = "";

        s += "[";
        for (int i = 0; i < array.length; i++) {
            s += array[i];
            if (i < array.length - 1) {
                s += ", ";
            }
        }
        return s += "]";
    }
}