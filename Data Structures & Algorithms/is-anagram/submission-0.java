class Solution {
    public boolean isAnagram(String s, String t) {
        var counter = new int[26];

        for (var c: s.toCharArray()) counter[c-'a'] += 1;
        for (var c: t.toCharArray()) {
            counter[c-'a'] -= 1;
            if (counter[c-'a'] < 0) return false;
        }

        var sum = 0;
        for (var c: counter)
            if (c != 0) return false;
        return true;
    }
}
