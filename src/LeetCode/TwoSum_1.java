package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum_1
 * @Author xy
 * @Date 2019/4/89:55
 * @Version 1.0
 */
public class TwoSum_1 {
    //暴力破解版
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //使用hash table
    public int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
