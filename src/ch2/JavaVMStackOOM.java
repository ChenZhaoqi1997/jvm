package ch2;
/**
 *  VM Args  : -Xss128k
 *  Result 1 : 操作系统假死，
 *             程序执行后一切操作无法保存，
 *             最后强行拔电源，
 *             未得到理想结果
 *  hint     : Win10 64位系统
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {}
    }
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
