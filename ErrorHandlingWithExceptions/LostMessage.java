class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception.";
    }
}

class ExceptionThree extends Exception {
    public String toString() {
        return "Third exception.";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    void lala() throws ExceptionThree {
        throw new ExceptionThree();
    }

    public static void main(String[] args) {
        try {
            LostMessage lostMessage = new LostMessage();
            try {
                try {
                    lostMessage.f();
                    lostMessage.dispose();
                } finally {
                    lostMessage.lala();
                }
            } catch (Exception exception){
                System.out.println(exception);
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}


