package Assignment2.Question2;

public class TransactionStack {
    private String[] stackArray;
    private int top;
    private int capacity;

    public TransactionStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new String[capacity];
        this.top = -1;
    }

    public void push(String packetId) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow: Cannot push " + packetId);
            return;
        }
        stackArray[++top] = packetId;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}