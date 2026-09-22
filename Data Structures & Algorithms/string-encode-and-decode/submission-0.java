class Solution {
    private static final char DELIMITER = ':';

    public String encode(List<String> strs) {
        var encoded = new StringBuilder();
        for (var str : strs) {
            encoded.append(str.length())
                         .append(DELIMITER)
                         .append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        var res = new ArrayList<String>();
        var i = 0;
        while (i < str.length()) {
            var j = i;
            while (str.charAt(j) != DELIMITER) j++;

            var length = Integer.valueOf(str.substring(i, j));
            i = j + length + 1;
            res.add(str.substring(j + 1, i));
        }
        return res;
    }
}
