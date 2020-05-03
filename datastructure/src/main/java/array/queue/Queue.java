package array.queue;

import java.util.Arrays;

//环形queue
public class Queue {

    private int maxsize;

    private long values[];

    private int front;

    private int rear;

    private int items;

    @Override
    public String toString() {
        return "Queue{" +
                "maxsize=" + maxsize +
                ", values=" + Arrays.toString(values) +
                ", front=" + front +
                ", rear=" + rear +
                ", items=" + items +
                '}';
    }

    public Queue(int size){
        maxsize = size;
        values = new long[size];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean insert(long value){
        if(front == maxsize){
            front=0;
        }
        values[front++]= value;
        items++;
        return true;
    }

    public boolean remove(){
        if(rear==maxsize){
            rear = -1;
        }
        rear++;
        items--;
        return true;
    }

    public boolean isFull(){
        return items == maxsize;
    }

    public boolean isEmpty(){
        return items == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.insert(22L);
        queue.insert(32L);
        queue.insert(42L);
        queue.insert(52L);
        queue.insert(62L);
        queue.insert(72L);
        queue.insert(82L);
        queue.insert(92L);
        queue.insert(02L);
        queue.insert(12L);
        System.out.println(queue);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println(queue);
        queue.insert(92L);
        queue.insert(02L);
        System.out.println(queue);


    }



}
