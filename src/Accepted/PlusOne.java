package Accepted;

public class PlusOne {

	public int[] plusOne(int[] digits) {
        int[] result = null;
        if (digits == null || digits.length == 0) {
            result = new int[1];
            result[0] = 1;
            return result;
        }
        result = new int[digits.length];
        int modifier = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = modifier + digits[i];
            if (i == digits.length - 1)
                value += 1;
            result[i] = value % 10;
            modifier = value / 10;
        }
        if (modifier == 1) {
            int[] tmp = result;
            result = new int[digits.length + 1];
            System.arraycopy(tmp, 0, result, 1, tmp.length);
            result[0] = 1;
        }
        return result;
    }
}
