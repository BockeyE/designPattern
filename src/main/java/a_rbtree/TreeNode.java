package a_rbtree;

public class TreeNode<K extends Comparable<K>, V> {
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;
    private K key;
    private V value;
    private boolean color;
}
