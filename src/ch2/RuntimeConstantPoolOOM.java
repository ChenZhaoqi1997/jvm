package ch2;

import java.util.HashSet;
import java.util.Set;
/**
 *  VM Args  : -XX:MetaspaceSize=6M -XX:MaxMetaspaceSize=6M
 *  Result 1 : Error occurred during initialization of VM
 *             MaxMetaspaceSize is too small.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
