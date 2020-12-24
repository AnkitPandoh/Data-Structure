package tree;

public class MorrisTraversal {

    static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void inorder(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                // Set the Link
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else if (prev.right == root) { // Unlink
                    System.out.print(root.val + "->");
                    prev.right = null;
                    root = root.right;
                }
            } else {
                System.out.print(root.val + "->");
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.right = node5;

        System.out.println();
        System.out.println("InOrder");
        new MorrisTraversal().inorder(root);

    }
}
