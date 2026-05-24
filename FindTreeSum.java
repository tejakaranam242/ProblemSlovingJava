class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data,TreeNode left, TreeNode right){
        this.data = data;
        this.left = this.right = null;
    }
}
public class FindTreeSum {
    static int findSum(TreeNode root){
        if(root == null) return 0 ;
        int lSum = findSum(root.left);
        int rSum = findSum(root.right);
        int oldValue = root.data;
        root.data = lSum+rSum;
        return oldValue+root.data;
    }
    public void toSumTree(TreeNode root) {
        findSum(root);
    }
}
