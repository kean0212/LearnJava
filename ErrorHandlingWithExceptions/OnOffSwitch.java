import java.util.*;

class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    public String toString() {
        return state ? "On" : "Off";
    }
}

class OnOffExceptionOne extends Exception {
}

class OnOffExceptionTwo extends Exception {
}

public class OnOffSwitch {
    private static Switch aSwitch = new Switch();
    static Integer[] array = new Integer[1];

    public static void f(int x) throws OnOffExceptionOne, OnOffExceptionTwo {
    }

    public static void main(String[] args) {
        try {
            aSwitch.on();
            f(array[1]);
            aSwitch.off();
        } catch (OnOffExceptionOne exceptionOne) {
            System.out.println("OnOffExceptionOne");
            aSwitch.off();
        } catch (OnOffExceptionTwo exceptionTwo) {
            System.out.println("OnOffExceptionTwo");
            aSwitch.off();
        }
    }
}

