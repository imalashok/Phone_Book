import java.lang.reflect.Field;

/**
 Get number of fields class declares (the ones inherited should be excluded).
 */
class FieldGetter {

    public int getNumberOfFieldsClassDeclares(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        return fields.length;
    }

}