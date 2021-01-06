import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        List<String> fields = new ArrayList<>();

        for (Field f : declaredFields) {
            int modifiers = f.getModifiers();

            if (Modifier.isPublic(modifiers)) {
                fields.add(f.getName());
            }
        }

        String[] publicFields = new String[fields.size()];

        for (int i = 0; i < fields.size(); i++) {
            publicFields[i] = fields.get(i);
        }
        return publicFields;
    }

}