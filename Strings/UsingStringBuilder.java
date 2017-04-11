import java.util.Random;

class WhitherStringBuilder {
    public String implicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; ++i) {
            result += fields[i];
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fields.length; ++i) {
            stringBuilder.append(fields[i]);
        }
        return stringBuilder.toString();
    }
}

public class UsingStringBuilder {
    private static Random random = new Random(47);

    public static String generateString(int size) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; ++i) {
            stringBuilder.append(random.nextInt(10));
            stringBuilder.append(", ");
        }
        int length = stringBuilder.length();
        stringBuilder.delete(length - 2, length);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        System.out.println(size + " of elements: " + generateString(size));
    }
}