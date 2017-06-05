import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.IdentityHashMap;
import java.util.WeakHashMap;
import java.util.Hashtable;

public class MapPerformance {
    static List<Test<Map<Integer, Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            int test(Map<Integer, Integer> map, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size;
                for (int i = 0; i < loops; ++i) {
                    map.clear();
                    for (int j = 0; j < size; ++j) {
                        map.put(j, j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            int test(Map<Integer, Integer> map, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size * 2;
                for (int i = 0; i < loops; ++i) {
                    for (int j = 0; j < size; ++j) {
                        map.get(j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            int test(Map<Integer, Integer> map, TestParam testParam) {
                int loops = testParam.loops * 10;
                for (int i = 0; i < loops; ++i) {
                    Iterator iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultTestParams = TestParam.array(args);
        }
        Tester.run(new HashMap<Integer, Integer>(), tests);
        Tester.run(new TreeMap<Integer, Integer>(), tests);
        Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
        Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
        Tester.run(new WeakHashMap<Integer, Integer>(), tests);
        Tester.run(new Hashtable<Integer, Integer>(), tests);
        Tester.run(new SlowMap36<Integer, Integer>(), tests);
    }
}