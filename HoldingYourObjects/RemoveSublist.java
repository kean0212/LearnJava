import java.util.*;

class Test {
    int number;

    public Test(int number) {
        this.number = number;
    }

    public boolean equals(Test test) {
        return number == test.number;
    }

    public String toString() {
        return "" + number;
    }
}


public class RemoveSublist {
    public static void main(String[] args) {
        List<Test> testList = new ArrayList<Test>(Arrays.asList(
                new Test(1), new Test(2), new Test(3),
                new Test(1), new Test(2), new Test(3),
                new Test(1), new Test(2), new Test(3)
        ));
        List<Test> subTestList = testList.subList(2, 7);
        System.out.println("sub test list: " + subTestList);
        System.out.println("Before removal: " + testList);
        testList.removeAll(subTestList);
        System.out.println("After removal: " + testList);
    }
}