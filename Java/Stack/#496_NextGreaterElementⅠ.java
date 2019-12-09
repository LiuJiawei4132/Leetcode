/**
 * 下一个更大元素
 * 这题就像我们排队时一样,要是前面的人比我高,我就只能看到前面的人,后面的都被他给挡住了
 * 若是前面的人比我矮,那我就能看到更远处比我高的人
 * 我们用栈来模拟这种情形,如果前面的人比我矮就入栈,直到他遇到第一个比他高的人:出栈,判断栈顶元素是否还是比那个人矮
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // map保存nums2中每个数值所对应的下一个更大元素
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while(!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while (!stack.empty()) 
            map.put(stack.pop(), -1);

        for (int i = 0; i < nums1.length; i++) 
            res[i] = map.get(nums1[i]);
  
        return res;
    }
}