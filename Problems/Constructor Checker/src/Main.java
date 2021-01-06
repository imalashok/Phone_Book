import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 Check whether the class declares public parameterless constructor
 */
class ConstructorChecker {

    public boolean checkPublicParameterlessConstructor(Class<?> clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor con : constructors) {
            int modifiers = con.getModifiers();

            if (Modifier.isPublic(modifiers)) {
                Class[] params = con.getParameterTypes();
                if (params.length == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}