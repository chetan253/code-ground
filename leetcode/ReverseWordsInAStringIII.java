class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(String st : str){
            StringBuffer buffer = new StringBuffer(st);
            builder.append(buffer.reverse().toString() + " ");
        }
        
        builder.deleteCharAt(builder.length() - 1);
        
        return builder.toString();
    }
}
