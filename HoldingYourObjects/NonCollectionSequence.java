import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class IntegerSequence {
    protected Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
}

public class NonCollectionSequence extends IntegerSequence implements Iterable<Integer> {

    public Iterable<Integer> reversed() {
        return new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private int index = integers.length - 1;

                    public boolean hasNext() {
                        return index > -1;
                    }

                    public Integer next() {
                        return integers[index--];
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Integer> randomized() {
        return new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                List<Integer> shuffled = new ArrayList<Integer>(Arrays.asList(integers));
                Collections.shuffle(shuffled);
                return shuffled.iterator();
            }
        };
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            public boolean hasNext() {
                return index < integers.length;
            }

            public Integer next() {
                return integers[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nonCollectionSequence = new NonCollectionSequence();

        System.out.print("Incrementing: ");
        for (Integer number : nonCollectionSequence) {
            System.out.print(number + " ");
        }
        System.out.println("");

        System.out.print("Decrementing: ");
        for (Integer number : nonCollectionSequence.reversed()) {
            System.out.print(number + " ");
        }
        System.out.println("");

        System.out.print("Randomized: ");
        for (Integer number : nonCollectionSequence.randomized()) {
            System.out.print(number + " ");
        }
        System.out.println("");
    }

}