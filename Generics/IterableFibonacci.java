import java.util.Iterator;

interface Generator<T> {
    T next();
}

class Fibonacci implements Generator<Integer> {
    private int count = 0;

    public Integer next() {
        return fib(count++);
    }

    private int fib(int index) {
        if (index < 2) {
            return 1;
        }
        return fib(index - 1) + fib(index - 2);
    }
}

public class IterableFibonacci implements Iterable<Integer> {
    private int size;
    private Fibonacci fibonacci = new Fibonacci();

    public IterableFibonacci(int size) {
        this.size = size;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return size > 0;
            }

            public Integer next() {
                size--;
                return fibonacci.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public static void main(String[] args) {
        IterableFibonacci iterableFibonacci = new IterableFibonacci(10);
        for (int number : iterableFibonacci) {
            System.out.print(number + " ");
        }
        System.out.println("");
    }
}