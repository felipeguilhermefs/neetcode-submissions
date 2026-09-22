// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quicksort(pairs, 0, pairs.size()-1);
        return pairs;
    }

    private void quicksort(List<Pair> arr, int low, int high) {
        if (high - low + 1 <= 1) return;

        var pivot = arr.get(high);
        var left = low;

        for (int i = low; i<high; i++) {
            if (arr.get(i).key < pivot.key) {
                var tmp = arr.get(i);
                arr.set(i, arr.get(left));
                arr.set(left, tmp);
                left++;
            }
        }

        arr.set(high, arr.get(left));
        arr.set(left, pivot);

        quicksort(arr, low, left-1);
        quicksort(arr, left+1, high);
    }
}
