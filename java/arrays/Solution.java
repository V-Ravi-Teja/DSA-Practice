public class Solution {
    public int solve(String A) {
        //initial thought after checking contraints need O(n)
        // take two pointers note difference 
        int x = -1, o = -1, diff = -1, i = 0;
        while(i < A.length()){
            if(A.charAt(i) == 'x'){
                x = i;
            }
            if(A.charAt(i) == 'o'){
                o = i;
            }
            if(o == 3){
                System.out.println("running");
            }
            if(x > -1 && o > -1){
                if(Math.abs(x - o) < diff){
                    diff = Math.abs(x-o);
                }
            }
            i++;
        }
        return diff;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int ans = sol.solve("x..o");
        System.out.println(ans);
    }
}
