class Solution {
    ArrayList<String> ptharr;
    public void genParanthesis(int ctr_open, int ctr_close, String str){
        if(ctr_open > ctr_close)
            return;
        else if(ctr_open == 0 && ctr_close == 0){
            ptharr.add(str);
            return;
        }
        else if(ctr_open == 0 && ctr_close > 0){
            genParanthesis(ctr_open, ctr_close-1, str+")");
        }
        else if(ctr_open == ctr_close)
            genParanthesis(ctr_open-1, ctr_close, str+"(");
        else{
            genParanthesis(ctr_open-1, ctr_close, str+"(");
            genParanthesis(ctr_open, ctr_close-1, str+")");
        }
    }
    
    public List<String> generateParenthesis(int n) {
        ptharr = new ArrayList<String>();
        if(n == 0)
            ptharr.add("");
        else if(n > 0)
            genParanthesis(n-1,n,"(");
        
        return ptharr;
    }
}
