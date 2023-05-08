package org.example.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * <p>
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class Solution_1 {

    //O(n2)
    //用当前下标的数字和后边每一个数字进行相加比较，如果等于target 就符合条件。
    public int[] twoSum_n2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    //O(2N)
    //第一次遍历，把所有数字写入map中，数字重复无所谓，覆盖下标即可
    //第二次遍历，判断map中是否存在s=target-nums[i] 的数字，有的话对应的下标组合就是i,map.get(s); ps i != map.get(s), 否则表示的是同一个下标用了2次。
    public int[] twoSum_2n(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 相同数字 位置覆盖即可
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];
            if (map.containsKey(s) && map.get(s) != i) {
                res[1] = map.get(s);
                res[0] = i;
            }
        }
        return res;
    }

    //O(N)
    // 首先利用map存储， key: 当前下标缺失的数字为key（target - nums[i]）, value：当前下标
    // 接着判断当前下标的数字 是否符合之前遍历过得数据中的缺失数字。 符合的话，即返回 i,map.get(nums[i])
    public int[] twoSumWith_n(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
        }
        return res;
    }
}
