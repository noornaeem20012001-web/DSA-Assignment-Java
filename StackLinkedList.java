public class StackLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("Top -> ");
        for (Node cur = top; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
        System.out.println("Peek: " + s.peek());
        System.out.println("Popped: " + s.pop());
        s.display();
        System.out.println("Size: " + s.size());
    }
}
