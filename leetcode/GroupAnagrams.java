class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans = new HashMap();
        
        for(String str : strs){
            char[] chars = str.toCharArray();
            
            Arrays.sort(chars);
            String key = new String(chars);
            
            if(ans.containsKey(key)){
                ans.get(key).add(str);
            }
            else{
                ArrayList<String> temp = new ArrayList();
                temp.add(str);
                ans.put(key, temp);
            }
        }
        
        List<List<String>> ansList = new ArrayList();
        for(Map.Entry<String, List<String>> entry : ans.entrySet()){
            ansList.add(entry.getValue());
        }
        
        return ansList;
    }
}
