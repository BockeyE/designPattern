package K_proxy.cglibProxy;

/*

15.4.1Cglib 代理模式的基本介绍

1)静态代理和 JDK 代理模式都要求目标对象是实现一个接口,但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,这个时候可使用目标对象子类来实现代理-这就是 Cglib 代理
2)Cglib 代理也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能扩展, 有些书也将Cglib 代理归属到动态代理。
3)Cglib 是一个强大的高性能的代码生成包,它可以在运行期扩展 java 类与实现 java 接口.它广泛的被许多 AOP 的框架使用,例如 Spring AOP，实现方法拦截
4)在 AOP 编程中如何选择代理模式：
1.目标对象需要实现接口，用 JDK 代理
2.目标对象不需要实现接口，用 Cglib 代理
5)Cglib 包的底层是通过使用字节码处理框架 ASM 来转换字节码并生成新的类


15.5几种常见的代理模式介绍— 几种变体
1)防火墙代理
内网通过代理穿透防火墙，实现对公网的访问。
2)缓存代理
比如：当请求图片文件等资源时，先到缓存代理取，如果取到资源则 ok,如果取不到资源，再到公网或者数据库取，然后缓存。

3)远程代理
远程对象的本地代表，通过它可以把远程对象当本地对象来调用。远程代理通过网络和真正的远程对象沟通信息。
4)同步代理：主要使用在多线程编程中，完成多线程间同步工作同步代理：主要使用在多线程编程中，完成多线程间同步工作




 */


public class Client {
    public static void main(String[] args) {
//创建目标对象
        TeacherDao target = new TeacherDao();
//获取到代理对象，并且将目标对象传递给代理对象
        TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();

//执行代理对象的方法，触发 intecept  方法，从而实现 对目标对象的调用
        String res = proxyInstance.teach(); System.out.println("res=" + res);
    }
}