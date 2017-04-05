import java.util.Queue;
import java.util.LinkedList;

class Command {
    private String command;

    public Command(String command) {
        this.command = command;
    }

    public void operation() {
        System.out.println(command);
    }
}

class FillQueue {
    public static Queue<Command> fillQueue(Queue<Command> initialQueue) {
        for (int i = 0; i < 10; ++i) {
            initialQueue.offer(new Command("" + i));
        }
        return initialQueue;
    }
}

public class QueueOperation {
    static void runCommandQueue(Queue<Command> commandQueue) {
        for (Command command : commandQueue) {
            command.operation();
        }
    }

    public static void main(String[] args) {
        Queue<Command> commandQueue = FillQueue.fillQueue(new LinkedList<Command>());
        runCommandQueue(commandQueue);
    }
}
