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

/*  红黑树脱胎于 234树，也就是4阶（最多三元素一组）的b树
 *
 *  b树的每一层是 n阶的数组，根据 x<n 的元素数量决定 子节点的个数
 *  对与234树来说一个 4阶节点（3元素），加入进来一个节点时，中间节点会升级，新节点靠过来，分裂成量部分，即
 *                  2
 *  123  ->        / \
 *                1   34
 *
 *
 *  234阶节点对应红黑树中的表示方式 是          黑        黑-红   红-黑-红
 * 因此发展出 红黑树
 */
