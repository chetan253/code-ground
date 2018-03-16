class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(Character c : moves.toCharArray()){
            if(c == 'U')
                x--;
            else if(c == 'D')
                x++;
            else if(c == 'L')
                y--;
            else
                y++;
        }
        return x == y ? true : false;
    }
}
