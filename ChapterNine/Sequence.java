interface Selector {
    Object next();
}

public class Sequence {
    private Custom[] sequence;
    private int next = 0;
    int count = 0;

    Sequence(int size) {
        sequence = new Custom[size];
    }

    private class Custom {
        String string;

        Custom(String string) {
            this.string = string;
        }

        public String toString() {
            return string;
        }
    }

    private class SequenceSelector implements Selector {
        public Custom next() {
            if (next < sequence.length) {
                return sequence[next++]; // the inner class can access anything of the enclosing object
            }
            return null;
        }

        public void add(Custom custom) {
            if (count++ < sequence.length) {
                sequence[count - 1] = custom;
            }
        }
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(2);
        SequenceSelector sequenceSelector = sequence.new SequenceSelector();
        sequenceSelector.add(sequence.new Custom("Hello")); // the inner class relies on an object of the outer class
        sequenceSelector.add(sequence.new Custom("World"));

        Custom custom = null;
        while ((custom = sequenceSelector.next()) != null) {
            System.out.println(custom);
        }
    }
}