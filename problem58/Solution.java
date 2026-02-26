package problem58;

public class Solution {
//    public static int lengthOfLastWord(String s) {
//        for (int i = s.length() - 1; i >= 0 ;i--) {
//            if (s.charAt(i) != ' ') {
//                int count = 1;
//                for (int j = i - 1; j >= 0; j--) {
//                    if (s.charAt(j) == ' ') break;
//                    count++;
//                }
//                return count;
//            }
//        }
//
//        return 0;
//    }
    public static int lengthOfLastWord(String s) {
        String [] myString = s.split(" ");
        return myString[myString.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int lengthOfLastWord = Solution.lengthOfLastWord(s);
        System.out.println(lengthOfLastWord);
    }

}
