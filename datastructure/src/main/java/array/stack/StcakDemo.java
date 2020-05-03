package array.stack;
// 先进后出
public class StcakDemo {
    // 栈元素当前位置
    int index;
    long[] values;
    int size;

    public StcakDemo() {
        index = -1;
        values = new long[10];
        size=10;
    }

    public StcakDemo(int sizes){
        index = -1;
        values = new long[sizes];
        size = sizes;
    }

    public boolean push(long value){
        if(index >= size){
            return false;
        }
        values[++index] =value;
        return true;
    }


    public long pop(){
        if(index<0){
            throw new NullPointerException("没有数据");
        }
        long value = values[index--];
        return value;
    }

    public long peek(){
        return values[index];
    }

    public boolean isempty(){
        return index <= -1;
    }

    public boolean isfull(){
        return index>=size;
    }


    public static void main(String[] args) {
        StcakDemo stcakDemo = new StcakDemo(5);
        stcakDemo.push(1L);
        stcakDemo.push(2L);
        stcakDemo.push(3L);
        stcakDemo.push(4L);
        System.out.println(stcakDemo.pop());
        System.out.println(stcakDemo.pop());
        System.out.println(stcakDemo.pop());
        System.out.println(stcakDemo.pop());
        System.out.println(stcakDemo.pop());
    }
}
