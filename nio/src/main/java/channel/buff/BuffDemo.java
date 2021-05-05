package channel.buff;

import java.nio.ByteBuffer;

public class BuffDemo {
    /**
     * ByteBuffer
     * CharBuffer
     * DoubleBuffer
     * FloatBuffer
     * IntBuffer
     * LongBuffer
     * ShortBuffer
     */
    public static void main(String[] args) {

        ByteBuffer.allocateDirect(100);
        ByteBuffer bf = ByteBuffer.allocate(20);
        bf.put((byte) 1);
        bf.put((byte) 11);
        bf.put((byte) 111);
        bf.put((byte) 34);
        bf.put((byte) 56);
        bf.put((byte) 123);
        bf.put((byte) 11);
        bf.put((byte) 33);
        bf.put((byte) 2);
        bf.put((byte) 1);
        System.out.println(bf);
        bf.flip();
        System.out.println(bf);
        System.out.println(bf.get());
        System.out.println(bf.get());
        System.out.println(bf.position());


    }
}
