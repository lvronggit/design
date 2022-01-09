package stack;

import java.util.Stack;

/**
 * 栈实现队列
 */
public class StackToQueue {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();



    public Integer pop(){
        if(input.isEmpty()){
            turn(input,output);
        }

        return output.pop();
    }

    public Integer push(Integer item){
       return  input.push(item);
    }

    public void turn(Stack<Integer> input,Stack<Integer> output){
        int size = input.size();
        for(int i = 0;i<size;i++){
            output.push(input.pop());
        }
    }

    public static void main(String[] args) {





    }


}
