给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
class Solution {
    public int longestPalindrome(String s) {
        int[] arr=new int[52];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='a'&&c<='z'){
                arr[c-'a']++;
            }else{
                arr[c-'A'+26]++;
            }
        }
        int maxLen=0;
        boolean flag=false;
        for(int i=0;i<52;i++){
            if(flag&&arr[i]%2==1){
                maxLen+=arr[i]-1;
            }else if(arr[i]%2==0){
                maxLen+=arr[i];
            }else if(arr[i]%2==1){
                maxLen+=arr[i];
                flag=true;
            }
        }
        return maxLen;
    }
}

在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int xpar;
    private int ypar;
    private int xdepth;
    private int ydepth; 
    public boolean isCousins(TreeNode root, int x, int y) {
        isCousins(root,x,y,0,0);
        return (xdepth==ydepth)&&(xpar!=ypar);
    }
    private void isCousins(TreeNode root,int x,int y,int parent,int depth){
        if(root==null){
            return ;
        }
        if(root.val==x){
            xpar=parent;
            xdepth=depth;
        }
        if(root.val==y){
            ypar=parent;
            ydepth=depth;
        }
        isCousins(root.left,x,y,root.val,depth+1);
        isCousins(root.right,x,y,root.val,depth+1);
    }
}

给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size!=0){
                TreeNode cur=queue.poll();
                if(size==1){
                    res.add(cur.val);
                }
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
                size--;
            }
        }
        return res;
    }
}

如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        return isUnivalTree(root,root.val);
    }
    private boolean isUnivalTree(TreeNode root,int key){
        if(root==null){
            return true;
        }
        if(root.val!=key){
            return false;
        }
        return isUnivalTree(root.left,key)&&isUnivalTree(root.right,key);
    }
}

在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res=new LinkedList<>();
        int min=1;
        int max=1;
        int level=1;
        while(max<label){
            min=min*2;
            max=max*2+1;
            level++;
        }
        while(level!=1){
            res.add(label);
            max=(max-1)/2;
            min/=2;
            label=max+min-label/2;
            level--;
        }
        res.add(1);
        Collections.reverse(res);
        return res;
    }
}

