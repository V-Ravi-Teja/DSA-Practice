public class productOfArrayExceptSelf {
/* Problem
    https://leetcode.com/problems/product-of-array-except-self/description/
    
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]
 
Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    // brute force loop once get total product then loop again to divide by each element to get answer
    // but question O(n) without division
    // a*b = a + a..(b times)
    // my next thought prefix sum doesn't need to be sum it can be product 
    // i'll create two arrays prefix product and suffix product
    // [1,2,3] --pf = [1,1,2]--sf = [6,3,1]
    int[] prefixProductArray = new int[n];
    int[] suffixProductArray = new int[n];

    for(int i = 0; i < n; i++){
       if(i==0){
            prefixProductArray[0] = 1;
       }else{
            prefixProductArray[i] = prefixProductArray[i-1]*nums[i-1];
       } 
    }

    for(int i = n-1; i >= 0; i--){
        if(i==n-1){
            suffixProductArray[i] = 1;
        }else{
            suffixProductArray[i] = suffixProductArray[i+1]*nums[i+1];
        }
    }

    for(int i = 0; i < n; i++){
        answer[i] = prefixProductArray[i]*suffixProductArray[i];
    }

    return answer;
    /*
        OPTIMIZED SOLUTION PREFIX AND SUFFIX IN SAME ARRAY-1ST DO PREFIX THEN DO SUFFIX
        class Solution {
            public int[] productExceptSelf(int[] nums) {
                int n = nums.length;
                int ans[] = new int[n];
                Arrays.fill(ans, 1);
                int curr = 1;
                for(int i = 0; i < n; i++) {
                    ans[i] *= curr;
                    curr *= nums[i];
                }
                curr = 1;
                for(int i = n - 1; i >= 0; i--) {
                    ans[i] *= curr;
                    curr *= nums[i];
                }
                return ans;
        }
}
     */
}
}
