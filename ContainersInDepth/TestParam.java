public class TestParam {
    public final int size;
    public final int loops;

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    public static TestParam[] array(String[] strings) {
        int size = strings.length;
        int[] ints = new int[size];
        for (int i = 0; i < size; ++i) {
            ints[i] = Integer.decode(strings[i]);
        }
        return array(ints);
    }

    public static TestParam[] array(int... values) {
        int size = values.length / 2;
        TestParam[] testParams = new TestParam[size];
        for (int i = 0, n = 0; i < size; ++i) {
            testParams[i] = new TestParam(values[n++], values[n++]);
        }
        return testParams;
    }
}