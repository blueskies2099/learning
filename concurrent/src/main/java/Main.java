/**
 * @author admin
 *
 */
public class Main {
    // 线程本地变量
    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str){
        // 打印当前线程中本地内存中本地变量的值
        System.out.println(str + ": " + localVar.get());
        // 清楚本地内存中的变量
        localVar.remove();
    }

    public static void main(String[] args) {
        Runnable target;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("localVar1");
                print("thread1");
                System.out.println("after remove: " + localVar.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("localVar2");
                print("thread2");
                System.out.println("after remove: " + localVar.get());
            }
        });

        t1.start();
        t2.start();
    }
}
