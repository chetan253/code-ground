class Solution {
    
    public boolean isUpperCase(char c){
        if(c >= 65 && c <= 90)
            return true;
        return false;
    }
    
    public char convertToLowerCase(char c){
        int asciiVal = (int) c;
        int upperStart = 65;
        int difference = asciiVal - upperStart;
        
        int upperCharAscii = 97 + difference;
        
        return (char)upperCharAscii;
    }
    
    public String toLowerCase(String str) {
        int ptr1 = 0;
        int ptr2 = str.length() - 1;
        int ptr1InsertedChars = 0;
        
        StringBuilder builder = new StringBuilder();
        while(ptr1 < ptr2){
            char ptr1Char = str.charAt(ptr1);
            char ptr2Char = str.charAt(ptr2);
            
            if(isUpperCase(ptr1Char)){
                builder.insert(ptr1InsertedChars++, convertToLowerCase(ptr1Char));
            }
            else{
                builder.insert(ptr1InsertedChars++, ptr1Char);
            }
            int offset = ptr1InsertedChars;
            if(isUpperCase(ptr2Char)){
                builder.insert(offset, convertToLowerCase(ptr2Char));
            }
            else{
                builder.insert(offset, ptr2Char);
            }
            ptr1++;
            ptr2--;
        }
        
        if(str.length() % 2 != 0){
            if(isUpperCase(str.charAt(ptr1))){
                builder.insert(ptr1InsertedChars, convertToLowerCase(str.charAt(ptr1)));
            }
            else{
                builder.insert(ptr1InsertedChars, str.charAt(ptr1));
            }
        }
        
        return builder.toString();
    }
}
