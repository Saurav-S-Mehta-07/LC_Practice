package Amazon_Medium;

import java.util.*;

public class GroupAnagram {
    public static void groupAnagram(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = new String(strArr);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        groupAnagram(strs);
    }
}
