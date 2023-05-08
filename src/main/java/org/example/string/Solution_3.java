package org.example.string;

import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
    /**
     * 核心思路
     * 1. 定义start,end两个指针, 通过移动指针的方式，计算指针间的距离，确定最大长度
     * 2. 定一个一个map, 移动end指针，移动过程中, 遇到的字符需要存储的map里面
     * 3. 没有重复的情况下，将字符放到map里面，最大长度就是end-start+1;
     * 4. 遇到重复的情况下， start 的位置需要调整，调整方式是Math.max(当前重复字符的下一个位置, 当前start的位置)
     * 5. start的位置需要和之前的start做比较，取最大的值,例如字符串"abbac"的case
     * 6. 最长长度要和上一次的长度坐比较，取最大的值， 例如字符串"abb"的case
     * ｜字符串｜start｜end｜ 最大长度｜
     * ｜ abc ｜  0  ｜ 2 ｜   3    ｜
     * ｜ aba ｜  1  ｜ 2 ｜   2    ｜
     * ｜ abb ｜  0  ｜ 1 ｜   2    ｜ ps: b出现重复了，但是重复时候，start = 2,end =2,长度=1，小于之前的长度。因此需要比较长度
     * ｜abba ｜  0  ｜ 1 ｜   2    ｜ ps: 此处移动指针，会遇到b,a重复的情况，遇到b重复时候，start = 2,end =2 ,长度=0
     *                                   继续遇到a重复，这个时候当前start 大于 当前重复字符的下一个位置，因此不能调整，否则长度计算就异常了
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char p = s.charAt(end);
            if (map.containsKey(p)) {
                start = Math.max(map.get(p) + 1, start);
            }
            map.put(p, end);
            ans = Math.max(end - start + 1, ans);
        }
        return ans;
    }
}
