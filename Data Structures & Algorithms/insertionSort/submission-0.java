// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        var result = new ArrayList<List<Pair>>(pairs.size());
        var mutPairs = new ArrayList<Pair>(pairs);
        for (int i = 0; i < mutPairs.size(); i++) {
            
            for (int j = i; j > 0; j--) {
                var cur = mutPairs.get(j);
                var prev = mutPairs.get(j-1);

                if (cur.key >= prev.key) break;

                mutPairs.set(j, prev);
                mutPairs.set(j-1, cur);
            }

            result.add(new ArrayList<>(mutPairs));
        }
        return result;
    }
}
