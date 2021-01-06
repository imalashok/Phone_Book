import java.lang.reflect.Method;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) {
        try {

            for (String name : classNames) {
                Method[] allMethods = Class.forName(name).getMethods();

                for (Method method : allMethods) {
                    if (method.getName().equals(methodName)) {
                        return name;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            return null;
        }

        return null;
    }
}