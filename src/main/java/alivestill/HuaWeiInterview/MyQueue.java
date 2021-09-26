package alivestill.HuaWeiInterview;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue <T>{

    // in use
    private Deque<T> stack1 = new ArrayDeque<>();
    // auxiliary
    private Deque<T> stack2 = new ArrayDeque<>();

    public synchronized void enque(T item) {
        stack1.addLast(item);
    }

    public synchronized T deque() {
        if (stack1.isEmpty()) {
            return null;    // exception
        }
        while (!stack1.isEmpty()) {
            stack2.addLast(stack1.removeLast());
        }
        T item = stack2.removeLast();
        while (!stack2.isEmpty()) {
            stack1.addLast(stack2.removeLast());
        }
        return item;
    }

    @Test
    public void test() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
    }
}
