import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        Field[] allFields = object.getClass().getFields();

        for (Field f : allFields) {
            int modifiers = f.getModifiers();

            if (Modifier.isPublic(modifiers) && f.getName().equals(fieldName)) {
                return f.get(object);
            }
        }

        return null;
    }
}