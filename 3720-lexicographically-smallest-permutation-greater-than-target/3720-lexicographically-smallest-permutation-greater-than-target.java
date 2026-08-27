class Solution {
    public int upper(int ind,int freq[]){
        
        int ans=26;
        for(int i=0;i<26;i++){
            if(i>ind && freq[i]>0)return i;
        }
        return ans;
    }
    public String lexGreaterPermutation(String s, String target) {

        int n=s.length();
        int m=target.length();
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        String prefix="";
        List<String> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            char ch=target.charAt(i);
            int ind=upper(ch-'a',freq);
            
            if(ind!=26){
                char val=(char)(ind+'a');
                String temp=prefix;
                temp+=val;
                freq[val-'a']--;
                for(int j=0;j<26;j++){
                    if(freq[j]>0){
                        int t=freq[j];
                        while(t-->0)temp+=(char)(j+'a');
                    }
                }
                freq[val-'a']++;
                ans.add(temp);
            }
            boolean nxt=freq[ch-'a']>0?true:false;
            if(nxt==false)break;
            prefix+=ch;
            freq[ch-'a']--;
        }
        if(ans.size()==0)return "";
        Collections.sort(ans);
        return ans.get(0);
        
    }
}