package shopping;

public class Order {

    private int number;

    private double price;

    private double discount;

    public Order() {
        this.discount =1;
    }

    public Order(int number, Double price) {
      this(number, price, 1);
    }

    public Order(int number, double price, double discount) {
        this.number = number;
        this.price = price;
        this.discount = discount;
    }

    public double getTotal(){
        return number*price*discount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
