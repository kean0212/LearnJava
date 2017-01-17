public class Test {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();

//        classOne.privateInt = 3; // error
//        classOne.getPrivateInt(); // error

        classOne.publicInt = 4;
        classOne.getPublicInt();

        classOne.packageAccessInt = 5;
        classOne.getPackageAccessInt();
    }
}