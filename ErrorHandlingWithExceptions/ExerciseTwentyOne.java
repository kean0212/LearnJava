class BaseException extends Exception {

}

class Base {
    public Base() throws BaseException {
        throw new BaseException();
    }
}

class Derived extends Base {
    public Derived() throws BaseException {
        super();
//        try {
//            super();
//        } catch (BaseException e) {
//            System.out.println("BaseException caught in Derived()");
//        }
    }
}

public class ExerciseTwentyOne {
    public static void main(String[] args) {
        try {
            Derived derived = new Derived();
        } catch (BaseException e) {
            System.out.println("BaseException caught in main().");
        }
    }
}