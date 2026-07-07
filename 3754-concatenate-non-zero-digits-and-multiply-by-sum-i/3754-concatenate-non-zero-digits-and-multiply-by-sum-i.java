class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long count=0;
        long point=1;
        while(n>0){
            long x=n%10;
            sum+=x;
            if(x>0){
                count = count +x*point;
                point *=10;
            }
            n=n/10;
        }
        return  count * sum;
    }
}