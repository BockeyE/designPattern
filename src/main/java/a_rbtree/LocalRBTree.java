package a_rbtree;

/*
1）每个结点要么是红的，要么是黑的。
2）根结点是黑的。
3）每个叶结点（叶结点即指树尾端NIL指针或NULL结点）是黑的。
4）如果一个结点是红的，那么它的两个子节点都是黑的。
5）对于任一结点而言，其到叶结点树尾端NIL指针的每一条路径都包含相同数目的黑结点。
*/

/**
 *
 */

public class LocalRBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    RBNode root;
    int size;

    private RBNode parentOf(RBNode tar) {
        if (tar != null) {
            return tar.parent;
        }
        return null;
    }

    private boolean isRed(RBNode tar) {
        if (tar != null) {
            return tar.color == RED;
        }
        return false;
    }

    private boolean isBlack(RBNode tar) {
        if (tar != null) {
            return tar.color == BLACK;
        }
        return false;
    }

    private void setRed(RBNode tar) {
        if (tar != null) {
            tar.setColor(RED);
        }
    }

    private void setBlack(RBNode tar) {
        if (tar != null) {
            tar.setColor(BLACK);
        }
    }

    private void orderPrint(RBNode tar) {
        if (tar == null) {
            return;
        }
        orderPrint(tar.left);
        System.out.println("k:" + tar.key + " || v:" + tar.value);
        orderPrint(tar.right);
    }

    public void orderPrint() {
        System.out.println("orderPrint");
        orderPrint(this.root);
        System.out.println("orderPrint");
    }

//    =-===================================================================================================

    public void insert(K key, V value) {
        RBNode node = new RBNode();
        node.setKey(key);
        node.setValue(value);
        node.setColor(RED);
        insert(node);
        size++;
    }

    private void insert(RBNode node) {
        RBNode parent = null;
        RBNode x = this.root;
        while (x != null) {
            parent = x;

            //查找判断 >0 说明node key大于x
            int compareRes = node.key.compareTo(x.key);
            if (compareRes > 0) {
                x = x.right;
            } else if (compareRes == 0) {
                x.setValue(node.value);
                return;
            } else {
                x = x.left;
            }
        }
        // 出循环之后，就是找到了 x的位置
        node.parent = parent;

        if (parent != null) {
            //查找判断 >0 说明node key大于x
            int compareRes = node.key.compareTo(parent.key);
            if (compareRes > 0) {
                parent.right = node;
            } else {
                parent.left = node;
            }
        } else {
            this.root = node;
        }

        // 需要调用修复红黑树平衡的方法
        insertFixedUp(node);

    }

    private void insertFixedUp(RBNode node) {
        /*
         *  插入后修复红黑树平衡的方法
         *       1- 空树            ===>  root节点染黑
         *       2- 插入点的key已经存在   ===> 无需修复
         *       3- 插入点的父点为黑色    ===> 无需修复
         *
         *       4- 插入点的父点为红色 且叔点存在 为红色 即父叔-双红    ===> 父叔染黑 爷点染红，以爷点（当成新插入的红点）为当前点继续修复
         *
         *       5- 插入点的父点为红色 且叔点不存在或者为黑色 父点为爷爷点的左子 且当前点为父点的左子 LL情况
         *                  ===>   父变黑，爷变红，爷点右旋即可
         *       6- 插入点的父点为红色 且叔点不存在或者为黑色 父点为爷爷点的左子 且当前点为父点的右子 LR情况
         *                  ===>   以父点左旋一次，得到LL双红，然后走上面
         *
         *       7- 插入点的父点为红色 且叔点不存在或者为黑色 父点为爷爷点的右子 且当前点为父点的左子 RL情况
         *                  ===>   以父点右旋一次，得到RR双红，然后走下面
         *       8- 插入点的父点为红色 且叔点不存在或者为黑色 父点为爷爷点的右子 且当前点为父点的右子 RR情况
         *                  ===>   父变黑，爷变红，爷点左旋即可
         *
         *
         * */

        this.root.setColor(BLACK);
        RBNode parent = parentOf(node);
        RBNode grandParent = parentOf(parent);
        if (isRed(parent)) {
            //父点为红，一定有爷点

            RBNode uncle = null;
            if (parent == grandParent.left) {
                //父点在左
                uncle = grandParent.right;

                //叔存 且红，情况4
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(grandParent);
                    insertFixedUp(grandParent);
                    return;
                }

                if (uncle == null || isBlack(uncle)) {
                    //情况5，LL双红
                    if (node == parent.left) {
                        setBlack(parent);
                        setRed(grandParent);
                        rightRotate(grandParent);
                        return;
                    }

                    //情况6，LR双红
                    if (node == parent.right) {
                        leftRotate(parent);
                        insertFixedUp(parent);
                        return;
                    }
                }

            } else {
                //父点在右

                uncle = grandParent.left;

                //叔存 且红，情况4
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(grandParent);
                    insertFixedUp(grandParent);
                    return;
                }

                if (uncle == null || isBlack(uncle)) {
                    //情况8，RR双红
                    if (node == parent.right) {
                        setBlack(parent);
                        setRed(grandParent);
                        leftRotate(grandParent);
                        return;
                    }

                    //情况7，RL双红
                    if (node == parent.left) {
                        rightRotate(parent);
                        insertFixedUp(parent);
                        return;
                    }
                }
            }
        }
    }


    private void leftRotate(RBNode x) {
        /*
        左旋意味着把 x向左下移动一位
         *       p                 p
         *       |                 |
         *       x                 y
         *      / \      =>       / \
         *     lx  y             x   ry
         *        / \           / \
         *       ly  ry        lx  ly
         *
         * */
        //x的右子 指向y的左子，将y的左子的父点指向x
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        //当x的父点不空时，把 y的父点指向 x的父点，将其原x的对应子点指向y
        if (x.parent != null) {
            y.parent = x.parent;
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        } else {
            //x原来是root，此时要把y更新为root
            this.root = y;
            y.parent = null;
        }

        //将x的父点 更新为y，y的左子 指向x
        x.parent = y;
        y.left = x;

    }

    private void rightRotate(RBNode y) {
        /*
        左旋意味着把 y向右下移动
         *       p                 p
         *       |                 |
         *       y                 x
         *      / \      =>       / \
         *     x  ry            lx   y
         *    / \                   / \
         *   lx  rx                rx  ry
         *
         * */
        //y的左子 指向x的右子，将x的右子的父点指向y
        RBNode x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        //当y的父点不空时，把 x的父点指向 y的父点，将其原y的对应子点指向x
        if (y.parent != null) {
            x.parent = y.parent;
            if (y == y.parent.left) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        } else {
            //y原来是root，此时要把x更新为root
            this.root = x;
            x.parent = null;
        }

        //将y的父点 更新为x，x的右子 指向y
        y.parent = x;
        x.right = y;

    }


