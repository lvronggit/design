package vm.outmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+HeapDumpOnOutOfMemoryError
 *
 * 测试堆溢出
 */
public class HeapOOMTest {


    // -Xms100m -Xmx100m -XX:+UserSerialGC
    // -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        try {
          //  Thread.sleep(10000);

            fillHeap(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void fillHeap(int num) throws InterruptedException {
        List<Obj> list = new ArrayList<Obj>();

        for (int i = 0; i < num; i++) {
         //   Thread.sleep(50);
            list.add(new Obj());
        }
        System.gc();

    }

    static class Obj {
        public byte[] placeholder = new byte[64 * 1024];

    }
}
