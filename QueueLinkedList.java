public class QueueLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front, rear;
    private int size;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node node = new Node(data);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Underflow");
        int data = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return front.data;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("Front -> ");
        for (Node cur = front; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
        }
        sb.append(" <- Rear");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        q.display();
        System.out.println("Front: " + q.peek() + " | Size: " + q.size());
    }
}
