class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        while (low <= high) {
            int mid = (high+low)/2;

            if (isOk(piles, mid, h)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    private boolean isOk(int[] piles, int rate, int hours) {
        int total = 0;
        // for (int pile: piles) total += (pile/rate + pile%rate);
        for (int pile: piles) total += Math.ceil((double) pile/rate);
        return total <= hours;
    }

    private int max(int[] piles) {
        int largest = 0;
        for (int i=0; i<piles.length; i++) {
            if (piles[i] > largest) {
                largest = piles[i];
            } 
        }
        return largest;
    }
}
