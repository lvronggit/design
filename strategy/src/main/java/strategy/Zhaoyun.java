package strategy;

public class Zhaoyun {

    // 策略模式，将相同的类型实现同一个接口，只要将接口类型给调用方，在实现的时候动态将具体实现放进去。
    public static void main(String[] args) {
        Context context;
        context = new Context(new BackDoor());
        context.operator();

        context = new Context(new BlockEnemy());
        context.operator();

        context = new Context(new GivenGreenLight());
        context.operator();



    }

}
