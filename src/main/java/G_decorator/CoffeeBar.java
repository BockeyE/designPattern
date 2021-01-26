package G_decorator;

/**
 * 1)装饰者模式：动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性，装饰者模式也体现了开闭原则(ocp)
 * 2)这里提到的动态的将新功能附加到对象和 ocp 原则，在后面的应用实例上会以代码的形式体现，请同学们注意体会。
 * 11.7装饰者模式原理
 * 1)装饰者模式就像打包一个快递
 * 主体：比如：陶瓷、衣服 (Component) //  被装饰者
 * 包装：比如：报纸填充、塑料泡沫、纸板、木板(Decorator)
 * 2)Component 主体：比如类似前面的 Drink
 * 3)ConcreteComponent 和 Decorator
 * ConcreteComponent：具体的主体， 比如前面的各个单品咖啡
 * 4)Decorator: 装饰者，比如各调料.
 * 在如图的 Component 与 ConcreteComponent 之间，如果 ConcreteComponent 类很多,还可以设计一个缓冲层，将共有的部分提取出来，抽象层一个类。
 *
 *
 * Java 的 IO 结构，FilterInputStream 就是一个装饰者
 *
 *
 *
 *
 */
public class CoffeeBar {
    public static void main(String[] args) {
// 装饰者模式下的订单：2 份巧克力+一份牛奶的 LongBlack

// 1.  点一份 LongBlack
        Drink order = new LongBlack();
        System.out.println("费用 1=" + order.cost());
        System.out.println("描述=" + order.getDes());

// 2. order 加入一份牛奶
        order = new Milk(order);

        System.out.println("order 加入一份牛奶 费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

// 3. order 加入一份巧克力


        order = new Chocolate(order);

        System.out.println("order 加入一份牛奶  加入一份巧克力	费 用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = " + order.getDes());

// 3. order 加入一份巧克力


        order = new Chocolate(order);

        System.out.println("order 加入一份牛奶  加入 2 份巧克力	费 用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入 2 份巧克力 描述 = " + order.getDes());


        System.out.println("===========================");


        Drink order2 = new DeCaf();

        System.out.println("order2 无因咖啡	费 用 =" + order2.cost());
        System.out.println("order2 无因咖啡 描述 = " + order2.getDes());
        order2 = new Milk(order2);
        System.out.println("order2 无因咖啡  加入一份牛奶	费 用 =" + order2.cost());
        System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());
    }
}