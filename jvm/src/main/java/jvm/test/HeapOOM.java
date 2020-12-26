package jvm.test;

import java.util.ArrayList;
import java.util.List;

/**
 *-Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+HeapDumpOnOutOfMemoryError
 *
 * 测试堆溢出
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OoObject> list = new ArrayList<OoObject>();
        while (true){
            list.add(new OoObject());
        }

    }

    static class OoObject{

    }
}
