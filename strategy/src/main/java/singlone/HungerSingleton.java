package singlone;

/**
 * 饿汉模式  直接创建
 *
 * 1 私有化构造器
 *
 * 2 自行创建，并且用静态变量保存
 *
 * 3 向外提供一个实例
 *
 * 4 强调是单例，用final修饰
 */
public class HungerSingleton {

    public static final HungerSingleton INSTANCE = new HungerSingleton();

    private HungerSingleton() {


    }
}
