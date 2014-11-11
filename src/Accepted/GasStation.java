package Accepted;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        return findStartingPoint(gas, cost, 0);
    }
    
    private int findStartingPoint(int[] gas, int[] cost, int tmpBeg) {
        int sum = 0;
        boolean justStarted = true;
        int i = tmpBeg;
        while (i != tmpBeg || justStarted) {
            justStarted = false;
            sum += gas[i] - cost[i];
            if (sum < 0) {
                if (findNextId(i, gas.length) <= tmpBeg)
                    return -1;
                return findStartingPoint(gas, cost, findNextId(i, gas.length));
            }
            i = findNextId(i, gas.length);
        }
        return tmpBeg;
    }
    
    private int findNextId(int i, int n) {
        if (i == n - 1)
            return 0;
        else
            return i + 1;
    }
}
