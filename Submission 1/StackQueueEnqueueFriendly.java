
import java.util.Stack;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue - O(1)
    public void enqueue(int value) {
        s1.push(value);
    }

    // Dequeue - O(n)
    public int dequeue() {

        if (s1.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int value = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return value;
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
                new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}

