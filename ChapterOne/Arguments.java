import java.util.*;

public class Arguments {
    /**
     * args starts from the real inputs
     * @param args a list of strings
     */
    public static void main(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            System.out.println(args[i]);
        }
    }
}