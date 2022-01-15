package factory.piza;

public class SimplePizzaFactory {

    public Piza createPizza(String type) {
        Piza piza = null;
        if (type.equals("chese")) {
            piza = new Chinese();
        } else if (type.equals("greek")) {
            piza = new GreenkPizza();
        } else if (type.equals("person")) {
            piza = new PeppersonPizza();
        }
        return piza;
    }
}
