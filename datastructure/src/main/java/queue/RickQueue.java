package queue;


/**
 * 环形队列，
 * 队列已满条件  （tail+1）%n = head
 * 队列空的条件 tail = head
 */
public class RickQueue {
    private int head = 0;

    private int tail = 0;
    private int size;


    private String[] values;

    public static void main(String[] args) {
        RickQueue rickQueue = new RickQueue(10);
        int i = 0;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");
        i++;
        rickQueue.push(i + "one");

        for (int j = 0; j < rickQueue.size; j++) {
            rickQueue.pop();
        }
        rickQueue.pop();
    }

    public RickQueue(int size) {
        this.values = new String[size];
        this.size = size;
    }

    public boolean push(String value) {
        // 队列满了
        if ((tail + 1) % size == head) {
            System.out.println("队列满了");
            return false;
        }
        values[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    public String pop() {
        if (tail == head) {
            System.out.println("没有数据");
            return null;
        }
        String value = values[head];
        head = (head + 1) % size;
        return value;
    }


}
