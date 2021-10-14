package leetcode.algorithm;

/**
 * @author zk
 * @version V1.0.0
 * @date 2021/10/14
 **/
public class FourDay {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。
     * 输入字符串以字符数组 s 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、
     * 使用 O(1) 的额外空间解决这一问题。
     *
     * @param s 字符数组
     */
    public static char[] reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;
        while (low < high) {
            char temp = s[high];
            s[high] = s[low];
            s[low] = temp;
            low++;
            high--;
        }
        return s;
    }

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，
     * 同时仍保留空格和单词的初始顺序。
     * @param s 字符串
     * @return 返回反转后的数据
     */
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str:s1) {
            char[] chars = str.toCharArray();
            int low = 0;
            int high = chars.length - 1;
            while (low < high) {
                char temp = chars[high];
                chars[high] = chars[low];
                chars[low] = temp;
                low++;
                high--;
            }
            String value = String.valueOf(chars);
            sb.append(value+" ");
        }
        return sb.substring(0,sb.length()-1);
    }

    public static void main(String[] args) {
        char[] s = new char[]{'H', 'e', 'l', 'l', 'o'};
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }
}
