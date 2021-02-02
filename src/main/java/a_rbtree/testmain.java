package a_rbtree;

public class testmain {
    public static void main(String[] args) {
        LocalRBTree<Integer, Object> tree = new LocalRBTree<>();
        tree.insert(1,null);
        tree.insert(3,null);
        tree.insert(4,null);
        tree.insert(5,null);
        tree.insert(8,null);
        tree.insert(11,null);
        tree.insert(22,null);
        tree.insert(14,null);
        tree.insert(15,null);
        tree.insert(18,null);
        tree.insert(32,null);
        tree.insert(32,null);
        tree.insert(13,null);
        tree.insert(7,null);
        tree.insert(66,null);
        tree.insert(67,null);
        tree.insert(69,null);
        tree.insert(71,null);
        tree.insert(77,null);
        tree.insert(79,null);
        tree.insert(88,null);
        tree.printTreeGraphics();
//        tree.orderPrint();
        System.out.println(tree.root.getKey());

    }
}
