package ch2;

/**
 *  VM Args  : -Xss128k
 *  Result 1 : stack length:1580
 *  Result 2 : stack length:986
 *  Result 3 : stack length:986
 *  Result 4 : stack length:980
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
