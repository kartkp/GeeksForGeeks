class Solution {
    static int swapNibbles(int n) {
      int rn = (n & 0xF0) >> 4; 
        int ln = (n & 0x0F) << 4; 
        return rn | ln;
    }
}
