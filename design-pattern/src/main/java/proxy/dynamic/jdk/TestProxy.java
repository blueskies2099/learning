package proxy.dynamic.jdk;

/**
 * 测试类
 * @author qing
 */
public class TestProxy {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        // 输出目标对象信息
        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // 输出代理对象信息
        System.out.println(proxy.getClass());
        // 执行代理方法
        proxy.save();
    }
}
