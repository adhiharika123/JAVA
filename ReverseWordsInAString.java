class Solution {
    public String reverseWords(String s) {
        //Bruteorce approch
        /*
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
        */


        //Optimal Approch
        int left = 0;
        int right = s.length() -1;

        while(left <= right && s.charAt(left) == ' ') left++;
        while(left <= right && s.charAt(right) == ' ') right--;
        String temp = "";
        String ans = "";
        while(left <= right){
            char ch = s.charAt(left);
            if(ch != ' '){
                temp += ch;
            }
            else if(ch == ' '){
                if(!temp.equals("")){
                    if(!ans.equals("")){
                        ans = temp + " " + ans;
                    }
                    else{
                        ans = temp;
                    }
                    temp = "";
                }   
            }
            left++;
        }
      //To add the last word
        if(!temp.equals("")){
            if(!ans.equals("")){
                ans = temp + " " + ans;
            }
            else{
                ans = temp;
            }
        }
        return ans;
    }
}
