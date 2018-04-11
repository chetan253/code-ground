class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows <= 1)
            return s;
        
        ArrayList<Character> list[] = new ArrayList[numRows];
        boolean flag = false;
        for(int i = 0; i < numRows; i++){
            list[i] = new ArrayList<Character>();
        }
        for(int i = 0, j = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(j < 0){
                flag = true;
                j = j + 2;
            }
            else if(j >= numRows){
                flag = false;
                j = j - 2;
            }

            if(flag){
                list[j++].add(c);
            }
            else{
                list[j--].add(c);
            }
        }
        String str = "";
        for(int i = 0; i < numRows; i++){
            ArrayList<Character> arrList = list[i];
            for(char c : arrList){
                str += Character.toString(c);
            }
        }
        return str;
    }
}
