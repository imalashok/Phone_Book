import java.util.List;

class QualityControl {

    public static boolean check(List<Box<?>> boxes) {
        if (boxes.isEmpty()) {
            return true;
        }

        try {
            for (Box box : boxes) {
                if (box == null) {
                    return false;
                }

                if (box.getClass().toGenericString().endsWith("String")) {
                    return false;
                }

                if (box.get().getClass().toGenericString().endsWith("String")) {
                    return false;
                }


                Bakery b = (Bakery) box.get();
            }
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }
}

// Don't change the code below
class Bakery {
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}

class Paper {
}

class Box<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}