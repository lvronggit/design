package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumberMatch {





    public static void main(String[] args) {

        System.out.println(match());;

    }
    public static boolean match(){
        String s = "[()]()()()()[][][]";
        Map<Character,Character> maps = new HashMap<Character, Character>();

        maps.put(']','[');
        maps.put(')','(');
        maps.put('}','{');
        Stack<Character> stack = new Stack();

        for(int i=0;i<s.length();i++){
            Character sch = s.charAt(i);
            if('('==sch || '['==sch || '{'==sch ){
                stack.push(sch);
                continue;
            }
            Character character = maps.get(sch);
            if(character == null){
                return false;
            }else{
                Character ch =  stack.pop();
                if(stack.isEmpty() || character != ch){
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }
}
