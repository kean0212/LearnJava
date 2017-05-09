public class SinglyLinkedList<T> {

    private class Node<A> {
        private A data;
        private Node next;

        public Node(A data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public class SinglyListIterator<E> {
        Node<E> current;

        public SinglyListIterator(Node current) {
            this.current = current;
        }

        public boolean hasNext() {
            return current.next != null;
        }

        public E next() {
            E result = (E) current.next.data;
            current = current.next;
            return result;
        }

        public void add(E element) {
            current.next = new Node(element, current.next);
            current = current.next;
        }

        public void remove() {
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = new Node(null, null);
    }

    public SinglyListIterator iterator() {
        return new SinglyListIterator<T>(head);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(super.toString() + ": [");
        SinglyListIterator<T> singlyListIterator = iterator();
        while (singlyListIterator.hasNext()) {
            stringBuffer.append(singlyListIterator.next() + ", ");
        }
        stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}