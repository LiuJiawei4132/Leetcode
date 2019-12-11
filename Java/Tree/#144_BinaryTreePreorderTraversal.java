/**
 * 二叉树的前序遍历
 * 
 * 前序遍历的规则如下:
 * 
 *            1
 *          /   \
 *         2     3
 *        / \   / \
 *       4   5 6   7
 * 
 * 输出: 1, 2, 4, 5, 3, 6, 7
 * 
 * 1.递归法,先将节点数值添加到List中,再遍历树的左节点,再遍历树的右节点
 * 
 * 2.迭代法,实现方式与递归思路一样,因为递归就是通过栈来实现的
 */

// 迭代法
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            while (curr != null) {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }

        return list;
    }
}


// 递归法
/* class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        helper(root,list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) { 
        if (node == null) return;
        list.add(node.val);
        helper(node.left, list);
        helper(node.right, list);
    }
} */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */