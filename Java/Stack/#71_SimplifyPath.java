/**
 * 简化路径,先将字符串以"/"分割成字符串数组
 * 再对每个字符串进行判断
 * 满足条件则放入链表中
 * 最后转换成字符串
 */

class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        LinkedList<String> list = new LinkedList<>();

        for (String s : paths) {
            if (!s.equals("")) {
                if (s.equals("..")) {
                    if (list.isEmpty())
                        continue;
                    list.pollLast();
                } else if (s.equals(".")) {
                    continue;
                } else {
                    list.add("/" + s);
                }
            }
        }

        if (list.isEmpty()) {
            return "/";
        }

        String str = "";
        for (String s : list) {
            str += s;
        }

        return str;
    }

}