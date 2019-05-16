class Solution {
    public List<String> letterCombinations(String digits) {
        String[] nums = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new LinkedList<String>();
        if(digits.length() == 0){
            return ans;
        }
        ans.add("");
        while(ans.get(0).length() != digits.length()){
            String temp = ans.remove(0);
            String map = nums[digits.charAt(temp.length())-'0'];
		for(char c: map.toCharArray()){
			ans.add(temp+c);
		}
        }
        return ans;
    }
}
