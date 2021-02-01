package H_composite;

/*

基本介绍

1)组合模式（Composite Pattern），又叫部分整体模式，它创建了对象组的树形结构，将对象组合成树状结构以表示“整体-部分”的层次关系。

2)组合模式依据树形结构来组合对象，用来表示部分以及整体层次。
3)这种类型的设计模式属于结构型模式。
4)组合模式使得用户对单个对象和组合对象的访问具有一致性，即：组合能让客户以一致的方式处理个别对象以及组合对象




1)Java 的集合类-HashMap 就使用了组合模式

1)简化客户端操作。客户端只需要面对一致的对象而不用考虑整体部分或者节点叶子的问题。
2)具有较强的扩展性。当我们要更改组合对象时，我们只需要调整内部的层次关系，客户端不用做出任何改动.
3)方便创建出复杂的层次结构。客户端不用理会组合里面的组成细节，容易添加节点或者叶子从而创建出复杂的树形结构
4)需要遍历组织机构，或者处理的对象具有树形结构时, 非常适合使用组合模式.
5)要求较高的抽象性，如果节点和叶子有很多差异性的话，比如很多方法和属性都不一样，不适合使用组合模式




 */


import F_bridge.*;

public class Client {
    public static void main(String[] args) {


        //从大到小创建对象 学校
        OrganizationComponent university = new University("清华大学", " 中国顶级大学 ");

//创建 学院
        OrganizationComponent computerCollege = new College(" 计 算 机 学 院 ", " 计 算 机 学 院 ");
        OrganizationComponent infoEngineercollege = new College("信息工程学院", " 信息工程学院 ");


//创建各个学院下面的系(专业)
        computerCollege.add(new Department("软件工程", " 软件工程不错 "));
        computerCollege.add(new Department("网络工程", " 网络工程不错 "));
        computerCollege.add(new Department("计算机科学与技术", " 计算机科学与技术是老牌的专业 "));


//
        infoEngineercollege.add(new Department("通信工程", " 通信工程不好学 "));
        infoEngineercollege.add(new Department("信息工程", " 信息工程好学 "));


//将学院加入到 学校
        university.add(computerCollege);
        university.add(infoEngineercollege);

        university.print();
        infoEngineercollege.print();
    }
}