import java.lang.reflect.*;

public class Exercise19 {
    public static void main(String[] args) {
        try {
            Class<?> toyClass = Class.forName("Toy");
            Constructor nonDefaultConstructor = null;
            for (Constructor constructor : toyClass.getConstructors()) {
                if (!constructor.isSynthetic()) {
                    try {
                        Object toy = constructor.newInstance(3);
                    } catch (Exception excecption) {
                        System.out.println("Failed to instantiate the object: " + excecption);
                    }
                }
            }
        } catch (ClassNotFoundException exception) {
            System.out.println("Class not found: " + exception);
        }
    }
}