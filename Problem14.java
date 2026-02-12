import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        Set<String> prefixes = getPrefix(strs);

        if (strs.length == 1)
            return strs[0];

        Map<String, Integer> countingPrefix = new HashMap<>();
        for (String prefix : prefixes) {
            int count = 0;
            for (String str : strs) {
                if (str.startsWith(prefix))
                    count++;
            }
            countingPrefix.put(prefix, count);
        }

        // finding the max prefix
        int maxPrefix = 0;
        String resultPrefix = "";
        for (String prefix : prefixes) {
            if (maxPrefix < countingPrefix.get(prefix)) {
                maxPrefix = countingPrefix.get(prefix);
                resultPrefix = prefix;
            }
        }

        if (maxPrefix == 1)
            return "";

        return resultPrefix;
    }

    public Set<String> getPrefix(String[] strs) {
        Set<String> prefixes = new HashSet<>();
        for (String str : strs) {
            String prefix = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'
                        || str.charAt(i) == 'e') {
                    if (prefix.length() == 0)
                        prefix += str.charAt(i);
                    break;

                }

                prefix += str.charAt(i);
            }
            prefixes.add(prefix);

        }
        return prefixes;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        Problem14 problem14 = new Problem14();
        System.out.println(problem14.longestCommonPrefix(strs));
        ;
    }
}
