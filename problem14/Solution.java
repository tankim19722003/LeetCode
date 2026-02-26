package problem14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        String commonPrefix = "";
        int end = (strs[0].length() < strs[1].length()) ? strs[0].length() : strs[1].length();
        String firstStr = strs[0];
        String secondStr = strs[1];
        for (int j = 0; j < end; j++) {
            if (firstStr.charAt(j) == secondStr.charAt(j))
                commonPrefix += secondStr.charAt(j);
            else
                break;
        }

        if (commonPrefix == "")
            return "";

        for (int i = 2; i < strs.length; i = i + 1) {
            int endLength = (strs[i].length() < commonPrefix.length()) ? strs[i].length() : commonPrefix.length();
            firstStr = strs[i];
            String newPrefix = "";
            for (int j = 0; j < endLength; j++) {
                if (firstStr.charAt(j) == commonPrefix.charAt(j))
                    newPrefix += secondStr.charAt(j);
                else
                    break;
            }
            if (newPrefix.isEmpty())
                return "";
            commonPrefix = newPrefix;
        }
        return commonPrefix;

    }

    public static void main(String[] args) {
        String[] strs = { "baab", "bacb", "b", "cbc" };
        Solution problem14 = new Solution();
        System.out.println(problem14.longestCommonPrefix(strs));
    }
}
