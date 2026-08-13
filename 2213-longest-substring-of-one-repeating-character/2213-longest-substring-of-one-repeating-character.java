class Solution {

    class Node {
        int len;
        int prefix;
        int suffix;
        int best;
        char leftChar;
        char rightChar;

        Node() {}

        Node(char c) {
            len = 1;
            prefix = 1;
            suffix = 1;
            best = 1;
            leftChar = c;
            rightChar = c;
        }
    }

    char[] s;
    Node[] tree;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            this.s[index] = ch;

            update(1, 0, n - 1, index, ch);

            answer[i] = tree[1].best;
        }

        return answer;
    }

    // Build segment tree
    private void build(int node, int left, int right) {

        if (left == right) {
            tree[node] = new Node(s[left]);
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Update one character
    private void update(
            int node,
            int left,
            int right,
            int index,
            char ch) {

        if (left == right) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Merge two segments
    private Node merge(Node a, Node b) {

        Node res = new Node();

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        // Initially, best is from either side
        res.best = Math.max(a.best, b.best);

        // Prefix
        res.prefix = a.prefix;

        if (a.prefix == a.len && a.rightChar == b.leftChar) {
            res.prefix = a.len + b.prefix;
        }

        // Suffix
        res.suffix = b.suffix;

        if (b.suffix == b.len && a.rightChar == b.leftChar) {
            res.suffix = b.len + a.suffix;
        }

        // A repeating substring crossing the boundary
        if (a.rightChar == b.leftChar) {
            res.best = Math.max(
                    res.best,
                    a.suffix + b.prefix
            );
        }

        return res;
    }
}