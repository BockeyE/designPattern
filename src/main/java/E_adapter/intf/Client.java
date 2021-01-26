package E_adapter.intf;


import E_adapter.clas.Phone;
import E_adapter.clas.VoltageAdapter;

/**
 * 1)一些书籍称为：适配器模式(Default Adapter Pattern)或缺省适配器模式。
 * 2)核心思路：当不需要全部实现接口提供的方法时，可先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认实现（空方法），那么该抽象类的子类可有选择地覆盖父类的某些方法来实现需求
 * 3)适用于一个接口不想使用其所有的方法的情况。
 *
 *
 *
 * 1)SpringMvc 中的 HandlerAdapter, 就使用了适配器模式
 * 2)SpringMVC 处理请求的流程回顾
 * 3)使用 HandlerAdapter 的原因分析:
 * 可以看到处理器的类型不同，有多重实现方式，那么调用方式就不是确定的，如果需要直接调用 Controller 方法，需要调用的时候就得不断是使用 if else 来进行判断是哪一种子类然后执行。那么如果后面要扩展 Controller， 就得修改原来的代码，这样违背了 OCP 原则。
 * 4)代码分析+Debug 源码
 *
 *
 */
public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            //只需要去覆盖我们 需要使用 接口方法
            @Override
            public void m1() {
// TODO Auto-generated method stub
                System.out.println("使用了 m1 的方法");
            }
        };


        absAdapter.m1();
    }
}
