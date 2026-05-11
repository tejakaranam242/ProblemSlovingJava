public class FlatteningLL {
    static class ListNode{
        int data;
        ListNode next;
        ListNode bottom;
        ListNode(int data){
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }
    public ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            }
            else{
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }
        if(list1!=null) res.bottom = list1;
        if(list2!=null) res.bottom = list2;
        return dummyNode.bottom;
    }
    public ListNode flatten(ListNode root) {
        if(root==null || root.next==null) return root;
        ListNode mergedHead = flatten(root.next);
        return mergeLists(root,mergedHead);
    }
}