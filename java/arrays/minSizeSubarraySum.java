public class minSizeSubarraySum {
    /*
        https://leetcode.com/problems/minimum-size-subarray-sum/description/

        Q) Given an array of positive integers nums and a positive integer target, return the minimal length of a
        Subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

        Example 1:`
        `Input: target = 7, nums = [2,3,1,2,4,3]`
        `Output: 2`
        `Explanation: The subarray [4,3] has the minimal length under the problem constraint.`

        `Example 2:`
        `Input: target = 4, nums = [1,4,4]`
        `Output: 1`

        `Example 3:`
        `Input: target = 11, nums = [1,1,1,1,1,1,1,1]`
        `Output: 0`

        `Constraints:`
        `1 <= target <= 109`
        `1 <= nums.length <= 105`
        `1 <= nums[i] <= 104`
     */
    //  My-Solution)(Accepted)
        public int minSubArrayLen(int target, int[] nums) {
            int answer = Integer.MAX_VALUE;
            //calculating prefix sum array
            for(int i = 0; i < nums.length; i++){
                if(nums[i]>=target) return 1;
                if(i==0){
                    continue;
                }else
                    nums[i] = nums[i-1] + nums[i];
            }
            // checking for answer
            int L = 0;
            int R = 1;
            while(L <= R && R < nums.length){
            // if nums[R] - nums[L-1] >= target -- add to answer, L++
            // if nums[R] - nums[L-1] < target -- R++
                if(L==0){
                    if(nums[R]>=target){
                        answer = Math.min(R+1,answer);
                        L++;
                    }else{
                        R++;
                    }
                }else{
                    if(nums[R] - nums[L-1] >= target){
                        answer = Math.min((R-L+1),answer);
                        L++;
                    }else{
                        R++;
                    }
                }
            }
            return answer == Integer.MAX_VALUE ? 0 : answer;
        }
        /*   
        OPTIMIZED SOLUTION IN DISCUSSION
            public int minSubArrayLen(int target, int[] nums) {
                int n = nums.length;
                int left = 0;
                int right = 0;
                int sum = 0;
                int answer = n+1;
                while (right < n) {
                    sum += nums[right++];
                    while (sum >= target && left<right) {
                        if (answer > (right-left)) {
                            answer = right-left;
                        }
                        sum -= nums[left++];
                    }
                }
                return answer == n+1 ? 0 : answer;
            }
        
        */
}
