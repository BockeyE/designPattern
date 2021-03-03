package P_observer;

/*
1)观察者模式类似订牛奶业务
2)奶站/气象局：Subject
3)用户/第三方网站：Observer

Subject：登记注册、移除和通知
1)registerObserver 注 册
2)removeObserver 移 除
3)notifyObservers() 通知所有的注册的用户，根据不同需求，可以是更新数据，让用户来取，也可能是实施推送， 看具体需求定
Observer：接收输入

观察者模式：对象之间多对一依赖的一种设计方案，被依赖的对象为 Subject，依赖的对象为 Observer，Subject
通知 Observer 变化,比如这里的奶站是 Subject，是 1 的一方。用户时 Observer，是多的一方。 */



public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
//创建一个 WeatherData
        WeatherData weatherData = new WeatherData();

//创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();

// 注 册 到 weatherData
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);

// 测 试
        System.out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);


        weatherData.removeObserver(currentConditions);
//测试System.out.println();
        System.out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);
    }
}
