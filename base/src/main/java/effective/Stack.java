package effective;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 过期引用的清除,不清楚会导致程序效率降低,堆栈溢出
 */
public class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFALUT_INIT_CAPITY = 16;


    public Stack(){
        elements = new Object[DEFALUT_INIT_CAPITY];
    }

    public Object pop(){
        // 没有数据抛出异常
        if(size == 0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        // 取出数据之后,引用还在,会导致堆栈溢出
        // 所以在这里将没用的过期引用清除
        elements[size] = null;
        return result;
    }

    public void push(Object ele){
        ensureCapacity();
        elements[size++] = ele;
    }


    public void ensureCapacity(){
        if(size == elements.length){
            // 扩容
            elements = Arrays.copyOf(elements, size*2+1);

        }

    }



}
