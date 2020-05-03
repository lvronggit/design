package strategy;

public class Context {
    private IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void operator(){
        iStrategy.operator();
    }
}
