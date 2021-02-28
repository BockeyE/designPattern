package a_rbtree;


public class getFromPreOrderProcess {
    public static void main(String[] args) {
        int[] re = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        new Solution().reConstructBinaryTree(re, in);
    }

    static class Solution {
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

            if (pre.length == 0) {
                return null;
            }
            int rootValue = pre[0];
            TreeNode root = new TreeNode((rootValue));
            if (pre.length == 1) {
                return root;
            }
            int index = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == rootValue) {
                    index = i;
                    break;
                }
            }
            int[] pre1 = new int[index];
            int[] in1 = new int[index];
            int[] pre2 = new int[in.length - 1 - index];
            int[] in2 = new int[in.length - 1 - index];
            System.arraycopy(pre, 1, pre1, 0, index);
            System.arraycopy(pre, index + 1, pre2, 0, in.length - 1 - index);
            System.arraycopy(in, 0, in1, 0, index);
            System.arraycopy(in, index + 1, in2, 0, in.length - 1 - index);
            root.left = reConstructBinaryTree(pre1, in1);
            root.right = reConstructBinaryTree(pre2, in2);
            return root;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            right = null;
            left = null;
        }
    }

}
