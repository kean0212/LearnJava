import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformance {
    private static int repeats = 1000;
    private static Random random = new Random(47);
    private static List<Test<List<Integer>>> tests = new ArrayList<>();
    private static List<Test<LinkedList<Integer>>> queueTests = new ArrayList<>();

    static {
        // one way to instantiate an Abstract class
        tests.add(new Test<List<Integer>>("add") {
            // override 'test'
            int test(List<Integer> list, TestParam testParam) {
                int listSize = testParam.size;
                int loops = testParam.loops;
                for (int i = 0; i < loops; ++i) {
                    list.clear();
                    for (int j = 0; j < listSize; ++j) {
                        list.add(j);
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            int test(List<Integer> list, TestParam testParam) {
                int count = testParam.loops * repeats;
                int listSize = list.size();
                for (int i = 0; i < count; i++) {
                    list.get(random.nextInt(listSize));
                }
                return count;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            int test(List<Integer> list, TestParam testParam) {
                int count = testParam.loops * repeats;
                int listSize = list.size();
                for (int i = 0; i < count; i++) {
                    list.set(random.nextInt(listSize), 47);
                }
                return count;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            int test(List<Integer> list, TestParam testParam) {
                final int count = 1000000;
                int middle = list.size() / 2;
                ListIterator<Integer> it = list.listIterator(middle);
                for (int i = 0; i < count; i++) {
                    it.add(47);
                }
                return count;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            int test(List<Integer> list, TestParam testParam) {
                int count = testParam.loops;
                for (int i = 0; i < count; i++) {
                    list.add(5, 47); // Minimize random-access cost
                }
                return count;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            int test(List<Integer> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(listSize));
                    while (list.size() > 5) {
                        list.remove(5); // Minimize random-access cost
                    }
                }
                return loops * listSize;
            }
        });
        queueTests.add(new Test<LinkedList<Integer>>("addFirst") {
            int test(LinkedList<Integer> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; ++i) {
                    list.clear();
                    for (int j = 0; j < listSize; ++j) {
                        list.addFirst(47);
                    }
                }
                return loops * listSize;
            }
        });
        queueTests.add(new Test<LinkedList<Integer>>("addLast") {
            int test(LinkedList<Integer> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++) {
                        list.addLast(47);
                    }
                }
                return loops * listSize;
            }
        });
        queueTests.add(
                new Test<LinkedList<Integer>>("removeFirst") {
                    int test(LinkedList<Integer> list, TestParam testParam) {
                        int loops = testParam.loops;
                        int listSize = testParam.size;
                        for (int i = 0; i < loops; i++) {
                            list.clear();
                            list.addAll(new CountingIntegerList(listSize));
                            while (list.size() > 0) {
                                list.removeFirst();
                            }
                        }
                        return loops * listSize;
                    }
                });
        queueTests.add(new Test<LinkedList<Integer>>("removeLast") {
            int test(LinkedList<Integer> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(listSize));
                    while (list.size() > 0) {
                        list.removeLast();
                    }
                }
                return loops * listSize;
            }
        });
    }

    private static class ListTester extends Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }

        public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultTestParams = TestParam.array(args);
        }
        Tester<List<Integer>> arrayTester = new Tester<List<Integer>>(null, tests.subList(1, 3)) {
            // This is an anonymous subclass.
            // It can still override the `initialize()` in Tester
            @Override
            protected List<Integer> initialize(int size) {
                Integer[] integers = Generated.array(Integer.class, new CountingGenerator.Integer(), size);
                return Arrays.asList(integers);
            }
        };
        arrayTester.setHeadline("Array as List");
        arrayTester.timedTest();

        Tester.defaultTestParams = TestParam.array(
                10, 5000, 100, 5000, 1000, 1000, 10000, 200
        );
        if (args.length > 0) {
            Tester.defaultTestParams = TestParam.array(args);
        }
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
        ListTester.run(new Vector<Integer>(), tests);

        Tester.fieldWidth = 12;
        Tester<LinkedList<Integer>> queueTester = new Tester<>(new LinkedList<Integer>(), queueTests);
        queueTester.setHeadline("Queue tests");
        queueTester.timedTest();
    }
}