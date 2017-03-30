import java.util.LinkedList;

class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
}

public class EvaluateExpressions {
    static String evaluate(String input) {
        Stack<Character> storage = new Stack<Character>();
        char[] charArray = input.toCharArray();
        for (char character : charArray) {
            if (character == '+') {
                continue;
            }
            if (character == '-') {
                storage.pop();
                continue;
            }
            storage.push(character);
        }
        return storage.toString();
    }

    public static void main(String[] args) {
        System.out.println(evaluate(args[0]));
    }
}

