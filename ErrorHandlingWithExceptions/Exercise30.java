class Annoyance extends RuntimeException {
}

class Sneeze extends Annoyance {
}

class WrapCheckedExceptions {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new Annoyance();
                case 1:
                    throw new Sneeze();
                case 2:
                    throw new RuntimeException("where am I?");
                default:
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class Exercise30 {
    public static void main(String[] args) {
        WrapCheckedExceptions wrapCheckedExceptions = new WrapCheckedExceptions();
        for (int i = 0; i < 4; ++i) {
            try {
                if (i < 3) {
                    wrapCheckedExceptions.throwRuntimeException(i);
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException runtimeException) {
                try {
                    throw runtimeException.getCause();
                } catch (Sneeze e) {
                    System.out.println("Sneeze " + e);
                } catch (Annoyance e) {
                    System.out.println("Annoyance " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable " + e);
                }
            }
        }
    }
}