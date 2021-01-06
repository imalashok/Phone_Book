import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Get sorted list of private fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public List<String> getPrivateFields(Object object) {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        List<String> fields = new ArrayList<>();

        for (Field f : declaredFields) {
            int modifiers = f.getModifiers();

            if (Modifier.isPrivate(modifiers)) {
                fields.add(f.getName());
            }
        }

        Collections.sort(fields);

        return fields;
    }

}