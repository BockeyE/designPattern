package a_rbtree;

public class LocalRBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    RBNode root;

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

    private void inOrderPrint(RBNode tar) {
        if (tar != null) {
            inOrderPrint(tar);
            System.out.println("k:" + tar.key + " || v:" + tar.value);
            inOrderPrint(tar);
        }
    }

    public void inOrderPrint() {
        inOrderPrint(this.root);
    }

    public void insert(K key, V value) {
        RBNode node = new RBNode();
        node.setKey(key);
        node.setValue(value);
        node.setColor(RED);
        insert(node);
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
        if (parent != null && isRed(parent)) {

        }
    }


    private void leftRotate(RBNode x) {
        /*
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
            //x原来是root，此时要把y更新为root
            this.root = x;
            x.parent = null;
        }

        //将y的父点 更新为x，x的右子 指向y
        y.parent = x;
        x.left = y;

    }


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
