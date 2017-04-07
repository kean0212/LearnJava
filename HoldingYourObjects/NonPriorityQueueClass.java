import java.util.PriorityQueue;

class NonPriorityQueue {}

public class NonPriorityQueueClass {
    public static void main(String[] args) {
        PriorityQueue<NonPriorityQueue> priorityQueue = new PriorityQueue<NonPriorityQueue>();
        priorityQueue.offer(new NonPriorityQueue());
        priorityQueue.offer(new NonPriorityQueue());
        priorityQueue.offer(new NonPriorityQueue());
    }
}