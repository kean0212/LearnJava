class RootException extends Exception {
}

class SecondLayerException extends RootException {
}

class ThirdLayerException extends SecondLayerException {
}

class A {
    void throwsException() throws RootException {
        throw new RootException();
    }
}

class B extends A {
    void throwsException() throws SecondLayerException {
        throw new SecondLayerException();
    }
}

class C extends B {
    void throwsException() throws ThirdLayerException {
        throw new ThirdLayerException();
    }
}

public class Exercise25 {
    public static void main(String[] args) {
        A c = new C();
        try {
            c.throwsException();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
