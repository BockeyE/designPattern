package A_singleton;

//dcl
public class Singleton1 {
    public static void main(String[] args) {
        System.out.println("双重检查");
        SingletonA instance = SingletonA.getInstance();
        SingletonA instance2 = SingletonA.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}

class SingletonA {
    private static volatile SingletonA instance;

    private SingletonA() {
    }

//提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
//同时保证了效率, 推荐使用

    public static synchronized SingletonA getInstance() {
        if (instance == null) {
            synchronized (SingletonA.class) {
                if (instance == null) {
                    instance = new SingletonA();
                }
            }

        }
        return instance;
    }
}

/**

 1)Double-Check 概念是多线程开发中常使用到的，如代码中所示，
 我们进行了两次 if (singleton == null)检查，这样就可以保证线程安全了。
 2)这样，实例化代码只用执行一次，后面再次访问时，判断 if (singleton == null)，
 直接 return 实例化对象，也避免的反复进行方法同步.
 3)线程安全；延迟加载；效率较高
 4)结论：在实际开发中，推荐使用这种单例设计模式
 */