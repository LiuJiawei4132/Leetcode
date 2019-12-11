/**
 * addAll()🐮🍺!!!
 * 递归nestedList,只要发现不是Integer就走下一步
 */


public class NestedIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    int idx = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = getIntegerList(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(idx-1);
    }

    @Override
    public boolean hasNext() {
        if (idx++ < list.size())
            return true;
        return false;
    }

    private static List<Integer> getIntegerList(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList(nestedList.size());
        for (NestedInteger n : nestedList) {
            if (n.isInteger())
                list.add(n.getInteger());
            else
                list.addAll(getIntegerList(n.getList()));
        }

        return list;
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */