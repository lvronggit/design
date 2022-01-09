package vm.outmemory;

/**
 * 测试finalize 方法
 */
public class Finalize {

    public static Finalize GCFINALIZE = null;

    /**
     * 判断是否还存活
     */
    public void isAlive(){
        System.out.println("yes i am still live");
    }


    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        GCFINALIZE   = this;
    }


    public static void main(String[] args) throws InterruptedException {

        GCFINALIZE = new Finalize();

        // 对象第一次成功拯救自己
        GCFINALIZE = null;
        System.gc();
        // 暂停等待finalize方法执行
        Thread.sleep(500);
       if(GCFINALIZE != null){
           GCFINALIZE.isAlive();
       }else{
           System.out.println("i am dead");
       }

        GCFINALIZE = null;
        System.gc();
        Thread.sleep(500);
        if(GCFINALIZE != null){
            GCFINALIZE.isAlive();
        }else{
            System.out.println("i am dead");
        }

    }


}
