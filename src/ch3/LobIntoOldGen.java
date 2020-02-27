package ch3;
/**
 *  VM Args  : -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 *             -XX:SurvivorRatio=8
 *             -XX:PretenureSizeThreshold=1048576
 *  Result 1 : Heap
 *  def new generation   total 9216K, used 2150K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 *   eden space 8192K,  26% used [0x00000000fec00000, 0x00000000fee19a90, 0x00000000ff400000)
 *   from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 *   to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 *  tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 *    the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
 *  Metaspace       used 3201K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 345K, capacity 388K, committed 512K, reserved 1048576K
 */
public class LobIntoOldGen {
    private static final int _1MB = 1024 * 1024;
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
    public static void main(String[] args) {
        LobIntoOldGen.testPretenureSizeThreshold();
    }
}
