package singlone;

/**
 * 懒汉式 延迟创建这个对象
 * <p>
 * 1 构造器私有化
 * <p>
 * 2 静态变量保存
 * <p>
 * 3 提供静态变量获取这个实例
 */
public class FullSingleton {

    private volatile static  FullSingleton instance;

    private FullSingleton() {
    }

    public static FullSingleton getInstance() {

        if (instance == null) {
            synchronized (FullSingleton.class) {
            }
            if (instance == null) {
                instance = new FullSingleton();

            }
        }
        return instance;
    }


}
