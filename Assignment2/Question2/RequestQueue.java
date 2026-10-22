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

    public void enqueue(String packetId) {
        if (size == capacity) {
            System.out.println("Queue Full: Cannot enqueue " + packetId);
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = packetId;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return null;
        }
        String item = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}