package queue;


/**
 * 数组队列
 * <p>
 * 需要实现的操作，提供入队，出队
 * <p>
 * 保证先进先出
 */
public class ArrayQueue<T> {
    private Object[] values;
    int head = 0;
    int tail = 0;

    public ArrayQueue(int initsize) {
        this.values = new Object[initsize];
    }

    public T pop() {
        if (head == tail) {
            throw new RuntimeException("没有数据");
        }
        Object value = values[head];
        head++;
        return (T) value;
    }

    public boolean push(T t) {
        //
        if(tail ==  values.length){
            // 数据还没放满了。调整位置
            if(tail-head<(values.length)){
               int tm = head;
               int n = tail-head;
                for (int i = 0; i < n; i++) {
                    values[i] = values[tm];
                    tm++;
                }

                head = 0;
                tail = n;
            }else{
                return false;
            }
        }
        values[tail] = t;
        tail++;
        return true;
    }

    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue(10);

        arrayQueue.push("1");
        arrayQueue.push("2");
        arrayQueue.push("3");
        arrayQueue.push("4");
        arrayQueue.push("5");
        arrayQueue.push("6");
        arrayQueue.push("7");
        arrayQueue.push("8");
        arrayQueue.push("9");
        arrayQueue.push("10");

        System.out.println(arrayQueue.push("11"));

        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.push("11"));

        System.out.println(arrayQueue.push("12"));

        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());

        System.out.println(arrayQueue.push("13"));
        System.out.println(arrayQueue.push("14"));

        for (int i = 0; i < 10; i++) {
            System.out.println(arrayQueue.pop());
        }


    }


}
