import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        List<String> fields = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            Annotation[] annotation = field.getDeclaredAnnotations();
            if (annotation.length > 0) {
                fields.add(field.getName());
            }
        }

        String[] fieldsWithAnnotations = new String[fields.size()];

        for (int i = 0; i < fields.size(); i++) {
            fieldsWithAnnotations[i] = fields.get(i);
        }
        return fieldsWithAnnotations;
    }

}