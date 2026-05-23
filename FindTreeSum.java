public class FindTreeSum {
    static int findSum(Node root){
        if(root == null) return 0 ;
        int lSum = findSum(root.left);
        int rSum = findSum(root.right);
        int oldValue = root.data;
        root.data = lSum+rSum;
        return oldValue+root.data;
    }
    public void toSumTree(Node root) {
        findSum(root);
    }
}
