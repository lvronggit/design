package singlone;

/**
 * 懒汉式 延迟创建这个对象
 * 内部类加载,线程安全
 */
public class FullSingletonNew {


    private FullSingletonNew() {
    }


    private static class Inner{
         private  static final FullSingletonNew instance = new FullSingletonNew();
    }


    public static FullSingletonNew getInstance() {

        return Inner.instance;
    }


}
