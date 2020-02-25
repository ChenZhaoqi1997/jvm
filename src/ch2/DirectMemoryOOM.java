package ch2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *  VM Args  : -XX:MaxDirectMemorySize=10M
 *  Result 1 : Exception in thread "main" java.lang.OutOfMemoryError
 * 	               at sun.misc.Unsafe.allocateMemory(Native Method)
 * 	               at ch2.DirectMemoryOOM.main(DirectMemoryOOM.java:20)
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);//here
        }
    }
}
