/**
 * 树的中序遍历
 * 
 * 中序遍历的规则如下:
 * 
 *          1
 *        /   \
 *       2     3
 *      / \   / \
 *     4   5 6   7
 * 
 * 输出: 4, 2, 5, 1, 6, 3, 7
 * 
 * 1.递归法,优先遍历树的左节点,找到后添加到List中,再遍历树的右节点
 * 
 * 2.迭代法,实现方式与递归思路一样,因为递归就是通过栈来实现的
 */


// 递归法
/* class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        } 
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
 */

// 迭代法
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */