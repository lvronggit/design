package factory.piza;

public class ChicagoPizzaStore extends PizzaStore{

    public Piza createPizza(String type) {
        Piza piza = null;
        if (type.equals("chese")) {
            System.out.println("ChicagoPizzaStore====="+type);
            piza = new Chinese();
        } else if (type.equals("greek")) {
            System.out.println("ChicagoPizzaStore====="+type);
            piza = new GreenkPizza();
        } else if (type.equals("person")) {
            System.out.println("ChicagoPizzaStore====="+type);
            piza = new PeppersonPizza();
        }
        return piza;
    }
}
