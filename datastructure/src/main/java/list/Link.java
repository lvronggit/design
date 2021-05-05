package list;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.LinkedList;
import java.util.Stack;

public class Link {
    public Stack<Character> stack = new Stack();
    public double aDouble;
    public Link next;

    public Link(double aDouble, Link next) {
        this.aDouble = aDouble;
        this.next = next;
    }


}
