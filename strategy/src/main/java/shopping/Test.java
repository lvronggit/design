package shopping;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Order order = new Order();
        order.setNumber(1);
        order.setPrice(2.5);

        Order order1 = new Order();
        order1.setNumber(12);
        order1.setPrice(29.8);

        Count count = new Count();
        List<Order> list = new LinkedList<Order>() ;
        list.add(order);
        list.add(order1);

        count.setOrders(list);

        Activity activity = new DisCount(1);
        double finalprice = activity.getFinalprice(count.getGain());
        System.out.println(finalprice);
    }

}
