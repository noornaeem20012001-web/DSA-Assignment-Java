public class CircularQueue {

    private final int[] queue;
    private final int capacity;
    private int front, rear, size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int data) {
        if (isFull()) throw new RuntimeException("Queue Overflow");
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Underflow");
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("Front -> ");
        for (int i = 0; i < size; i++) {
            sb.append(queue[(front + i) % capacity]).append(" ");
        }
        sb.append("<- Rear");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(4);
        for (int x = 1; x <= 4; x++) cq.enqueue(x);
        cq.display();
        System.out.println("Full: " + cq.isFull());
        System.out.println("Dequeued: " + cq.dequeue() + ", " + cq.dequeue());
        cq.enqueue(5);
        cq.enqueue(6); // wraps around
        cq.display();
    }
}
