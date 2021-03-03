package N_visitor;

/*
1)访问者模式（Visitor Pattern），封装一些作用于某种数据结构的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。
2)主要将数据结构与数据操作分离，解决 数据结构和操作耦合性问题
3)访问者模式的基本工作原理是：在被访问的类里面加一个对外提供接待访问者的接口

4)访问者模式主要应用场景是：需要对一个对象结构中的对象进行很多不同操作(这些操作彼此没有关联)，同时
需要避免让这些操作"污染"这些对象的类，可以选用访问者模式解决

 */

public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//创建 ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();


        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());


//成功
        Success success = new Success();
        objectStructure.display(success);

        System.out.println("===============");
        Fail fail = new Fail();
        objectStructure.display(fail);
        System.out.println("=======给的是待定的测评========");


        Wait wait = new Wait();
        objectStructure.display(wait);

    }
}
