class Solution {
    public String reverseWords(String s) {
        s += " ";
        Stack<String> st = new Stack<String>();
        String str = "";
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' '){
                if (!str.equals("")) { 
                    st.push(str);
                    str="";
                }
            }
            else{
                str += s.charAt(i);
            }
        }
        String ans = "";
        while(st.size() != 1){
            ans += st.peek() + " ";
            st.pop();
        }
        ans += st.peek();
        return ans;
    }
}
