package L_template;

/*
1)模板方法模式（Template Method Pattern），又叫模板模式(Template	Pattern)，z 在一个抽象类公开定义了执行它的方法的模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。
2)简单说，模板方法模式 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构，就可以重定义该算法的某些特定步骤
3)这种类型的设计模式属于行为型模式。
 */

public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//制作红豆豆浆

        System.out.println("----制作红豆豆浆----");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk(); redBeanSoyaMilk.make();

        System.out.println("---- 制 作 花 生 豆 浆 ----"); SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk(); peanutSoyaMilk.make();
    }


}

