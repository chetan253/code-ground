class Solution {
    public boolean wordPattern(String pattern, String str) {
        String arr[] = str.split(" ");
        HashMap<Character, String> mapper = new HashMap<Character, String>();
        if(arr.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(!mapper.containsKey(ch) && !mapper.containsValue(arr[i])){
                mapper.put(ch, arr[i]);
            }
        }
        StringBuilder st = new StringBuilder();
        for(char ch : pattern.toCharArray()){
            st.append(mapper.get(ch));
            st.append(" ");
        }
        return str.equals(st.toString().trim());
    }
}
