/**
 * 132模式,我们从后往前找,重要的是要找到次大值
 * 这里使用一个栈来记录次大值,我们要保证次大值一定是尽可能大
 * 最后我们比较当前值与次大值
 * 
 */

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length-1]);
        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (second > nums[i])
                return true;
            // 从栈中寻找到最大的次大值
            while (!stack.isEmpty() && nums[i] > stack.peek()) 
                second=Math.max(stack.pop(),second);
            // 如果当前元素小于栈顶元素则push()
            stack.push(nums[i]);
        }

        return false;
    }
}