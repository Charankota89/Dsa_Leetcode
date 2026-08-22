class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int digiSum = 0;
        int digiProduct = 1;

        while (n > 0) {
            int digit = n % 10;
            digiSum += digit;
            digiProduct *= digit;
            n /= 10;
        }

        int divisor = digiSum + digiProduct;
        return original % divisor == 0;
    }
}