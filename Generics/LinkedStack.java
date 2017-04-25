@SuppressWarnings("unchecked")
public class LinkedStack<T> {
    private class Node {
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T item = top.item;
        if (top.next != null) {
            top = top.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        for (String phrase: "Phrasers on stun!".split(" ")) {
            stack.push(phrase);
        }
        String phrase;
        while ((phrase = stack.pop()) != null) {
            System.out.println(phrase);
        }
    }
}