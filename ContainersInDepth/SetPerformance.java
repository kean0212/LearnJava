import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class SetPerformance {
    static List<Test<Set<String>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Set<String>>("add") {
            int test(Set<String> set, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size;
                for (int i = 0; i < loops; ++i) {
                    set.clear();
                    for (int j = 0; j < size; ++j) {
                        set.add("hello");
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            int test(Set<String> set, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size * 2;
                for (int i = 0; i < loops; ++i) {
                    for (int j = 0; j < size; ++j) {
                        set.contains("hello");
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            int test(Set<String> set, TestParam testParam) {
                int loops = testParam.loops * 10;
                for (int i = 0; i < loops; ++i) {
                    Iterator<String> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultTestParams = TestParam.array(args);
        }
        Tester.fieldWidth = 10;
        Tester.run(new HashSet<String>(), tests);
        Tester.run(new TreeSet<String>(), tests);
        Tester.run(new LinkedHashSet<String>(), tests);
    }
}