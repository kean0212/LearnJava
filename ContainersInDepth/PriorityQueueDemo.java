import java.util.PriorityQueue;
import java.util.Random;

class Element implements Comparable<Element> {
    private static Random random = new Random(31);
    private int priority = random.nextInt(100);

    public int compareTo(Element another) {
        return priority > another.priority ? 1 : (priority == another.priority ? 0 : -1);
    }

    public String toString() {
        return "Element " + priority;
    }
}

public class PriorityQueueDemo extends PriorityQueue<Element> {
    public static void main(String[] args) {
        PriorityQueueDemo priorityQueueDemo = new PriorityQueueDemo();
        int count = 10;
        for (int i = 0; i < count; ++i) {
            priorityQueueDemo.offer(new Element());
        }

        StringBuffer stringBuffer = new StringBuffer("Initial priority queue: ");
        Element element;
        while ((element = priorityQueueDemo.poll()) != null) {
            stringBuffer.append(element + ", ");
        }
        int length = stringBuffer.length();
        stringBuffer.delete(length - 2, length);
        Util.print(stringBuffer.toString());
    }
}