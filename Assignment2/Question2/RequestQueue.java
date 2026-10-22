package Assignment2.Question2;

public class RequestQueue {
    private String[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public RequestQueue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
}