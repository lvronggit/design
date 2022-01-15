package factory.piza;

public class test {
    public static void main(String[] args) {

        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPiza(Typeconstant.CHESE);

        nyPizzaStore = new ChicagoPizzaStore();
        nyPizzaStore.orderPiza(Typeconstant.CHESE);

    }
}
