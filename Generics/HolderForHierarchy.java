class Base {
    public String toString() {
        return "Base";
    }
}

class Derived extends Base {
    public String toString() {
        return "Derived";
    }
}

public class HolderForHierarchy<T> {
    private T a;

    public HolderForHierarchy(T a) {
        this.a = a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public static void main(String[] args) {
        HolderForHierarchy<Base> holderForHierarchy = new HolderForHierarchy<Base>(new Derived());
        Base derived = holderForHierarchy.getA();
        System.out.println(derived);
    }
}
