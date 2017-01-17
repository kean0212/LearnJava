import java.util.*;

interface Interface {
    int FIRST = 0;
    int SECOND = 0;
}

public class ExerciseSeventeen {
    public static void main(String[] args) {
        int first = Interface.FIRST;
        System.out.println(first);

        first = 1;
        System.out.println(first);
//        Interface.FIRST = 3;
    }
}