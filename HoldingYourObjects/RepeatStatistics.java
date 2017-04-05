import java.util.Map;
import java.util.HashMap;
import java.util.Random;

class Statistics {
    public static void generate(Random random) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000; ++i) {
            int r = random.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : ++freq);
        }
        System.out.println(m);
    }
}

public class RepeatStatistics {
    public static void main(String[] args) {
        Random random = new Random(47);
        int rounds = Integer.parseInt(args[0]);
        for (int i = 0; i < rounds; ++i) {
            Statistics.generate(random);
        }
    }
}