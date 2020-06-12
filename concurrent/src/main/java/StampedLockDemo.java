import java.util.concurrent.locks.StampedLock;

/**
 * @author qing
 */
public class StampedLockDemo {
    private double x, y;
    private final StampedLock s1 = new StampedLock();
    // 写锁的使用
    void move(double deltaX, double deltaY){
        // 获取写锁
        long stamp = s1.writeLock();
        System.out.println(Long.toBinaryString(stamp));
        try {
            x += deltaX;
            y += deltaY;
        }finally {
            // 释放写锁
            s1.unlockWrite(stamp);
            System.out.println(Long.toBinaryString(stamp));
        }

    }

    // 乐观锁的使用
    double distanceFromOrigin(){
        // 获取乐观读锁
        long stamp = s1.tryOptimisticRead();
        return 0;
    }

    public static void main(String[] args) {
        new StampedLockDemo().move(0.23, 0.12);
    }
}
