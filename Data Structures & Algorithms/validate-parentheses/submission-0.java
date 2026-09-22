class Solution {

    private static final Map<Character, Character> symbols = Map.of(
        '(', ')',
        '[', ']',
        '{', '}'
    );

    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (symbols.containsKey(c)) {
                stack.push(symbols.get(c));
                continue;
            }

            if (symbols.containsValue(c)) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();

    }
}
