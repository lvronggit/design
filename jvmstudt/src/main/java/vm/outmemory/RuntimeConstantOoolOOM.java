package vm.outmemory;

/**
 * 测试常量池益处
 *
 * 1.8 后常量池存放在堆内存中
 *
 *  // -Xms6m -Xmx6m -XX:+HeapDumpOnOutOfMemoryError
 *
 */
public class RuntimeConstantOoolOOM {


    public static void main(String[] args) {
      /*  Set set = new HashSet();
        int i = 0;

            while (true){
                set.add(String.valueOf(i++).intern());
            }*/
        inern();
    }

    public static void inern(){
        String str1 = new StringBuilder("jisuanji").append("ruanjian").toString();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        System.out.println(str1.intern() == str1);

    }

}
