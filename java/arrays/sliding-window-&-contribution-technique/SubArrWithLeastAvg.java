class SubArrWithLeastAvg{
        /*
        Problem Description
    Given an array A of size N, find the subarray of size B with the least average.



    Problem Constraints
    1 <= B <= N <= 105
    -105 <= A[i] <= 105


    Input Format
    First argument contains an array A of integers of size N.
    Second argument contains integer B.


    Output Format
    Return the index of the first element of the subarray of size B that has least average.
    Array indexing starts from 0.


    Example Input
    Input 1:
    A = [3, 7, 90, 20, 10, 50, 40]
    B = 3
    Input 2:

    A = [3, 7, 5, 20, -10, 0, 12]
    B = 2


    Example Output
    Output 1:
    3
    Output 2:

    4


    Example Explanation
    Explanation 1:
    Subarray between indexes 3 and 5
    The subarray {20, 10, 50} has the least average
    among all subarrays of size 3.
    Explanation 2:

     Subarray between [4, 5] has minimum average
        */
    public int solve(ArrayList<Integer> A, int B) {
        // solution need to be O(n)
        // we need min of subArr and we know window size so use sliding window
        int start = 0;
        int end = B-1;
        int sum = 0;
        int answer = 0;
        for(int i = start; i <= end; i++){
            sum += A.get(i);
        }
        float minAvg = (float)sum/B;
        while(end < A.size()-1){
            sum = sum - A.get(start);
            start++;
            end++;
            sum = sum + A.get(end);
            if((float)sum/B < minAvg){
                minAvg = (float)sum/B;
                answer = start;
            }
        }
        return answer;
    }
}