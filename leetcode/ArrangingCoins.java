class Solution {
    public int arrangeCoins(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int last = 0;
        int newN = n;
        for(int i = 1; i <= n; i++){
            if(i <= newN){
                last = i; 
                newN = newN - i; 
            }
            else{
                break;
            }
        }
        return last;
    }
}
