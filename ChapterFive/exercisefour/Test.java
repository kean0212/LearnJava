import classtwo.ClassTwo;

public class Test {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        classOne.print();

        ClassTwo classTwo = new ClassTwo();
//        classTwo.print(); this can't be accessed
    }
}