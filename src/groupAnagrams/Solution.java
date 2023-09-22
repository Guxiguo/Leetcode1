package groupAnagrams;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<strs.length;i++ ){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            if(map.containsKey(Arrays.toString(str))) {
                List<String> list = map.get(Arrays.toString(str));
                list.add(strs[i]);
                map.put(Arrays.toString(str),list);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(Arrays.toString(str), list);
            }

        }
        List<List<String>> list1 = new ArrayList<>();
        for(List<String> list:map.values()){
            list1.add(list);
        }
        return list1;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }
}
