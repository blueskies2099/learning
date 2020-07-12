package proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 生成代理对象
 * @author qing
 */
public class ProxyFactory implements MethodInterceptor {
    /**
     *
     * 维护一个目标对象
     */
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     * @return 代理对象
     */
    public Object getProxyInstance(){
        // 工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调函数
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开启事务");
        Object returnValue = method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }
}
