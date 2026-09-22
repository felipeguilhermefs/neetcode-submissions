// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        mergesort(pairs, 0, pairs.size()-1);
        return pairs;
    }

    private void mergesort(List<Pair> arr, int start, int end) {
        if (end - start + 1  <= 1) return;

        int middle = (start + end) / 2;
        mergesort(arr, start, middle);
        mergesort(arr, middle+1, end);

        merge(arr, start, middle, end);
    }

    private void merge(List<Pair> arr, int start, int middle, int end) {
        var left = new ArrayList<>(arr.subList(start, middle+1));
        var right = new ArrayList<>(arr.subList(middle+1, end+1));

        int l = 0;
        int r = 0;
        int i = start;
        while (l < left.size() && r < right.size()) {
            if(left.get(l).key <= right.get(r).key) {
                arr.set(i, left.get(l));
                l++;
            } else {
                arr.set(i, right.get(r));
                r++;
            }
            i++;
        }

        while (l < left.size()) {
            arr.set(i, left.get(l));
            l++;
            i++;
        }


        while (r < right.size()) {
            arr.set(i, right.get(r));
            r++;
            i++;
        }
    }
}