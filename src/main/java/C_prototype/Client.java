package C_prototype;

/*

2)在创建新的对象时，总是需要重新获取原始对象的属性，如果创建的对象比较复杂时，效率较低
3)总是需要重新初始化对象，而不是动态地获得对象运行时的状态, 不够灵活


* 7.7原型模式在 Spring 框架中源码分析
1)Spring 中原型 bean 的创建，就是原型模式的应用
2)代码分析+Debug 源码
*
*
* 7.8.1浅拷贝的介绍

1)对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性值复制一份给新的对象。
2)对于数据类型是引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递，也就是只是将该成员变量的引用值（内存地址）复制一份给新的对象。因为实际上两个对象的该成员变量都指向同一个实例。在这种情况下，在一个对象中修改该成员变量会影响到另一个对象的该成员变量值
* 3)前面我们克隆羊就是浅拷贝
4)浅拷贝是使用默认的 clone()方法来实现
sheep = (Sheep) super.clone();


7.8.2深拷贝基本介绍

1)复制对象的所有基本数据类型的成员变量值
2)为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象。也就是说，对象进行深拷贝要对整个对象(包括对象的引用类型)进行拷贝

3)深拷贝实现方式 1：重写 clone 方法来实现深拷贝
4)深拷贝实现方式 2：通过对象序列化实现深拷贝(推荐)
*序列化
        bos = new ByteArrayOutputStream(); oos = new ObjectOutputStream(bos);
        oos.writeObject(this); //当前这个对象以对象流的方式输出
反序列化
        bis = new ByteArrayInputStream(bos.toByteArray()); ois = new ObjectInputStream(bis);
        DeepProtoType copyObj = (DeepProtoType)ois.readObject();
        return copyObj;
*
*
*

*
*7.10原型模式的注意事项和细节
*
1)创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率
2)不用重新初始化对象，而是动态地获得对象运行时的状态
3)如果原始对象发生变化(增加或者减少属性)，其它克隆对象的也会发生相应的变化，无需修改代码
4)在实现深克隆的时候可能需要比较复杂的代码
5)缺点：需要为每一个类配备一个克隆方法，这对全新的类来说不是很难，但对已有的类进行改造时，需要修改其源代码，违背了 ocp 原则，这点请同学们注意.
* */


public class Client {
    public static void main(String[] args) {
        System.out.println("原型模式完成对象的创建");
        Sheep sheep = new Sheep("tom", 1, "白色");

        sheep.friend = new Sheep("jack", 2, "黑色");

        Sheep sheep2 = (Sheep) sheep.clone(); //克隆
        Sheep sheep3 = (Sheep) sheep.clone(); //克隆
        Sheep sheep4 = (Sheep) sheep.clone(); //克隆
        Sheep sheep5 = (Sheep) sheep.clone(); //克隆


        System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
        System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
        System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend.hashCode());
        System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend.hashCode());
    }
}