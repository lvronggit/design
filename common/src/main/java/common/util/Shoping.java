package common.util;

public class Shoping {


    @CustomerLock( lockKey = "shoping222")
    public String shopIng(){
        System.out.println("执行加了注解得方法");
        return "lock";

    }

}
