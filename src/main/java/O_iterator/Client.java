package O_iterator;

/*
1)迭代器模式（Iterator Pattern）是常用的设计模式，属于行为型模式
2)如果我们的集合元素是用不同的方式实现的，有数组，还有 java 的集合类，或者还有其他方式，当客户端要遍历这些集合元素的时候就要使用多种遍历方式，而且还会暴露元素的内部结构，可以考虑使用迭代器模式解决。
3)迭代器模式，提供一种遍历集合元素的统一接口，用一致的方法遍历集合元素，不需要知道集合对象的底层表示，即：不暴露其内部的结构。
 */

import java.util.ArrayList; import java.util.List;
public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
//创建学院
        List<College> collegeList = new ArrayList<College>();


        ComputerCollege computerCollege = new ComputerCollege(); InfoCollege infoCollege = new InfoCollege();

        collegeList.add(computerCollege);
//collegeList.add(infoCollege);


        OutPutImpl outPutImpl = new OutPutImpl(collegeList); outPutImpl.printCollege();
    }
}
