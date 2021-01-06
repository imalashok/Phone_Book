// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> boolean hasNull(T[] list) {
        for (var t : list) {
            if (t == null) {
                return true;
            }
        }
        return false;
    }
}