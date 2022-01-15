package factory.piza;

public class NYPizzaStore extends PizzaStore{
    @Override
    public Piza createPizza(String type) {
        Piza piza = null;
        if (type.equals("chese")) {
            System.out.println("NYPizzaStore====="+type);
            piza = new Chinese();
        } else if (type.equals("greek")) {
            System.out.println("NYPizzaStore====="+type);
            piza = new GreenkPizza();
        } else if (type.equals("person")) {
            System.out.println("NYPizzaStore====="+type);
            piza = new PeppersonPizza();
        }
        return piza;
    }
}
