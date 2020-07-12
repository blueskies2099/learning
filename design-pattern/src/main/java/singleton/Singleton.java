package singleton;

/**
 * @author qing
 */
public class Singleton {
    /**
     * 创建对象 非原子操作（三步） volatile 防止重排序
     */
    private static volatile Singleton singleton;
    private Singleton(){

    }
    public static Singleton getInstance(){
        // 减少不必要的同步 优化性能
        if (singleton == null){
            // 同步代码块
            synchronized (Singleton.class){
                // 锁优化 可能等待的线程也会进入
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
