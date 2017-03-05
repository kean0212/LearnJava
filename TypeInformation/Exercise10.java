public class Exercise10 {
    static boolean isArrayPrimitive (char[] chars) {
        return chars instanceof Object;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        System.out.println("Is array primitive ? " + isArrayPrimitive(chars));

//        char c = 'a';
//        c.getClass();
    }
}