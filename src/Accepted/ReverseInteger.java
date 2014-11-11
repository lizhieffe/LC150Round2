package Accepted;

public class ReverseInteger {

	public int reverse(int x) {
        int result = 0;
        while (Math.abs(x) > 0) {
            result = result * 10 + (x % 10);
            System.out.println(result);
            x /= 10;
            System.out.println(x);
        }
        return result;
    }
	
	
	public static void main(String[] args) {
		int a = -123;
		System.out.println(new ReverseInteger().reverse(a));
	}
}
