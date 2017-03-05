class Candy {
    static {
        System.out.println("Loading Candy");
    }

    public String toString() {
        return "Candy";
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }

    public String toString() {
        return "Gum";
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }

    public String toString() {
        return "Cookie";
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        String className = args[0];
        try {
            Class requestedClass = Class.forName(className);
            Object object = requestedClass.newInstance();
            System.out.println(object);
        } catch (ClassNotFoundException e) {
            System.out.println(className + " cannot be found");
        } catch (InstantiationException e) {
            System.out.println(className + " cannot be instantiated");
        } catch (IllegalAccessException e) {
            System.out.println(className + " cannot be accessed");
        }
    }
}
