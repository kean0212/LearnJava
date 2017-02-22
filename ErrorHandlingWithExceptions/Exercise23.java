class Disposable {
    private static int counter = 0;
    private int id = counter++;
    private boolean disposed;

    Disposable() {
        disposed = false;
    }

    void dispose() {
        disposed = true;
    }

    String checkStatus() {
        return id + " " + (disposed ? "disposed" : "not disposed");
    }
}

public class Exercise23 {
    private Integer[] array = new Integer[2];
    private static Disposable disposableOne;
    private static Disposable disposableTwo;

    Exercise23() throws Exception {
        try {
            disposableOne = new Disposable();
            try {
                array[2] = 2;
                try {
                    disposableTwo = new Disposable();
                } catch (Exception e) {
                    System.out.println("Exception with creating the second disposable object.");
                    e.printStackTrace(System.out);
                    disposableOne.dispose();
                }
            } catch (Exception e) {
                System.out.println("Index out of bound");
                e.printStackTrace(System.out);
                disposableOne.dispose();
            }
        } catch (Exception e) {
            System.out.println("Exception with creating the first disposable object.");
            e.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        try {
            Exercise23 exercise23 = new Exercise23();
        } catch (Exception e) {
            System.out.println("Exception caught in main()");
            e.printStackTrace(System.out);
        }
    }
}