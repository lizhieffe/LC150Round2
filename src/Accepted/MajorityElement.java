package Accepted;

public class MajorityElement {

	 public int majorityElement(int[] num) {
	        if (num == null || num.length == 0)
	            return -1;
	        int last = num[0];
	        int count = 1;
	        for (int i = 1; i < num.length; ++i) {
	            if (num[i] == last)
	                ++count;
	            else {
	                if (count == 1)
	                    last = num[i];
	                else
	                    --count;
	            }
	        }
	        return last;
	    }
}
