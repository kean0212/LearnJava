import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListPerformance {
    private static int repeats = 1000;
    private static Random random = new Random(47);
    private static List<Test<List<String>>> tests = new ArrayList<>();
    private static List<Test<LinkedList<String>>> queueTests = new ArrayList<>();
    private static List<Test<List<String>>> sortingTests = new ArrayList<>();
    private static List<Test<StringArrayContainer>> stringArrayContainerTests = new ArrayList<>();

    static {
        // one way to instantiate an Abstract class
        tests.add(new Test<List<String>>("add") {
            // override 'test'
            int test(List<String> list, TestParam testParam) {
                int listSize = testParam.size;
                int loops = testParam.loops;
                for (int i = 0; i < loops; ++i) {
//                    list.clear();
                    for (int j = 0; j < listSize; ++j) {
                        list.add("hello");
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<String>>("get") {
            int test(List<String> list, TestParam testParam) {
                int count = testParam.loops * repeats;
                int listSize = list.size();
                for (int i = 0; i < count; i++) {
                    list.get(random.nextInt(listSize));
                }
                return count;
            }
        });
        tests.add(new Test<List<String>>("set") {
            int test(List<String> list, TestParam testParam) {
                int count = testParam.loops * repeats;
                int listSize = list.size();
                for (int i = 0; i < count; i++) {
                    list.set(random.nextInt(listSize), "hello");
                }
                return count;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            int test(List<String> list, TestParam testParam) {
                final int count = 1000000;
                int middle = list.size() / 2;
                ListIterator<String> it = list.listIterator(middle);
                for (int i = 0; i < count; i++) {
                    it.add("hello");
                }
                return count;
            }
        });
        tests.add(new Test<List<String>>("insert") {
            int test(List<String> list, TestParam testParam) {
                int count = testParam.loops;
                for (int i = 0; i < count; i++) {
                    list.add(5, "hello"); // Minimize random-access cost
                }
                return count;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            int test(List<String> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(generateStringList(listSize));
                    while (list.size() > 5) {
                        list.remove(5); // Minimize random-access cost
                    }
                }
                return loops * listSize;
            }
        });
        queueTests.add(new Test<LinkedList<String>>("addFirst") {
            int test(LinkedList<String> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; ++i) {
                    list.clear();
                    for (int j = 0; j < listSize; ++j) {
                        list.addFirst("hello");
                    }
                }
                return loops * listSize;
            }
        });
        queueTests.add(new Test<LinkedList<String>>("addLast") {
            int test(LinkedList<String> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++) {
                        list.addLast("world");
                    }
                }
                return loops * listSize;
            }
        });
        queueTests.add(
                new Test<LinkedList<String>>("removeFirst") {
                    int test(LinkedList<String> list, TestParam testParam) {
                        int loops = testParam.loops;
                        int listSize = testParam.size;
                        for (int i = 0; i < loops; i++) {
                            list.clear();
                            list.addAll(generateStringList(listSize));
                            while (list.size() > 0) {
                                list.removeFirst();
                            }
                        }
                        return loops * listSize;
                    }
                });
        queueTests.add(new Test<LinkedList<String>>("removeLast") {
            int test(LinkedList<String> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(generateStringList(listSize));
                    while (list.size() > 0) {
                        list.removeLast();
                    }
                }
                return loops * listSize;
            }
        });
        sortingTests.add(new Test<List<String>>("sort") {
            int test(List<String> list, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; ++i) {
                    list.clear();
                    list.addAll(generateStringList(listSize));
                    Collections.sort(list);
                }
                return loops;
            }
        });
        stringArrayContainerTests.add(new Test<StringArrayContainer>("add") {
            int test(StringArrayContainer container, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size;
                for (int i = 0; i < loops; ++i) {
                    for (int j = 0; j < size; ++j) {
                        container.add("hello");
                    }
                }
                return loops * size;
            }
        });
        stringArrayContainerTests.add(new Test<StringArrayContainer>("get") {
            int test(StringArrayContainer container, TestParam testParam) {
                int count = testParam.loops * repeats;
                int containerSize = container.size();
                for (int i = 0; i < count; i++) {
                    container.get(random.nextInt(containerSize));
                }
                return count;
            }
        });
    }

    private static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container, List<Test<List<String>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<String> initialize(int size) {
            container.clear();
            container.addAll(generateStringList(size));
            return container;
        }

        public static void run(List<String> list, List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    private static List<String> generateStringList(int size) {
        return Arrays.asList(Generated.array(String.class, new CountingGenerator.String(), size));
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultTestParams = TestParam.array(args);
        }
        Tester<List<String>> arrayTester = new Tester<List<String>>(null, tests.subList(1, 3)) {
            // This is an anonymous subclass.
            // It can still override the `initialize()` in Tester
            @Override
            protected List<String> initialize(int size) {
                String[] strings = Generated.array(String.class, new CountingGenerator.String(), size);
                return Arrays.asList(strings);
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
        ListTester.run(new ArrayList<String>(), tests);
        ListTester.run(new LinkedList<String>(), tests);
        ListTester.run(new Vector<String>(), tests);

        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> queueTester = new Tester<>(new LinkedList<String>(), queueTests);
        queueTester.setHeadline("Queue tests");
        queueTester.timedTest();

        ListTester.run(new ArrayList<String>(), sortingTests);
        ListTester.run(new LinkedList<String>(), sortingTests);

        ListTester.run(new StringArrayContainer(), stringArrayContainerTests);
        ListTester.run(new ArrayList<String>(), tests.subList(0, 2));
    }
}