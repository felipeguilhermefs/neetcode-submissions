class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var res = new HashMap<String, List<String>>();

        for (var str: strs) 
            res.computeIfAbsent(id(str), k -> new ArrayList<>())
               .add(str);

        return new ArrayList<>(res.values());
    }

    private String id(String str) {
        var counter = new char[26];

        for (var c: str.toCharArray()) counter[c-'a'] += 1;

        return Arrays.toString(counter);
    }
}
