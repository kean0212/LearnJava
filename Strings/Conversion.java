import java.util.Formatter;
import java.math.BigInteger;

public class Conversion {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);

        char c = 'a';
        System.out.println("c = 'a'");
        formatter.format("s:%s c:%c b:%b h:%h\n", c, c, c, c);

        int i = 121;
        System.out.println("i = 121");
        formatter.format("d:%d c:%c b:%b s:%s x:%x h:%h\n", i, i, i, i, i, i);

        BigInteger bigInteger = new BigInteger("5000000000000000000");
        System.out.println("bigInteger = new BigInteger(\"5000000000000000000\")");
        formatter.format("d:%d b:%b s:%s x:%x h:%h\n", bigInteger, bigInteger, bigInteger, bigInteger, bigInteger);

        double d = 179.543;
        System.out.println("d = 179.453");
        formatter.format("b:%b s:%s f:%f e:%e h:%h\n", d, d, d, d, d);

        boolean b = true;
        System.out.println("b = true");
        formatter.format("b:%b s:%s h:%h\n", b, b, b);

        Conversion conversion = new Conversion();
        System.out.println("conversion = new Conversion()");
        formatter.format("b%b s%s h:%h\n", conversion, conversion, conversion);
    }
}