package B_factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    AbstracFactory factory;

    // 构造器
    public OrderPizza(AbstracFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbstracFactory factory) {
        Pizza pizza = null;
        String orderType = "";
        //  用户输入
        this.factory = factory;
        do {
            orderType = getType();
// factory  可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = factory.createPizza(orderType);
            if (pizza != null) {
                // 订 购 ok
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }


    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
