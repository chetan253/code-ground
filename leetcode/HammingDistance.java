class Solution {
    public int hammingDistance(int x, int y) {
        int xorOp = x ^ y;
        int changedBits = 0;
        
        while(xorOp > 0){
            changedBits += xorOp & 1;
            xorOp = xorOp>>1;
        }
        
        return changedBits;
    }
}
