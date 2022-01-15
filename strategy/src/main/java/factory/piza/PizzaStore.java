package factory.piza;

/**
 * 披萨店
 */
public abstract class PizzaStore {

    public Piza orderPiza(String type) {
        Piza piza = createPizza(type);
        piza.prepare();
        piza.bake();
        piza.box();
        piza.cut();
        return piza;
    }

    public abstract Piza createPizza(String type);
}