//==================================================================================

/*
删除非叶子节点时需要找替代节点来 替代
包括前驱节点和后继节点，即 比自己小的，最大者；或者比自己大的最小者，也就是说大小顺序最接近的前后两点
搜索方法是 左子一直右探寻找；右子一直左探寻找



删除情况
1，叶子节点，直接删除
2，单孩子节点，子节点替代
3，双子节点，找前驱或者后继来替代
 */


    private RBNode preDecessor(RBNode node) {
        /*
        本方法寻找前驱节点
        如果有子节点，则按照 先左 后右探的方法
        如果没有子节点，则向上寻找，寻找 第一个 是父亲右子点的 点位即可
        即
        5
         \
          7
         / \
        6   8

        寻找6的前驱，是5
        实际删除时 不会使用到该情况；但前驱节点的寻找是这个思路进行
         */
        if (node == null) {
            return null;
        } else if (node.left != null) {
            RBNode p = node.left;
            while (p.right != null) {
                p = p.right;
            }
            return p;
        } else {
            RBNode p = node.parent;
            RBNode ch = node;
            while (p != null
                    && ch == p.left) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    private RBNode successor(RBNode node) {
        /*
        本方法寻找后继节点
         */
        if (node == null) {
            return null;
        } else if (node.right != null) {
            RBNode p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            RBNode p = node.parent;
            RBNode ch = node;
            while (p != null
                    && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }


    public V remove(K key) {
        RBNode node = getNode(key);
        if (node == null) {
            return null;
        }
        V value = (V) node.value;
        deleteNode(node);
        size--;
        return value;
    }

    private RBNode getNode(K key) {
        if (key == null) {
            return null;
        }
        RBNode node = this.root;
        while (node != null) {
            int cmp = key.compareTo((K) node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    private void deleteNode(RBNode node) {
        /*
        为了减少 引用修改的次数，实际删除时没有移动 元素位置，而是直接交互 目标元素的 kv值，减少性能损耗

         */


        // 需要调用修复红黑树平衡的方法
        insertFixedUp(node);

    }


    //==================================================================================
    void padding(String ch, int n) {
        int i;
        for (i = 0; i < n; i++) {
            System.out.printf(ch);
        }
    }

    void printNodes(RBNode node, int level) {
        if (node == null) {
            padding("\t", level);
            System.out.println("NIL");
        } else {
            printNodes(node.right, level + 1);
            padding("\t", level);
            if (node.color == BLACK) {
                System.out.printf("(%d)\n", node.key);
            } else {
                System.out.printf("[%d]\n", node.key);
            }
            printNodes(node.left, level + 1);
        }
    }

    public void printTreeGraphics() {
        System.out.printf("-------------------------------------------\n");
        printNodes(this.root, 0);
        System.out.printf("-------------------------------------------\n");
    }

    //==========================================================================================
    static class RBNode<K extends Comparable<K>, V> {
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private K key;
        private V value;
        private boolean color;

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }

}
