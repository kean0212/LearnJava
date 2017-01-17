class ClassOne {
    protected int marker;
}

public class ExerciseSix {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        classOne.marker = 3;
        System.out.println(classOne.marker);
    }
}