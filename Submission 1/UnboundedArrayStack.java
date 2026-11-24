
public class UnboundedArrayStack {

    private int[] array;
    private int size;

    public UnboundedArrayStack() {
        array = new int[2];
        size = 0;
    }

    // Push operation
    public void push(int value) {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];

            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }

        array[size] = value;
        size++;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        size--;
        return array[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return array[size - 1];
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack =
                new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Top: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Size: " + stack.size);
    }
}

