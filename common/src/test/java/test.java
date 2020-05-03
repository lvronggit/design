import common.util.CustomerLock;
import common.util.Shoping;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Stack;

public class test {

    public static void main(String[] args) throws NoSuchMethodException {
        Method shopIng = Shoping.class.getMethod("shopIng");
        CustomerLock annotation = shopIng.getAnnotation(CustomerLock.class);
        Stack<Number> numbers = new Stack<Number>();
        numbers.push(11);
    }

}
