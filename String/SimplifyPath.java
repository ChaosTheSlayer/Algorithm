package Algorithm.String;

//Question:https://leetcode.com/problems/simplify-path/

// 这道题目是Linux内核中比较常见的一个操作，就是对一个输入的文件路径进行简化。
// 思路比较明确，就是维护一个栈，对于每一个块（以‘/’作为分界）进行分析，
// 如果遇到‘../’则表示要上一层，那么就是进行出栈操作，如果遇到‘./’则是停留当前，直接跳过，
// 其他文件路径则直接进栈即可。最后根据栈中的内容转换成路径即可（这里是把栈转成数组，然后依次添加）。
// 时间上不会超过两次扫描（一次是进栈得到简化路径，一次是出栈获得最后结果），所以时间复杂度是O(n)，
// 空间上是栈的大小，也是O(n)。代码如下：

public class SimplifyPath{
	  public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        LinkedList<String> stack = new LinkedList<String>();
        int i = 0;
        while(i<path.length()){
            int index = i;
            StringBuilder temp = new StringBuilder();
            while(i<path.length() && path.charAt(i) != '/'){
                temp.append(path.charAt(i));
                i++;
            }
            if(index != i){
                String str = temp.toString();
                if(str.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else if(!str.equals(".")){
                    stack.push(str);
                }
            }
            i++;
        }
        if(!stack.isEmpty()){
            String[] strs = stack.toArray(new String[stack.size()]);
            for(int j = strs.length-1;j>=0;j--){
                res.append('/');
                res.append(strs[j]);
            }
        }
        if(res.length() == 0){
            return "/";
        }
        return res.toString();
    }
}