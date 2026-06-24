class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp=0;
        int rev=x;
        while(x>0){
            int d = x%10;
            temp=temp*10+d;
            x/=10;
        }
        return (temp==rev);
    }
}