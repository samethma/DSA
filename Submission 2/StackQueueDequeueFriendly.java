
import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue - O(n)
    public void enqueue(int value) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(value);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue - O(1)
    public int dequeue() {

        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return s1.pop();
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue =
                new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}

