class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n  = nums.length;
        int i = 0;
        int j = 0;
        int minL = Integer.MAX_VALUE;
        int sum = 0;
       while ( j < n ){
           sum += nums[j];
           //chota kr rhe h window ko
           while ( sum >= target){
               minL = Math.min(minL,j - i +1);
               sum -= nums[i];
                i++;
           }
           j++;
       }
    return minL == Integer.MAX_VALUE ? 0 : minL;
    }
}