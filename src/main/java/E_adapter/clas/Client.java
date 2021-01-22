package E_adapter.clas;


/**
 *9.3工作原理
 * 1)适配器模式：将一个类的接口转换成另一种接口.让原本接口不兼容的类可以兼容
 * 2)从用户的角度看不到被适配者，是解耦的
 * 3)用户调用适配器转化出来的目标接口方法，适配器再调用被适配者的相关接口方法
 * 4)用户收到反馈结果，感觉只是和目标接口交互，如图
 *
 *
 *
 1)Java 是单继承机制，所以类适配器需要继承 src 类这一点算是一个缺点, 因为这要求 dst 必须是接口，有一定局限性;
 2)src 类的方法在 Adapter 中都会暴露出来，也增加了使用的成本。
 3)由于其继承了 src 类，所以它可以根据需求重写 src 类的方法，使得 Adapter 的灵活性增强了。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println(" === 类适配器模式 ====");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
