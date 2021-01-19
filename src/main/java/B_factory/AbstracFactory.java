package B_factory;


/*
* 1)工厂模式的意义
将实例化对象的代码提取出来，放到一个类中统一管理和维护，达到和主项目的依赖关系的解耦。从而提高项目的扩展和维护性。
2)三种工厂模式 (简单工厂模式、工厂方法模式、抽象工厂模式)
3)设计模式的依赖抽象原则

创建对象实例时，不要直接 new 类, 而是把这个 new 类的动作放在一个工厂的方法中，并返回。有的书上说， 变量不要直接持有具体类的引用。
不要让类继承具体类，而是继承抽象类或者是实现 interface(接口)
不要覆盖基类中已经实现的方法。*/
public interface AbstracFactory {
    //根据 orderType 返回对应的 Pizza 对象
    Pizza createPizza(String orderType);
}
