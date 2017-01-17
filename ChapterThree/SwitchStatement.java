import java.util.*;

public class SwitchStatement {
    public static void main(String[] args) {
        Random random = new Random(930);
        for (int i = 0; i < 10; ++i) {
            int current = random.nextInt();
            System.out.println("number is " + current);
            switch (current % 3) {
                case 0:
                    System.out.println("Remainder = 0");
//                    break;
                case 1:
                    System.out.println("Remainder = 1");
//                    break;
                case 2:
                    System.out.println("Remainder = 2");
//                    break;
                default:
                    System.out.println("Default case");
            }
        }
    }
}