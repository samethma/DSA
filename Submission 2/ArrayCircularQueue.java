
public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue - O(1)
    public void enqueue(int value) {

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    // Dequeue - O(1)
    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int value = queue[front];
        front = (front + 1) % capacity;
        size--;

        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        ArrayCircularQueue q = new ArrayCircularQueue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue());

        q.enqueue(40);

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
    }
}
