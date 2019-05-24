class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        for (char c : ransomNote.toCharArray()) {
            int newCount = map.containsKey(c) ? map.get(c) - 1 : -1;
            if (newCount == -1) return false;
            map.put(c, newCount);
        }
        return true;
    }
}
