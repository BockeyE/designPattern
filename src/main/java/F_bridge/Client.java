package F_bridge;

/*
1)桥接模式(Bridge 模式)是指：将实现与抽象放在两个不同的类层次中，使两个层次可以独立改变。


1)Jdbc 的 Driver 接口，如果从桥接模式来看，Driver 就是一个接口，下面可以有 MySQL 的 Driver，Oracle 的
Driver，这些就可以当做实现接口类



1)实现了抽象和实现部分的分离，从而极大的提供了系统的灵活性，让抽象部分和实现部分独立开来，这有助于系统进行分层设计，从而产生更好的结构化系统。
2)对于系统的高层部分，只需要知道抽象部分和实现部分的接口就可以了，其它的部分由具体业务来完成。
3)桥接模式替代多层继承方案，可以减少子类的个数，降低系统的管理和维护成本。
4)桥接模式的引入增加了系统的理解和设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计和编程
5)桥接模式要求正确识别出系统中两个独立变化的维度(抽象、和实现)，因此其使用范围有一定的局限性，即需要有这样的应用场景。
 */


import D_builder.CommonHouse;
import D_builder.HighBuilding;
import D_builder.House;
import D_builder.HouseDirector;

public class Client {
    public static void main(String[] args) {


        Phone phone1 = new FoldedPhone(new Mi());


        phone1.open();
        phone1.call();
        phone1.close();

        System.out.println("=======================");


        Phone phone2 = new FoldedPhone(new Vivo());


        phone2.open();
        phone2.call();
        phone2.close();

        System.out.println("==============");


        UpRightPhone phone3 = new UpRightPhone(new Mi());


        phone3.open();
        phone3.call();
        phone3.close();

        System.out.println("==============");


        UpRightPhone phone4 = new UpRightPhone(new Vivo());


        phone4.open();
        phone4.call();
        phone4.close();
    }
}