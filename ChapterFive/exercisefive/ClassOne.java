import java.util.*;

public class ClassOne {
    private int privateInt;

    private int getPrivateInt() {
        return privateInt;
    }

    public int publicInt;

    public int getPublicInt() {
        return publicInt;
    }

    protected int protectedInt;

    protected int getProtectedInt() {
        return protectedInt;
    }

    int packageAccessInt;

    int getPackageAccessInt() {
        return packageAccessInt;
    }
}