import java.util.PriorityQueue;

// Generic class implementing a priority queue
class GenericPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> queue;

    public GenericPriorityQueue() {
        queue = new PriorityQueue<>();
    }

    public void add(T element) {
        queue.add(element);
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.poll();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Main class
public class week_8_post_lab {
    public static void main(String[] args) {
        // Test with Integer
        GenericPriorityQueue<Integer> intQueue = new GenericPriorityQueue<>();
        intQueue.add(5);
        intQueue.add(1);
        intQueue.add(3);
        System.out.println("Integer Queue Peek: " + intQueue.peek());
        System.out.println("Integer Queue Remove: " + intQueue.remove());
        System.out.println("Integer Queue Empty: " + intQueue.isEmpty());

        // Test with Double
        GenericPriorityQueue<Double> doubleQueue = new GenericPriorityQueue<>();
        doubleQueue.add(2.5);
        doubleQueue.add(1.1);
        doubleQueue.add(3.3);
        System.out.println("Double Queue Peek: " + doubleQueue.peek());
        System.out.println("Double Queue Remove: " + doubleQueue.remove());
        System.out.println("Double Queue Empty: " + doubleQueue.isEmpty());

        // Test with String
        GenericPriorityQueue<String> stringQueue = new GenericPriorityQueue<>();
        stringQueue.add("banana");
        stringQueue.add("apple");
        stringQueue.add("cherry");
        System.out.println("String Queue Peek: " + stringQueue.peek());
        System.out.println("String Queue Remove: " + stringQueue.remove());
        System.out.println("String Queue Empty: " + stringQueue.isEmpty());
    }
}
