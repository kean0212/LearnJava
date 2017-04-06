import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueOfDoubles {
    public static void main(String[] args) {
        Random random = new Random(212);
        PriorityQueue<Double> priorityQueue = new PriorityQueue<Double>();
        for (int i = 0; i < 10; ++i) {
            priorityQueue.offer(random.nextDouble() * 10);
        }

        Double element;
        while ((element = priorityQueue.poll()) != null) {
            System.out.println(element);
        }
    }
}