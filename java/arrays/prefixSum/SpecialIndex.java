public class SpecialIndex{
    /*
    Problem Description
        Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

    Problem Constraints
        1 <= N <= 105
        -105 <= A[i] <= 105
        Sum of all elements of A <= 109

    Input Format
        First argument contains an array A of integers of size N
    Output Format
        Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

    Example Input
        Input 1:
        A = [2, 1, 6, 4]
        Input 2:
        A = [1, 1, 1]

    Example Output
        Output 1:
        1
        Output 2:
        3

    Example Explanation
        Explanation 1:
            Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
            Therefore, the required output is 1.
        Explanation 2:
            Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
            Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
            Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
            Therefore, the required output is 3.
    */
    public int solve(ArrayList<Integer> A) {
        // leftOdd + rightEven = rightOdd + leftEven
        // 2 1 6 4 => 2 6 4
        // 1. get pf-odd
        int count = 0;
        int n = A.size();
        ArrayList<Integer> pfOdd = new ArrayList<Integer>();
        pfOdd.add(0);
        for(int i = 1; i < n; i++){
            if(i%2==0){
                pfOdd.add(pfOdd.get(i-1));
            }else{
                pfOdd.add(pfOdd.get(i-1) + A.get(i));
            }
        }
        // 2. get pf-even
        ArrayList<Integer> pfEven = new ArrayList<Integer>();
        pfEven.add(A.get(0));
        for(int i = 1; i < n; i++){
            if(i%2==0){
                pfEven.add(pfEven.get(i-1) + A.get(i));
            }else{
                pfEven.add(pfEven.get(i-1));
            }
        }
        // 3. solution logic - check for each element
        int odd = 0, even = 0;
        for(int i = 0; i < n; i++){
            // logic
            // odd == even
            // edge case if i = 0 pf(n-1) => pf(n) =>out of bounds
            if(i==0){
                odd = pfEven.get(n-1) - pfEven.get(0);
                even = pfOdd.get(n-1);
            }else{
                odd = pfOdd.get(i-1) + (pfEven.get(n-1) - pfEven.get(i));
                even = pfEven.get(i-1) + (pfOdd.get(n-1) - pfOdd.get(i));
            }
            if(odd == even){
                count++;
            }
        }
        return count;
    }
}