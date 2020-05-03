package array.queue;

import java.util.Arrays;

// 优先级队列
public class PriorityQueue {

    private long[] values;

    private int font;

    private int size;

    public boolean insert(long v){
        if(font==0){
            values[font] = v;
            font++;
           return true;
        }
        if(font == size){
            return false;
        }

        int start ;
        for (start = font; start>0 ; start--) {
            if(v >values[start-1]){
                values[start] = values[start-1];

            }else{
                break;
            }
        }
        values[start] = v;
        font++;
        return true;
    }

    public long remove(){
        return values[--font];
    }





    public PriorityQueue(int size) {
        this.size = size;
        this.font = 0;
        this.values = new long[size];
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "values=" + Arrays.toString(values) +
                ", font=" + font +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.insert(1L);
        priorityQueue.remove();
        priorityQueue.insert(122L);
        priorityQueue.insert(11L);
        priorityQueue.remove();
        priorityQueue.insert(10L);
        priorityQueue.insert(1000L);
        priorityQueue.insert(100L);
        priorityQueue.insert(30L);
        priorityQueue.insert(3000L);
        priorityQueue.insert(300L);
        priorityQueue.insert(20L);
        priorityQueue.insert(2000L);
        priorityQueue.insert(200L);
        System.out.println(priorityQueue);
    }
}
