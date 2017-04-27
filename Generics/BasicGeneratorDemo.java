interface Generator<T> {
    T next();
}

class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    public T next() {
        try {
            return type.newInstance();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to create instance", exception);
        }
    }

    public static <T> BasicGenerator<T> create(Class<T> type) {
        return new BasicGenerator(type);
    }
}

class CountedObject {
    private static int count = 0;
    private int id = count++;

    public String toString() {
        return "CountedObject " + id;
    }
}

public class BasicGeneratorDemo {
    public static void main(String[] args) {
//        Use the static method
//        BasicGenerator<CountedObject> countedObjectBasicGenerator =
//                BasicGenerator.create(CountedObject.class);
        BasicGenerator<CountedObject> countedObjectBasicGenerator =
                new BasicGenerator(CountedObject.class);
        for (int i = 0; i < 10; ++i) {
            System.out.println(countedObjectBasicGenerator.next());
        }
    }
}