import java.util.*;
import java.nio.CharBuffer;

class RandomChars implements Readable {
    Random random = new Random(256);

    public int read(CharBuffer cb) {
        for (int i = 0; i < 10; ++i) {
            cb.append((char) random.nextInt(128));
        }
        return 10;
    }
}

public class ExerciseSixteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new RandomChars());
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}