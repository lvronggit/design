package vm.outmemory;

/**
 *
 * 测试栈溢出
 *
 * -Xss128k
 */
public class JavaVMStatckSOF {

    private int stacklength = 1;

    public void stackleak(){
        stacklength++;
        System.out.println("栈深度============"+stacklength);
        stackleak();
    }

    public static void main(String[] args) {
        JavaVMStatckSOF javaVMStatckSOF = new JavaVMStatckSOF();
        javaVMStatckSOF.stackleak();
    }
}