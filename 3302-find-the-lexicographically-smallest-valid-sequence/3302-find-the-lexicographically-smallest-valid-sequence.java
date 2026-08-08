class Solution {
    public int[] validSequence(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int [] indices=new int [m];
        int [] ans=new int [n];
        int i=m-1;
        int j=n-1;
        int num=0;
        int repeatOrder=0;
        while(i>=0 && j>=0){
            if(word1.charAt(i)==word2.charAt(j)){
                num++;
                indices[i]=num;
                i--;
                j--;
            }
            else{
                indices[i]=num;
                i--;
            }
        }
        while(i>=0){
            indices[i]=num;
            i--;
        }

        i=0;
        j=0;
        boolean flag=true;
        while(i<m && j<n){
            if(word1.charAt(i)==word2.charAt(j)){
                ans[j]=i;
                i++;
                j++;
            }
            else if(word1.charAt(i)!=word2.charAt(j) && (flag && (i<m-1 && indices[i+1]>=(n-j-1)))) {
                ans[j]=i;
                i++;
                j++;
                flag=false;
            }
            else{
                i++;
            }
        }
        if(j<n){
            int [] arr={};
            return arr;
        }
        return ans;

    }
}