package proxy.dynamic.cglib;

/**
 * @author qing
 */
public class TestProxy {
    public static void main(String[] args) {
        // 目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        // 代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
