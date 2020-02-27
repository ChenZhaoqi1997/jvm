package ch3;
/**
 * -XX:+PrintGC与
 * -verbose:gc 这两个命令效果都是一样，打印最基本的回收信息
 * -XX:+PrintGCDetails 可以打印详细GC信息至控制台
 * -XX:+PrintGCDateStamps 可以记录GC发生的详细时间
 * -Xloggc:{log.dir} 可以把GC输出至文件，这对长时间服务器GC监控
 * -XX:+PrintHeapAtGC 开关了解堆的更全面的信息
 * -XX:+PrintGCApplicationConcurrentTime 输出应用程序的执行时间
 * -XX:+PrintGCApplicationStoppedTime 输出GC造成应用暂停的时间
 * -XX:+PrintReferenceGC 用来跟踪系统内的软引用，弱引用，虚引用，显示引用过程。弱引用，软引用及虚引用对GC的影响
 * -verbose:class 跟踪类的加载和卸载，亦可单独配置
 * -XX:+TraceClassLoading跟踪类的加载或单独配置
 * -XX:+TraceClassUnloading
 * -XX:+PrintVMOptions 打印出JVM接受到的显式（主动配置的）命令行参数
 * -XX:+PrintCommandLineFlags 打印出显式（主动配置）和隐式（JVM自行设置）的一些参数，其中显式即等同于
 * -XX:+PrintVMOptions参数设置
 * -XX:+PrintClassHistogram 打印出Java各类实例的数量以及空间大小
 *
 * VM Args  : -XX:+PrintGC
 * Result   : [GC (System.gc())  6758K->752K(125952K), 0.0013110 secs]
 *            [Full GC (System.gc())  752K->635K(125952K), 0.0041738 secs]
 *
 * VM Args  : -XX:+PrintGCDetails
 * Result   : [GC (System.gc()) [PSYoungGen: 6758K->808K(38400K)] 6758K->816K(125952K), 0.0449560 secs]
 *            [Times: user=0.00 sys=0.02, real=0.04 secs]
 *            [Full GC (System.gc()) [PSYoungGen: 808K->0K(38400K)]
 *                                   [ParOldGen: 8K->635K(87552K)] 816K->635K(125952K),
 *                                   [Metaspace: 2948K->2948K(1056768K)], 0.0047678 secs]
 *            [Times: user=0.00 sys=0.00, real=0.00 secs]
 *            Heap
 *             PSYoungGen      total 38400K, used 998K [0x00000000d5f00000, 0x00000000d8980000, 0x0000000100000000)
 *              eden space 33280K, 3% used [0x00000000d5f00000,0x00000000d5ff9b20,0x00000000d7f80000)
 *              from space 5120K, 0% used [0x00000000d7f80000,0x00000000d7f80000,0x00000000d8480000)
 *              to   space 5120K, 0% used [0x00000000d8480000,0x00000000d8480000,0x00000000d8980000)
 *             ParOldGen       total 87552K, used 635K [0x0000000081c00000, 0x0000000087180000, 0x00000000d5f00000)
 *              object space 87552K, 0% used [0x0000000081c00000,0x0000000081c9ecf8,0x0000000087180000)
 *             Metaspace       used 2971K, capacity 4496K, committed 4864K, reserved 1056768K
 *              class space    used 322K, capacity 388K, committed 512K, reserved 1048576K
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
    public static void main(String[] args) {
        ReferenceCountingGC.testGC();
    }
}
