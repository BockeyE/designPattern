package K_proxy.dynamicProxy;

/*

15.3.1动态代理模式的基本介绍

1)代理对象,不需要实现接口，但是目标对象要实现接口，否则不能用动态代理
2)代理对象的生成，是利用 JDK 的 API，动态的在内存中构建代理对象
3)动态代理也叫做：JDK 代理、接口代理

15.3.2JDK 中生成代理对象的 API

1)代理类所在包:java.lang.reflect.Proxy
2)JDK 实现代理只需要使用 newProxyInstance 方法,但是该方法需要接收三个参数,完整的写法是:
static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
 */


public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
//创建目标对象(被代理对象)
        ITeacherDao target = new TeacherDao();

        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

// proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyInstance=" + proxyInstance.getClass());

//通过代理对象，调用目标对象的方法
//proxyInstance.teach();

        proxyInstance.sayHello(" tom ");
    }
}