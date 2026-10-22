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
}