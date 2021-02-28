package M_command;

/*
1)命令模式（Command Pattern）：在软件设计中，我们经常需要向某些对象发送请求，但是并不知道请求的接收者是谁，也不知道被请求的操作是哪个，
我们只需在程序运行时指定具体的请求接收者即可，此时，可以使用命令模式来进行设计
2)命名模式使得请求发送者与请求接收者消除彼此之间的耦合，让对象之间的调用关系更加灵活，实现解耦。
3)在命名模式中，会将一个请求封装为一个对象，以便使用不同参数来表示不同的请求(即命名)，同时命令模式也支持可撤销的操作。

 */

import L_template.PeanutSoyaMilk;
import L_template.RedBeanSoyaMilk;
import L_template.SoyaMilk;

public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

//使用命令设计模式，完成通过遥控器，对电灯的操作

//创建电灯的对象(接受者)
        LightReceiver lightReceiver = new LightReceiver();

//创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

//需要一个遥控器
        RemoteController remoteController = new RemoteController();

//给我们的遥控器设置命令, 比如 no = 0  是电灯的开和关的操作
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("--------按下灯的开按钮-----------");
        remoteController.onButtonWasPushed(0);
        System.out.println("--------按下灯的关按钮-----------");
        remoteController.offButtonWasPushed(0);
        System.out.println("--------按下撤销按钮-----------");
        remoteController.undoButtonWasPushed();


        System.out.println("=========使用遥控器操作电视机==========");
        TVReceiver tvReceiver = new TVReceiver();

        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);

//给我们的遥控器设置命令, 比如 no = 1  是电视机的开和关的操作
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);

        System.out.println("--------按下电视机的开按钮-----------");
        remoteController.onButtonWasPushed(1);
        System.out.println("--------按下电视机的关按钮-----------");
        remoteController.offButtonWasPushed(1);
        System.out.println("-------- 按 下 撤 销 按 钮 -----------");
        remoteController.undoButtonWasPushed();
    }


}

