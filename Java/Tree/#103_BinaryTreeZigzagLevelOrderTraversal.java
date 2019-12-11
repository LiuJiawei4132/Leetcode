/**
 * 将每一层的子节点用一个List(tmp)装起来,当本层遍历完时,交换两个List
 * 因为题目要求,我们使用一个flag来判断奇数层和偶数层
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // list用于返回最后数据
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        // 保存每一层的节点
        List<TreeNode> treeList = new LinkedList<>();
        treeList.add(root);

        // 奇偶(先后)顺序打印，题目要求
        
        boolean flag = false;
        while (!treeList.isEmpty()) {
            List<Integer> data = new LinkedList<>();
            List<TreeNode> tmp = new LinkedList<>();
            for (TreeNode n : treeList) {
                if (n.left != null) tmp.add(n.left);
                if (n.right != null) tmp.add(n.right);

                if (!flag)
                    data.add(n.val);
                else
                    data.add(0, n.val);

                treeList = tmp;
            }
            flag = !flag;
            list.add(data);
        }

        return list;
    }
}