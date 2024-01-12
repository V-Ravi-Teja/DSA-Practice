/*
Problem Description
    You are given an array A of integers of size N.
    Your task is to find the equilibrium index of the given array
    The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
    If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
    Note:
    Array indexing starts from 0.
    If there is no equilibrium index then return -1.
    If there are more than one equilibrium indexes then return the minimum index.
Problem Constraints
    1 <= N <= 105
    -105 <= A[i] <= 105
Input Format
    First arugment is an array A .
Output Format
    Return the equilibrium index of the given array. If no such index is found then return -1.

Example Input
    Input 1:
    A = [-7, 1, 5, 2, -4, 3, 0]
    Input 2:
    A = [1, 2, 3]

Example Output
    Output 1:
    3
    Output 2:
    -1

Example Explanation
    Explanation 1:
        i   Sum of elements at lower indexes    Sum of elements at higher indexes
        0                   0                                   7
        1                  -7                                   6
        2                  -6                                   1
        3                  -1                                  -1
        4                   1                                   3
        5                  -3                                   0
        6                   0                                   0

        3 is an equilibrium index, because:
        A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

    Explanation 1:
        i   Sum of elements at lower indexes    Sum of elements at higher indexes
        0                   0                                   5
        1                   1                                   3
        2                   3                                   0
        Thus, there is no such index.
*/
public class BalancedArray {
    public int solve(ArrayList<Integer> A) {
        /*
         maintain 1 prefix sum and 1 suffix sum
         [1,2,2,3]--prefixSum=[0,1,3,5]--suffixSum=[7,5,3,0]
         [-7, 1, 5, 2, -4, 3, 0] --
         prefixSum = [0, -7, -6, -1, 1, -3, 0] --
         suffixSum = [7, 6, 1, -1, 3, 0, 0]
        */
        int answer = 99999;
        int n = A.size();
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        // calculating prefix sum array
        prefixSum[0] = 0;
        for(int i = 1; i < n; i++){
        prefixSum[i] = prefixSum[i-1] + A.get(i-1);
        }
        // calculating suffix sum array
        suffixSum[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
        suffixSum[i] = suffixSum[i+1] + A.get(i+1);
        }
        // checking for each element and noting smallest answer
        for(int i = 0; i < n; i++){
        if(prefixSum[i] == suffixSum[i]){
        if(i < answer) answer = i;
        }
        }
        if(answer == 99999) return -1;
        else return answer;
        }
}