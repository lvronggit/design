package buffer;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * buffer实验
 */
public class IntBufferDemo {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(8);

        for (int i = 0;i<intBuffer.capacity();i++){
            int j = ((i+1) << 1);
            intBuffer.put(j);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }
}
