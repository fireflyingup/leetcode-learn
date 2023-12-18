package leetcode.editor.cn.string;

public class KMP {

    public static void main(String[] args) {
        System.out.println(indexOf("abcabcdeddabcabcf", "abcabcf"));
    }

    private static int indexOf(String source, String dict) {
        char[] sourceCharArray = source.toCharArray();
        char[] dictCharArray = dict.toCharArray();
        if (dictCharArray.length > sourceCharArray.length || sourceCharArray.length == 0) {
            return -1;
        }
        int[] next = getNext(dictCharArray);
        int j = 0;
        for (int i = 0; i < sourceCharArray.length; i++) {

        }
        return -1;
    }

    // abcabcfabc
    private static int[] getNext(char[] dict) {
        int j, k;
        j = 0;
        k = -1;
        int[] next = new int[dict.length];
        next[0] = -1; //k用来扫描对比前面几个元素是否与j扫描的元素相同
        while (j < dict.length - 1) {
            if (k == -1 || dict[j] == dict[k])//当k=-1的时候说明到头了，j该往前走了。
            {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];//想想这里为什么不是k=-1呢？因为k=-1是BF算法思想，而且如果这样的话j要回溯！
            }
        }
        return next;

    }
}
