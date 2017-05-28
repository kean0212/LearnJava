import java.util.List;

public class Tester<C> {
    public static TestParam[] defaultTestParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 5000
    );
    public static int fieldWidth = 13;
    private static String testField = "%" + fieldWidth + "s";
    private static String numberField = "%" + fieldWidth + "d";
    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";

    private String headline = "";
    protected C container;
    private List<Test<C>> tests;
    private TestParam[] testParams = defaultTestParams;

    protected C initialize(int size) {
        return container;
    }

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null) {
            headline = container.getClass().getSimpleName();
        }
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] testParams) {
        this(container, tests);
        this.testParams = testParams;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public static <C> void run(C container, List<Test<C>> tests) {
        new Tester(container, tests).timedTest();
    }

    public static <C> void run(C container, List<Test<C>> tests, TestParam[] testParams) {
        new Tester(container, tests, testParams).timedTest();
    }

    public void timedTest() {
        displayHeader();
        for (TestParam testParam : testParams) {
            System.out.format(sizeField, testParam.size);
            for (Test<C> test : tests) {
                C container = initialize(testParam.size);
                long startTime = System.nanoTime();
                int repeats = test.test(container, testParam);
                long testDuration = System.nanoTime() - startTime;
                long timePerRepeat = testDuration / repeats;
                System.out.format(numberField, timePerRepeat);
            }
            Util.println("");
        }
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(width);
        for (int i = 0; i < width / 2; ++i) {
            stringBuilder.append("-");
        }
        stringBuilder.append(" " + headline + " ");
        for (int i = 0; i < width / 2; ++i) {
            stringBuilder.append("-");
        }
        Util.println(stringBuilder);
        System.out.format(sizeField, "size");
        for (Test test : tests) {
            System.out.format(testField, test.name);
        }
        Util.println("");
    }
}