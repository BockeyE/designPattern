package a_rbtree;

public class testmain {
    public static void main(String[] args) {
        LocalRBTree<Integer, Object> tree = new LocalRBTree<>();
        tree.insert(1,null);
        tree.insert(2,null);
        tree.insert(3,null);
        tree.insert(4,null);
        tree.insert(5,null);
        tree.insert(6,null);
        tree.insert(7,null);
        tree.insert(8,null);
        tree.insert(9,null);
        tree.insert(10,null);
        tree.remove(4);
        tree.remove(6);
//        tree.remove(15);
//        tree.remove(77);
        tree.printTreeGraphics();
        tree.showTree();
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
