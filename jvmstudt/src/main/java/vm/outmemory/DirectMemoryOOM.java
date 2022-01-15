package vm.outmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 模拟直接内存异常
 *
 * -XX:MaxDirectMemorySize
 * -XX:MaxDirectMemorySize=10M -Xmx20M
 */
public class DirectMemoryOOM {
    public static final int  _1MB = 1024*1024;


    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        Field[] declaredFields = Unsafe.class.getDeclaredFields();
        Field declaredField = declaredFields[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe)declaredField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB*20);

        }

    }

}
