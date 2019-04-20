class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordDict = new HashSet<String>();
        wordList.forEach(word -> wordDict.add(word));
        if(!wordDict.contains(endWord)){
            return 0;
        }

        Queue<String> q = new ArrayDeque<String>();
        int res = 1;
        q.offer(beginWord);
        while(!q.isEmpty()){
            for(int j = q.size(); j > 0; j--){
                String s = q.poll();
                if(s.equals(endWord)){
                    return res;
                }
                for(int i = 0; i < s.length(); i++){
                    char[] chArr = s.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        chArr[i] = ch;
                        String temp = new String(chArr);
                        if(wordDict.contains(temp)){
                            q.offer(temp);
                            wordDict.remove(temp);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
