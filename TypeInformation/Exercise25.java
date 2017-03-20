import java.lang.reflect.*;

public class Exercise25 {
    public static void main(String[] args) {
        try {
            Class<?> subClass = Class.forName(args[0]);
            for (Method method : subClass.getDeclaredMethods()) {
                method.setAccessible(true);
                try {
                    method.invoke(subClass.newInstance());
                } catch (Exception exception) {
                    System.out.println("Method cannot be invoked: " + exception);
                }
            }
        } catch (ClassNotFoundException exception) {
            System.out.println("Class not found: " + exception);
        }

    }
}