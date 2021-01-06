// Do not remove imports
import java.lang.reflect.*;
import java.util.Scanner;

class TypeVariablesInspector {
    public void printTypeVariablesCount(TestClass obj, String methodName) throws Exception {
        try {
            Class clazz = obj.getClass();
            Method method = clazz.getDeclaredMethod(methodName);
            TypeVariable<Method>[] typeVariables = method.getTypeParameters();
            System.out.println(typeVariables.length);

        } catch (Exception e) {
            System.out.println(0);
        }


    }
}