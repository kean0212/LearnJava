
interface First {
    void first();
}

interface Second extends First {
    void second();
}

interface Third extends First {
    void third();
}

interface Fourth extends Second, Third {
    void fourth();
}

class Real implements Fourth {
    public void first() {}
    public void second() {}
    public void third() {}
    public void fourth() {}
}

public class DiamondProblem {
    public static void main(String[] args) {
        Real real = new Real();
        real.first();
        real.second();
        real.third();
        real.fourth();
    }
}