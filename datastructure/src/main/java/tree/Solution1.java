package tree;

import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("dvdf");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int bigsize = 0;
        int j = 0;
        for (int i = -1; i < s.length(); i++) {
           if(i>=0){
               Character c = s.charAt(i);
               set.remove(c);
           }
            while (j < s.length() ) {
                Character c1 = s.charAt(j);
                boolean contains = set.contains(c1);
                if (!contains) {
                    set.add(c1);
                    j++;
                    continue;
                } else {
                    break;
                }
            }
            bigsize = Math.max(bigsize,set.size());
        }

        return bigsize;
    }
}