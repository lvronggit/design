package shopping;

import java.util.List;

public class Count {

    private double gain;

    private double acquire;

    private double change;

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double getGain() {
        for (Order order: orders ) {
            gain =order.getTotal()+gain;
        }
        return gain;
    }



    public double getAcquire() {
        return acquire;
    }

    public void setAcquire(double acquire) {
        this.acquire = acquire;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
}
