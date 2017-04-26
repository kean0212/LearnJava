class GenericMethod {
    public <T> String getName(T t) {
        return t.getClass().getName();
    }

    public <A, B, C> void print(A a, B b, C c) {
        System.out.println(getName(a) + " " + getName(b) + " " + getName(c));
    }
}

public class GenericMethods<T> {
    // This triggers compilation error
//    private static void f(T t) {
//        System.out.println("f()");
//    }

    private static <T> void g(T t) {
        System.out.println("g()");
    }

    public static void main(String[] args) {
        g("hello world");

        GenericMethod genericMethod = new GenericMethod();
        genericMethod.print(1, "hello world", 'a');
    }
}