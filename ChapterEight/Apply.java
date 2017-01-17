import java.util.*;

interface Processor {
    String name();

    Object process(Object input);
}

class SwappingProcessor implements Processor {
    public String name() {
        return "Swapping processor";
    }

    public String process(Object input) {
        String inputString = (String) input;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = inputString.length() - 1; i >= 0; --i) {
            stringBuilder.append(inputString.charAt(i));
        }
        return new String(stringBuilder);
    }
}

public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using processor: " + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        SwappingProcessor swappingProcessor = new SwappingProcessor();
        String test = "hello world";
        process(swappingProcessor, test);
    }
}
