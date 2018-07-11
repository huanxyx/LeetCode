package com.xyx.leetcode.solution;

//House Robber II
public class Solution213 {

    public int rob(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	if (nums.length == 1)
    		return nums[0];
    	
        
        return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));
    }
    
    /*
     * 根据不同偷窃范围确定最优解：
     * 	1...length-1：表示第一家不偷
     * 	0...length-2：表示最后一家不偷
     */
    public static int robber(int[] nums, int low, int hig) {
    	int preRob = 0;							
    	int preNotRob = 0;
    	int rob = 0;
    	int notRob = 0;
    	
    	for (int i = low; i <= hig; i++) {
    		rob = preNotRob + nums[i];					//当前房子被盗窃
    		notRob = Math.max(preRob, preNotRob);		//当前房子不被盗窃
    		preNotRob = notRob;							//前一个房子不被盗窃
    		preRob = rob;								//前一个房子被盗窃
    	}
    	return Math.max(rob, notRob);
    }
}
