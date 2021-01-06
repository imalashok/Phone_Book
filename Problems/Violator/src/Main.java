import java.util.ArrayList;

/**
 * Class to work with
 */
class Violator {

    public static List<Box<? extends Bakery>> defraud() {
        List<Box<? extends Bakery>> objects = new ArrayList();
        Box box = new Box<>();
        box.put(new Paper());
        objects.add(box);

        return objects;
    }
}