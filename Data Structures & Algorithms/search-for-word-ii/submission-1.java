class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
        int refs = 0;

        void add(String word, int index) {
            var cur = this;
            cur.refs++;

            for (var letter: word.toCharArray()) {
                int pos = letter - 'a';
                if (cur.children[pos] == null)
                    cur.children[pos] = new TrieNode();
                
                cur = cur.children[pos];
                cur.refs++;
            }

            cur.index = index;
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        var root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.add(words[i], i);
        }

        var indexes = new HashSet<Integer>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                match(board, row, col, root, words); 
            }
        }

        return res;
    }

    private void match(char[][] board, int row, int col, TrieNode node, String[] words) {
        if (row < 0 || row >= board.length) return;
        if (col < 0 || col >= board[row].length) return;
        if (board[row][col] == '*') return;

        var letter = board[row][col];
        var prev = node;
        node = node.children[letter - 'a'];
        if (node == null) return;

        var tmp = letter;
        board[row][col] = '*';

        if (node.index != -1) {
            res.add(words[node.index]);
            node.index = -1;
            node.refs--;

            if (node.refs == 0) {
                prev.children[letter - 'a'] = null;
                board[row][col] = tmp;
                return;
            }
        }

        match(board, row+1, col, node, words);
        match(board, row, col+1, node, words);
        match(board, row, col-1, node, words);
        match(board, row-1, col, node, words);

        board[row][col] = tmp;
    }
}
