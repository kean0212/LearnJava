class FailingConstructor {
    Integer[] array = new Integer[2];
    String string;

    public FailingConstructor(String string) throws Exception {
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        this.string = string;
    }
}

public class Exercise22 {
    public static void main(String[] args) {
        try {
            FailingConstructor failingConstructor = new FailingConstructor("hello world");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace(System.out);
        }
    }
}