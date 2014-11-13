package Accepted;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
    	long a = dividend;
    	long b = divisor;
    	a = Math.abs(a);
    	b = Math.abs(b);
        int result = dividePositive(a,b);
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return result;
        else return (~result) + 1;
    }
    
    private int dividePositive(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        if (dividend == divisor)
            return 1;
        int count = 0;
        long tmp = divisor;
        while (tmp < dividend) {
            tmp = tmp << 1;
            count++;
        }
        return (1 << (count - 1)) + (int)dividePositive(dividend - (tmp >> 1), divisor);
    }
    
    public static void main(String[] args) {
    	int dividend = -1010369383;
    	int divisor = -2147483648;
    	System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }
}
