package scheduled;

import java.util.PriorityQueue;

/**
 * 优先级队列观察
 */
public class ProtrtyQueue {

    public static void main(String[] args) {
        PriorityQueue<String> objects = new PriorityQueue<>();

        objects.offer("a");
        objects.offer("cc");
        objects.offer("b");
        objects.offer("aa");
        objects.offer("d");
        objects.offer("vv");


        objects.poll()
    }
}
