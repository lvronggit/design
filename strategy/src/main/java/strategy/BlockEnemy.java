package strategy;

public class BlockEnemy implements IStrategy{
    @Override
    public void operator() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
