class MINIMUM_SWAPS{
        /*
        Problem Description

    Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

    Note: It is possible to swap any two elements, not necessarily consecutive.



    Problem Constraints

    1 <= length of the array <= 100000
    -109 <= A[i], B <= 109



    Input Format

    The first argument given is the integer array A.
    The second argument given is the integer B.



    Output Format

    Return the minimum number of swaps.



    Example Input

    Input 1:

     A = [1, 12, 10, 3, 14, 10, 5]
     B = 8
    Input 2:

     A = [5, 17, 100, 11]
     B = 20


    Example Output

    Output 1:

     2
    Output 2:

     1


    Example Explanation

    Explanation 1:

     A = [1, 12, 10, 3, 14, 10, 5]
     After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
     After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
     Now, all elements less than or equal to 8 are together.
    Explanation 2:

     A = [5, 17, 100, 11]
     After swapping 100 and 11, A => [5, 17, 11, 100].
     Now, all elements less than or equal to 20 are together.
        */
    public int solve(ArrayList<Integer> A, int B) {
        // <<WRONG>> 1st thought
        //      - from test case pattern observation
        //      - max count of elements > B huddled together
        //      - above is wrong [1,2,3,4] ; B = 3--> answer is 0 here but above logic gives 2
        // <<WRONG>> 2nd thought
        //      - find max distance between 2 elements < B
        //      - [1,2,3,4,2] ; B = 3 wrong above approach
        // <<WRONG>> 3rd thought
        //      - huddleCountMax ; huddleCount ; looseCount
        //      - if ele <= B looseCount++ ; huddleCount++;
        //      - huddleCountMax = max(huddleCountMax,huddleCount);
        //      - else looseCount+=huddleCount ; huddleCount = 0;
        //      - [1,2,3,4,2];B=3 -> huddleCountMax = 2 huddleCount=1 looseCount=2
        //      - we need to update looseCount only when loose elements or huddle < maxHuddle
        //      - too complex
        // <<CORRECT>> used hint 1 fix window size to count of ele<=B ans use sliding window
        int window = 0;
        for(int i = 0; i < A.size(); i++){ // finding window size
            if(A.get(i) <= B) window++;
        }
        int answer = 0;
        int swapCount = 0;
        int start = 0;
        int end = window-1;
        for(int i = start; i <= end; i++){ // checking first window
            if(A.get(i)>B) swapCount++;
        }
        answer = swapCount;
        while(end < A.size()-1){ // moving window and checking min swaps required
            if(A.get(start)>B) swapCount--;
            start++;
            end++;
            if(A.get(end)>B){
                swapCount++;
            }
            // for(int i = start; i <= end; i++){ // TLE bcuz O(n^2)
            //     if(A.get(i)>B) swapCount++;
            // }

            answer = Math.min(answer,swapCount);
            // swapCount = 0;
        }
        return answer;
    }
}