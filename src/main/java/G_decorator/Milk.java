package G_decorator;

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes(" 牛 奶 ");
        setPrice(2.0f);
    }
}
