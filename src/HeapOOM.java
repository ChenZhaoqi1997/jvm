import java.util.ArrayList;
import java.util.List;
/**
 *  VM Args  : -Xms20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 *  Result 1 : java.lang.OutOfMemoryError: Java heap space
 *             Dumping heap to java_pid5956.hprof ...
 *             Heap dump file created [2314483815 bytes in 17.172 secs]
 *  Result 2 : java.lang.OutOfMemoryError: Java heap space
 *             Dumping heap to java_pid1244.hprof ...
 *             Heap dump file created [2314483815 bytes in 17.849 secs]
 */
public class HeapOOM {
    static class OOMObject {}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
